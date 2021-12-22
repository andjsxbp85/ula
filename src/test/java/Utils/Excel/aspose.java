package Utils.Excel;

import Utils.Funct;
import com.aspose.cells.FileFormatType;
import com.aspose.cells.LoadOptions;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;

public class aspose extends Funct {
    public aspose(){}
    //nama file xlsx = nama file csv, contoh fileini.csv >> fileini.xlsx
    public void convertCsvToExcel(String sourceCsvPath, String destinationXLSXPath){
        LoadOptions loadOptions = new LoadOptions(FileFormatType.CSV);
        try{
            Workbook workbook = new Workbook(sourceCsvPath, loadOptions);
            workbook.save(destinationXLSXPath, SaveFormat.XLSX);

        } catch (Exception e){e.printStackTrace();}
    }

    public void convertExcelToJava(String sourceXLSXPath, String destinationCsvPath){
        try{
            Workbook workbook = new Workbook(sourceXLSXPath);
            workbook.save(destinationCsvPath , SaveFormat.CSV);
        }catch (Exception e){e.printStackTrace();}
    }
}
