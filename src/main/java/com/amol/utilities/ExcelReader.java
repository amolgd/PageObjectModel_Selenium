package com.amol.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fout =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet =null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
   public ExcelReader(String path)
   {
	   this.path = path;
	   try {
		   fis = new FileInputStream(path);
		   workbook = new XSSFWorkbook(fis);
		   sheet = workbook.getSheetAt(0);
		   fis.close();
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
   }

   public int getRowCount(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else{
		sheet = workbook.getSheetAt(index);
		int number=sheet.getLastRowNum()+1;
		return number;
		}
	}
	
   public int getColumnCount(String sheetName){
		// check if sheet exists
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		
		if(row==null)
			return -1;
		return row.getLastCellNum();	
	}
   
   public String getCellData(String sheetName,int r,int c)
   {
	   String data = null;
	   sheet = workbook.getSheet(sheetName);
	   row = sheet.getRow(r);

	   cell = row.getCell(c);
	
	   if(cell.getCellType()==CellType.STRING)
	   {
		  data = cell.getStringCellValue();
	   }
	   else if(cell.getCellType()==CellType.NUMERIC)
	   {
		  data = String.valueOf(cell.getNumericCellValue());
	   }
	   else {
		   data = "abc";
	   }
	   return data;     
   }
   
}
