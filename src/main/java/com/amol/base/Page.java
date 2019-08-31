package com.amol.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.amol.utilities.ExcelReader;
import com.amol.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class Page
{
       public static WebDriver driver;
       public static Properties config = new Properties() ;
       public static Properties props = new Properties();
       public  FileInputStream fis;
       public static Logger log = Logger.getLogger("devpinoyLogger");
       public static ExcelReader excel; 
       public static String screenshotName;
       public ExtentReports rep = ExtentManager.getInstance();
   	   public static ExtentTest test;
   	   public static SoftAssert sa = new SoftAssert();

       public Page() 
       {
    	   if(driver==null)
    	   {
    		   excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\Data.xlsx");
    		   String log4jConfPath = System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\log4j.properties";
    		   PropertyConfigurator.configure(log4jConfPath);
    		   
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	  try {
				config.load(fis);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	   
        	  try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           try {
			props.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");
           driver = new ChromeDriver();
           log.info("Chrome driver created.........");
           driver.get(config.getProperty("testURL"));
           log.info("URL launched........");
           driver.manage().window().maximize();
    	   }
       }
       
       public static void quit()
       {
    	   if(driver!=null)
    	   {
    	   driver.quit();
    	   }
       }
       
       public static void click(String orProps)
       {
    	   if(orProps.endsWith("_xpath"))
    	   {
    		   
    		   driver.findElement(By.xpath(props.getProperty(orProps))).click();
    	   }
       }
       public static void type(String orProps,String val)
       {
    	   if(orProps.endsWith("_xpath"))
    	   {
    		   driver.findElement(By.xpath(props.getProperty(orProps))).clear();
    		   driver.findElement(By.xpath(props.getProperty(orProps))).sendKeys(val);
    	   }
       }
       
       public static void captureScreenshot() throws IOException
    	{
   		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   		screenshotName = (new Date()).toString().replace(" ", "_").replace(":", "-")+".jpg";
   		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\"+screenshotName));
    	}

}
