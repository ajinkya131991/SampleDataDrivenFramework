package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig 
{
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	
	public ExcelDataConfig(String excelpath) 
	{
		try {
			File src = new File(excelpath);
			 fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis); // For .xlsx 
			//HSSFWorkbook wb = new HSSFWorkbook(fis); // For .xlsx	 
			} 
		catch (FileNotFoundException e) {			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public  int getrowcount(int SheetIndex)
	{
		int row1 = wb.getSheetAt(SheetIndex).getLastRowNum();
		row1=row1+1;
		return row1;
	}
	
	public String getdata(int sheet,int row, int column)
	{
		sh = wb.getSheetAt(sheet);
		String data = sh.getRow(row).getCell(column).getStringCellValue();
		return data;	
	}
}
