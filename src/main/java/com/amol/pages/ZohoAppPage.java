package com.amol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.amol.base.Page;

public class ZohoAppPage extends Page {
	public void goToChat()
	{
		
	}
	public void goToCRM()
	{
		//driver.findElement(By.xpath("//div[text()='CRM']")).click();
		click("CRMLink_xpath");
		log.debug("Moved to CRM page.....");
	}
	
	public void goToSalseIQ()
	{
		
	}

}
