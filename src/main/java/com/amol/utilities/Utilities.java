package com.amol.utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

import com.amol.base.Page;
//import com.relevantcodes.extentreports.LogStatus;

public class Utilities extends Page
{
	@DataProvider(name="dp")
	public Object[][] getData(Method m)
	{
		Object[][] data;
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		log.debug("rows="+rows);
		int cols = excel.getColumnCount(sheetName);
		log.debug("cols="+cols);
		
		data = new Object[rows-1][1];
		Hashtable<String,String>table=null;
		
		for(int rowNum = 1;rowNum<rows;rowNum++)
		{
			table = new Hashtable<String, String>();
			
			for(int colNum=0;colNum<cols;colNum++)
			{
				log.debug("   "+rowNum+"   "+colNum);
				table.put(excel.getCellData(sheetName, 0, colNum), excel.getCellData(sheetName, rowNum, colNum));
				data[rowNum-1][0]=table;
			}
		}
		return data;
	}
	
	public static void verifyEquals(String actual,String expected) throws IOException
	{
		try {
			  Assert.assertEquals(actual,expected);
		}
		catch(Throwable t) {
			captureScreenshot();
			//test.log(LogStatus.FAIL,"Failed..");
			//test.log(LogStatus.FAIL, test.addScreenCapture(System.getProperty("user.dir")+"\\Screenshots\\"+TestBase.screenshotName));
		}
	}
	
	public static boolean isTestRunnable(String testName,ExcelReader excel)
	{
		String sheetName ="test_suite";
		int rows=excel.getRowCount(sheetName);
		
		for(int row=1;row<=rows;row++)
		{
			String testcase = excel.getCellData(sheetName, row, 0);
			if(testcase.equalsIgnoreCase(testName)) {
				String runmode = excel.getCellData(sheetName, row, 1);
				if(runmode.equalsIgnoreCase("Y"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
		}
		return false;
		
	}
	
}
