package com.amol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.amol.base.Page;

public class SignUpPage extends Page {
	
	public void doSignIn(String username, String password)
	{
		driver.findElement(By.xpath("//input[@id=\"emailfield\"]")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);
		//driver.findElement(By.xpath("//div[@id=\"signin_submit\"]")).click();	
	}
}
