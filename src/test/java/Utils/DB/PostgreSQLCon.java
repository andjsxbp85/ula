package Utils.DB;

import Utils.database;
import net.thucydides.core.pages.PageObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLCon extends PageObject implements database {
    Connection myConn;
    Statement myState;
    ResultSet res;
    String host;
    String dbName;
    String user;
    String pass;
    String url;

    public PostgreSQLCon(String ipAddress, String port, String database, String user, String pass){
        this.host = ipAddress+":"+port;
        this.user = user;
        this.pass = pass;
        this.dbName = database;
        this.url = "jdbc:postgresql://"+ipAddress+":"+port+"/"+database+"?serverTimezone=UTC";
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
        //Pemisah
        String header = "#999#";
        if(pemisahCol.length>0) header = pemisahCol[0];

        //Get Column Name
        String qColName = "SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = '"+tableName+"'";
        List<String> colName = new ArrayList<>();
        try {
            res = myState.executeQuery(qColName);
            while (res.next()){
                colName.add(res.getString(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        //Getting Data
        String out = "";
        try {
            res = myState.executeQuery(query);
            while (res.next()) {
                for(int j=0;j<colName.size();j++){ //for col
                    try{out = out+colName.get(j)+": "+res.getString(j+1)+header;}catch (SQLException e){e.printStackTrace();}
                }
                out = out.substring(0,out.length()-1)+"\n";
            }
            if(out.lastIndexOf("\n") == out.length()-1) out.substring(0,out.length()-1);
        }catch (SQLException e){
            System.out.println("Query gagal dijalankan!\n"+e.toString());
        }

        return out;
    }

    public List getListSelectQuery(String query, String tableName, String... pemisahCol){ //nanti pakai regex aja untuk cari tablenamenya
        //Pemisah
        String header = "#999#";
        if(pemisahCol.length>0) header = pemisahCol[0];

        //Get Column Name
        String qColName = "SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = '"+tableName+"'";
        List<String> colName = new ArrayList<>();
        try {
            res = myState.executeQuery(qColName);
            while (res.next()){
                colName.add(res.getString(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        //Getting Data
        String out = "";
        List<String> retOut = new ArrayList<>();
        try {
            res = myState.executeQuery(query);
            while (res.next()) {
                out = "";
                for(int j=0;j<colName.size();j++){ //for col
                    try{out = out+colName.get(j)+": "+res.getString(j+1)+header;}catch (SQLException e){e.printStackTrace();}
                }
                if(out.lastIndexOf(header)==out.length()-1) out = out.substring(0,out.length()-1);
                retOut.add(out);
            }
        }catch (SQLException e){
            System.out.println("Query gagal dijalankan!\n"+e.toString());
        }

        return retOut;
    }

    //====== Percobaan =======
    public String simple(String query){
        String out = "";
        try{
            res = myState.executeQuery(query);
            while (res.next()){
                out+=res.getString(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return out;
    }
}
