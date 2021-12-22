package Utils.DB;

import Utils.database;
import net.thucydides.core.pages.PageObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.jcraft.jsch.Session;

public class MySQLCon extends PageObject implements database {
    Connection myConn;
    Statement myState;
    ResultSet res;
    Session session;
    String host;
    String dbName;
    String user;
    String pass;
    String url;

    public MySQLCon(String ipAddress, String port, String database, String user, String pass){
        this.host = ipAddress+":"+port;
        this.user = user;
        this.pass = pass;
        this.dbName = database;
        this.url = "jdbc:mysql://"+ipAddress+":"+port+"/"+database+"?serverTimezone=UTC";
        try{
            this.myConn = DriverManager.getConnection(this.url,user,pass);
            this.myState = myConn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

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
            myState.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getReturnSelectQuery(String query,String tableName, String... pemisahCol){ //nanti pakai regex aja untuk cari tablenamenya
        String header = "#999#";
        if(pemisahCol.length>0) header = pemisahCol[0];
        String numOfCol = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_schema = '"+this.dbName+"' AND table_name = '"+tableName+"'";
        String returnMsg = ""; int col = 0;
        try{
            this.res = myState.executeQuery(numOfCol);
            if(res.next()) col = res.getInt(1);
            System.out.println("Jumlah kolom ="+col);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            this.res = myState.executeQuery(query);
            if(res.next()){
                for(int i=1;i<=col;i++){
                    if(i==1) returnMsg = returnMsg+res.getString(i);
                    else returnMsg = returnMsg+header+res.getString(i);
                }
            }
            while (res.next()){
                returnMsg = returnMsg+"\n";
                for(int i=1;i<=col;i++){
                    if(i==1) returnMsg = returnMsg+res.getString(i);
                    else returnMsg = returnMsg+header+res.getString(i);
                }
            }
            if(returnMsg.lastIndexOf("\n") == returnMsg.length()-1) returnMsg.substring(0,returnMsg.length()-1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMsg;
    }

    public List getListSelectQuery(String query, String tableName, String... pemisahCol){ //nanti pakai regex aja untuk cari tablenamenya
        String header = "#999#";
        if(pemisahCol.length>0) header = pemisahCol[0];
        String numOfCol = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_schema = '"+this.dbName+"' AND table_name = '"+tableName+"'";
        String returnMsg = ""; int col = 0;
        List<String> hasil = new ArrayList<>();
        try{
            this.res = myState.executeQuery(numOfCol);
            if(res.next()) col = res.getInt(1);
            System.out.println("Jumlah kolom ="+col);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            this.res = myState.executeQuery(query);
            while (res.next()){
                returnMsg = "";
                for(int i=1;i<=col;i++){
                    if(i==1) returnMsg = returnMsg+res.getString(i);
                    else returnMsg = returnMsg+header+res.getString(i);
                }
                hasil.add(returnMsg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return hasil;
    }

    //====== Percobaan =======
    public void kosong(){
        String URL = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=data-platform-bq;OAuthType=0;OAuthServiceAcctEmail=erp-hermes@data-platform-bq.iam.gserviceaccount.com;OAuthPvtKeyPath=/Users/anjasmuhammadbangun/desktop/DB Credentials Prod/Hermes-Key_SA.json";
        String URL2 = "jdbc:mysql://35.240.184.224:3306/hermes21?autoReconnect=true&useSSL=false";
        String URL3 = "jdbc:mysql://35.240.184.224:3306/hermes21?serverTimezone=UTC";
        String user = "readonly";
        String pass = "vXQ5rNtMaMnWuDac!";
        try{
            System.out.println("BERHASIL 1");
            Connection myConn = DriverManager.getConnection(URL3,user,pass);
            System.out.println("BERHASIL 2");
            Statement myState = myConn.createStatement();
            System.out.println("BERHASIL 3");
            String query = "SELECT * FROM products LIMIT 50";
            System.out.println("BERHASIL 4");
            ResultSet res = myState.executeQuery(query);
            System.out.println("BERHASIL 5");
            while (res.next()){
                System.out.println("BERHASIL 6");
                System.out.println(res.getString("name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
