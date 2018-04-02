package Lib;

public class ReadExcelDataa {
	public static void main(String[] args)
	{
		ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\ajinkya.bh\\Desktop\\TestData.xlsx");
		System.out.println(excel.getdata(1, 0, 1)); 
	}
}
