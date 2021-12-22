package Utils.Excel;

import Utils.Funct;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class poi extends Funct{
    HSSFWorkbook workbook;
    HSSFSheet spreadsheet;
    HSSFRow row;
    int limit;

    public poi(){
        workbook = new HSSFWorkbook();
        limit = 999;
    }

    public void setLimit(int limitDataColInARow){
        this.limit = limitDataColInARow;
    }

    public void createSpreadSheet(String sheetName){
        spreadsheet = workbook.createSheet(sheetName);
    }

    public void mergeCell(int firstRow, int lastRow, int firstCol, int lastCol){
        spreadsheet.addMergedRegion(new CellRangeAddress(firstRow,lastRow,firstCol,lastCol));
    }

    public void saveToExcel(String XLSResourcePathRoot, String xlsxName){
        //Write the workbook in file system
        File file = new File(System.getProperty("user.dir")+"/src/test/resources/" + XLSResourcePathRoot + File.separator + xlsxName);
        try{
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
            System.out.println(xlsxName+" written successfully");
        }catch (Exception e){}
    }

    public void csvToExcel(String CSVResourcePathRoot, String csvName, String sheetName){
        createSpreadSheet(sheetName);
        List <String> rowDataCSV = readFileToList(CSVResourcePathRoot, csvName);
        Map <String, Object[]> contents = new TreeMap< String, Object[] >();
        int baris = 0;
        for(String datas:rowDataCSV){
            Object[] data = datas.split(",",limit);
            contents.put(""+baris++, data);
            baris++;
        }

        //Iterate over data and write to sheet
        Set <String> keyid = contents.keySet();
        int rowid = 0;

        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = contents.get(key);
            int cellid = 0;

            for (Object obj : objectArr){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
    }
}
