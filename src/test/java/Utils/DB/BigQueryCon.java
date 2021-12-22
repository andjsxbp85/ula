package Utils.DB;

import Utils.database;
//import com.google.auth.oauth2.ServiceAccountCredentials;
//import com.google.cloud.bigquery.*;
import net.thucydides.core.pages.PageObject;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class BigQueryCon extends PageObject implements database {
//    BigQuery bigQ;
//    Dataset dataset;
//    String credential;
//    String dtSet;
//    String projectID;
//
//    public BigQueryCon(String pathInResources, String projectID, String datasetName){
//        String path = System.getProperty("user.dir")+"/src/test/resources/";
//        path += pathInResources;
//        this.credential = path;
//        this.dtSet = datasetName;
//        this.projectID = projectID;
//
//        try {
//            this.bigQ = BigQueryOptions.newBuilder().setProjectId(this.projectID).setCredentials(ServiceAccountCredentials.
//                    fromStream(new FileInputStream(this.credential))).build().getService();
//            this.dataset = this.bigQ.getDataset(this.dtSet);
//
//        }catch (Exception e){
//            System.out.println("Koneksi Bermasalah! ");
//            e.printStackTrace();
//        }
//    }
//
//    public void testConnection(){
//        try {
//            this.bigQ = BigQueryOptions.newBuilder().setProjectId(this.projectID).setCredentials(ServiceAccountCredentials.
//                    fromStream(new FileInputStream(this.credential))).build().getService();
//            if(this.bigQ!=null) System.out.println("Koneksi Sukses!");
//            System.out.printf("Dataset %s berhasil diperoleh%n", this.dataset.getDatasetId().getDataset());
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("Koneksi Bermasalah!");
//        }
//    }
//
//    public String getReturnSelectQuery(String query,String tableName, String... pemisahCol){
//        //Pemisah
//        String header = "#999#";
//        if(pemisahCol.length>0) header = pemisahCol[0];
//
//        //Get Column Name
//        String qColName = "SELECT column_name FROM "+projectID+"."+dtSet+".INFORMATION_SCHEMA.COLUMNS WHERE table_name = '"+tableName+"'";
//        List<String> colName = new ArrayList<>();
//        int i=0;
//        try{
//            QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(qColName).build();
//            for (FieldValueList row : bigQ.query(queryConfig).iterateAll()) {
//                colName.add(row.get(0).getStringValue());
//                i++;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        //Getting Data
//        String out = "";
//        try {
//            QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
//            for (FieldValueList row : bigQ.query(queryConfig).iterateAll()) {
//                for(int j=0;j<i;j++){ //for col
//                    try{out = out+colName.get(j)+": "+row.get(j).getStringValue()+header;}catch (NullPointerException e){out = out+colName.get(j)+": "+"NULL"+header;}
//                }
//                out = out+"\n";
//            }
//            if(out.lastIndexOf("\n") == out.length()-1) out.substring(0,out.length()-1);
//        }catch (BigQueryException | InterruptedException e){
//            System.out.println("Query gagal dijalankan!\n"+e.toString());
//        }
//
//        return out;
//    }
//
//
//    public List<String> getListSelectQuery(String query,String tableName, String... pemisahCol){
//        //Pemisah
//        String header = "#999#";
//        if(pemisahCol.length>0) header = pemisahCol[0];
//
//        //Get Column Name
//        String qColName = "SELECT column_name FROM "+projectID+"."+dtSet+".INFORMATION_SCHEMA.COLUMNS WHERE table_name = '"+tableName+"'";
//        List<String> colName = new ArrayList<>();
//        int i=0;
//        try{
//            QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(qColName).build();
//            for (FieldValueList row : bigQ.query(queryConfig).iterateAll()) {
//                colName.add(row.get(0).getStringValue());
//                i++;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        //Getting Data
//        List<String> retOut = new ArrayList<>();
//        String out = "";
//        try {
//            QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
//            for (FieldValueList row : bigQ.query(queryConfig).iterateAll()) {
//                out = "";
//                for(int j=0;j<i;j++){ //for col
//                    try{out += colName.get(j)+": "+row.get(j).getStringValue()+header;}catch (NullPointerException e){out += colName.get(j)+": "+"NULL"+header;}
//                }
//                retOut.add(out);
//            }
//        }catch (BigQueryException | InterruptedException e){
//            System.out.println("Query gagal dijalankan!\n"+e.toString());
//        }
//
//        return retOut;
//    }
}
