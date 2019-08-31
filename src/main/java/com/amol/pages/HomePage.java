package com.amol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.amol.base.Page;

public class HomePage extends Page
{
	public void goToSignup()
	{
		//driver.findElement(By.xpath(props.getProperty("FreeSignUp_xpath"))).click();
		click("FreeSignUp_xpath");
		log.info("Clicked on FreeSignup Page.....");
	}
	public LoginPage goToLogin()
	{
		//driver.findElement(By.xpath(props.getProperty("LoginText_xpath"))).click();
		click("LoginText_xpath");
		log.info("Clicked on Login link...........");
		return new LoginPage();
	}

	public void goTosuppot()
	{
		driver.findElement(By.xpath(props.getProperty("GoToSupport_xpath"))).click();
	}
	public void goToZohoEdu()
	{
		
	}
	
}
