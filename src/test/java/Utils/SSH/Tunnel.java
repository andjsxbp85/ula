package Utils.SSH;

import Utils.WebExe;
import Utils.database;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Tunnel extends WebExe implements database {
    String host;
    String user;
    String pass;
    String keyPath;
    String tunnelHost;
    String tunnelUser;
    int tunnelPort;
    int forwardPort;
    ChannelExec channels;
    Session session;
    String returnValue;
    public Tunnel(String lUser, String lHost, String lKeypath, int tunnelPort){
        this.user = lUser;
        this.host = lHost;
        this.keyPath = lKeypath;
        this.tunnelPort = tunnelPort;
        this.forwardPort = randomizerInt(3000,6000);
    }

    public void tunnelConnect(){
        JSch jsch = new JSch();
        try {
            //Connect to left host
            jsch.addIdentity(keyPath);
            session = jsch.getSession(user, host, 22);
            session.setConfig("PreferredAuthentications", "publickey,password,keyboard-interactive");
            //Set StrictHostKeyChecking property to no to avoid UnknownHostKey issue
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println("Connected To Left Host");

//            //Connect To Right Host (Tunnel)
//            session.setPortForwardingL(forwardPort, tunnelHost, tunnelPort);
//            System.out.println("localhost:" + forwardPort + " -> " + tunnelHost + ":" + tunnelPort);
//            System.out.println("Port Forwarded");
        }catch (Exception e){e.printStackTrace();}
    }

    public String sendCommand(String... command){
        //Configure command
        returnValue = "";
        String perintah = "";
        for(int i=0; i<command.length; i++){
            command[i] = command[i].replaceAll("\\;\\s{0,}$","");
            perintah = perintah+command[i]+"; ";
        }

        if (!session.isConnected()) throw new RuntimeException("Not connected to an open session.  Call open() first!");

        //Send command via tunnel
        System.out.println("Sending perintah...");
        try {
            channels = (ChannelExec) session.openChannel("exec");
            channels.setInputStream(null);
            PrintStream out = new PrintStream(channels.getOutputStream());
            channels.setCommand(perintah);
            InputStream in = channels.getInputStream(); // channel.getInputStream();

            channels.connect();

            // you can also send input to your running process like so:
            // String someInputToProcess = "something";
            // out.println(someInputToProcess);
            // out.flush();

            returnValue = getChannelOutput(channels, in);

            System.out.println("Finished sending commands!");
        }catch (Exception e){}
        return returnValue;
    }

    public void closeConnection(){
        try{
            session.disconnect();
            channels.disconnect();
            session = null;
            channels = null;
        }catch (Exception e){}
    }

    //================================================ Support Function ================================================
    private String getChannelOutput(Channel channel, InputStream in) throws IOException {

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
}
