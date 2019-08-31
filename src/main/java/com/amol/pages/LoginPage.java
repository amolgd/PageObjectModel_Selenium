package com.amol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.amol.base.Page;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends Page
{
	public ZohoAppPage doLogin(String username,String password)
	{
		//driver.findElement(By.xpath(props.getProperty("UserNameTextField_xpath"))).sendKeys(username);
		type("UserNameTextField_xpath",username);
		log.debug("Entered Username...");
		
	   // driver.findElement(By.xpath(props.getProperty("Password_xpath"))).sendKeys(password);
	    type("Password_xpath",password);
	    log.debug("Entered Password...");
	    
		driver.findElement(By.xpath(props.getProperty("SubmitButton_xpath"))).click();
		click("SubmitButton_xpath");
		log.debug("Clicked on Submit Button.....");
		return new ZohoAppPage();
	}
	
	public void refreshLoginPage()
	{
		driver.navigate().refresh();
	}
	
	public Boolean verifyLoginPageTitle()
	{
		
		try {
			String ac = "Zoho Home";
			System.out.println(driver.getTitle());
			System.out.println(ac);
			Assert.assertEquals(driver.getTitle(),ac);
			return true;
		}catch(Throwable t)
		{
			System.out.println("In Catch");
			test.log(LogStatus.FAIL, "Invalid Credentials...");
			return false;
		}
	}

}
