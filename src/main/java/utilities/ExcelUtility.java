package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	XSSFWorkbook wb;
    XSSFSheet sheet1;   

    public ExcelUtility(String excelPath)
    {
       try
           {
              File src=new File(excelPath);
              FileInputStream fis=new FileInputStream(src);
              wb=new XSSFWorkbook(fis);
           }
           catch(Exception e){
                  System.out.println(e.getMessage());
           }
    }

    public String getData(String sheetName,int row,int column)
    {
           sheet1=wb.getSheet(sheetName);
           XSSFCell cell=sheet1.getRow(row).getCell(column);
           if (cell.getCellType()==CellType.NUMERIC)
              return String.valueOf(cell.getNumericCellValue());
           else
              return cell.getStringCellValue();
    }
}
