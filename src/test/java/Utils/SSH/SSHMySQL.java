package Utils.SSH;

import Utils.WebExe;
import Utils.database;
import com.jcraft.jsch.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SSHMySQL extends WebExe implements database {
    Connection myConn;
    Statement myState;
    ResultSet res;
    Session session;
    Channel channel;
    ChannelExec channels;
    String host;
    String dbName;
    String user;
    String pass;
    String url;

    //SSH Using Private Key >> not support on openssh current version > must re generate ssh key
    public SSHMySQL(String sshHost, String sshUser, String keyFilePath, String dbHost, int dbPort, String dbUser, String dbPass, String dbName){
        //Create random localport
        int randport = randomizerInt(3000,6000);

        //Set All to be null (clean data)
        myConn = null;
        session= null;

        //SSH Forwarding
        try{
            JSch jsch = new JSch();
            jsch.addIdentity(keyFilePath);
            session=jsch.getSession(sshUser, sshHost, 22);
            session.setConfig("PreferredAuthentications", "publickey,password,keyboard-interactive");
            //Set StrictHostKeyChecking property to no to avoid UnknownHostKey issue
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println("Connected");
            int assinged_port=session.setPortForwardingL(randport, dbHost, dbPort);
            System.out.println("localhost:"+assinged_port+" -> "+dbHost+":"+dbPort);
            System.out.println("Port Forwarded");

            //mysql database connectivity
            String url = "jdbc:mysql://localhost:"+assinged_port+"/"+dbName+"?serverTimezone=UTC";
            Class.forName(_dbDriverName).newInstance();
            myConn = DriverManager.getConnection (url, dbUser, dbPass);

        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                if (myConn != null && !myConn.isClosed()) {
                    System.out.println("DB Connected");
                    //myConn.close();
                }
                if (session != null && session.isConnected()) {
                    System.out.println("SSH Connected");
                    //session.disconnect();
                }
            }catch (Exception e){}
        }
    }

    public void closeConnection(){
        try{
            myConn.close();
            session.disconnect();
            channel.disconnect();
            channels.disconnect();
        }catch (Exception e){}
    }


    //================================================  Database MySQL ================================================
    public boolean testConnection(){
        try{
            this.myConn = DriverManager.getConnection(this.url,this.user,this.pass);
            this.myState = myConn.createStatement();
            System.out.println("Koneksi Sukses!");
            return true;
        }catch (Exception e){
            System.out.println("Koneksi Bermasalah!\n");
            e.printStackTrace();
            return false;
        }
    }

    public void pushQuery(String query){
        try{
            this.myState =this.myConn.createStatement();
            System.out.println ("Database connection established");
            System.out.println("DONE");

            myState.execute(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public HashMap getMapQuery(String query, String dbName, String tableName, String... pemisahCol){ //nanti pakai regex aja untuk cari tablenamenya
        String header = "#999#";
        if(pemisahCol.length>0) header = pemisahCol[0];
        String numOfCol = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_schema = '"+dbName+"' AND table_name = '"+tableName+"';";
        int col = 0;
        HashMap hasil = new HashMap();

        try{
            this.myState =this.myConn.createStatement();
            this.res = myState.executeQuery(numOfCol);
        }catch (SQLException e){}
        try{
            if(this.res.next()) col = res.getInt(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            this.myState =this.myConn.createStatement();
            this.res = myState.executeQuery(query);
            int j = 0;
            while (res.next()){
                List<String> eachCol = new ArrayList<>();
                for(int i=1;i<=col;i++){
                    try{ eachCol.add(res.getString(i)); }catch (SQLException e1){} //bisa jadi out of index klo dia select from {milih kolom mana aja} > sehingga jumlah col jadi beda
                }
                hasil.put(j,eachCol);
                j++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return hasil;
    }

    //==================================================  SSH Command ==================================================
    public SSHMySQL(String sshHost, String sshUser, String keyFilePath){
        //Connect To SSH
        JSch jsch = new JSch();
        session = null;
        try {
            jsch.addIdentity(keyFilePath);
            session = jsch.getSession(sshUser, sshHost, 22);
            session.setConfig("PreferredAuthentications", "publickey,password, keyboard-interactive");
            session.setConfig("StrictHostKeyChecking", "no");
        } catch (JSchException e) {
            throw new RuntimeException("Failed to create Jsch Session object.", e);
        }

        try {
            session.connect();
            System.out.println("Connected");
        } catch (JSchException e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
    }

    //Semicolon (;) di paling belakang kalau multiple command tapi jadi satu raw command (gk jadi array command), wjib dihapus
    //karena paling belakang tiap command dikasih semicolon
    public String sendCommand(String... command){
        //Check Connection
        String ret = "";

        if (!session.isConnected()) throw new RuntimeException("Not connected to an open session.  Call open() first!");

        String perintah = "";
        for(int i=0; i<command.length; i++){
            perintah = perintah+command[i]+"; ";
        }

        System.out.println("Sending perintah...");
        try {
            channels = (ChannelExec) session.openChannel("exec");

            //channels.setInputStream(null);
            PrintStream out = new PrintStream(channels.getOutputStream());
            channels.setCommand(perintah);
            InputStream in = channels.getInputStream(); // channel.getInputStream();

            channels.connect();

            // you can also send input to your running process like so:
            // String someInputToProcess = "something";
            // out.println(someInputToProcess);
            // out.flush();

            ret = getChannelOutput(channels, in);

            System.out.println("Finished sending commands!");
        }catch (Exception e){}
        return ret;
    }

    public String sendCommandOneSessionMultipleChanel(String... command){
        //Check Connection
        String ret = "";

        if (!session.isConnected()) throw new RuntimeException("Not connected to an open session.  Call open() first!");

        String perintah = "";
        for(int i=0; i<command.length; i++){
            perintah = perintah+command[i]+"; ";
        }

        System.out.println("Sending perintah: "+perintah);
        try {
            channel = session.openChannel("shell");

            //channels.setInputStream(null);
            OutputStream ops = channel.getOutputStream();
            PrintStream ps = new PrintStream(ops,true);

            channel.connect();
            InputStream in = channel.getInputStream(); // channel.getInputStream();
            ps.println(perintah);

            ret = shellOneSessionMultipleChannelResult(in);

            System.out.println("Finished sending commands!");
        }catch (Exception e){}
        return ret;
    }

    private String getChannelOutput(Channel channel, InputStream in) throws IOException{

        byte[] buffer = new byte[1024];
        StringBuilder strBuilder = new StringBuilder();

        String line = "";
        while (true){
            while (in.available() > 0) {
                int i = in.read(buffer, 0, 1024);
                if (i < 0) {
                    break;
                }
                strBuilder.append(new String(buffer, 0, i));
                System.out.println(line);
            }

            if(line.contains("logout")){
                break;
            }

            if (channel.isClosed()){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee){}
        }

        return strBuilder.toString();
    }

    private String shellOneSessionMultipleChannelResult(InputStream input) {
        StringBuilder strBuilder = new StringBuilder();

        int SIZE = 1024;
        byte[] tmp = new byte[SIZE];
        try{
            while (input.available() > 0) {
                int i = input.read(tmp, 0, SIZE);
                if(i < 0) break;
                strBuilder.append(new String(tmp, 0, i));
                Thread.sleep(300);
            }
        } catch (Exception e){}
        return strBuilder.toString();
    }
}
