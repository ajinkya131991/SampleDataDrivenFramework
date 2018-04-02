package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelSheet {

	public static void main(String[] args)
	{
		try {
			File src = new File("C:\\Users\\ajinkya.bh\\Desktop\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(src);		
			XSSFWorkbook wb = new XSSFWorkbook(fis); // For .xlsx
			//HSSFWorkbook wb = new HSSFWorkbook(fis); // For .xlsx		
			XSSFSheet sh = wb.getSheetAt(0);	
			sh.getRow(0).createCell(2).setCellValue("Pass");
			sh.getRow(1).createCell(2).setCellValue("Fail");
			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
