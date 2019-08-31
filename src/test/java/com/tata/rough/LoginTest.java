package com.tata.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amol.base.Page;
import com.amol.pages.HomePage;
import com.amol.pages.LoginPage;
import com.amol.pages.SignUpPage;
import com.amol.pages.ZohoAppPage;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        HomePage hp = new HomePage();
        LoginPage lp = hp.goToLogin();
        
        ZohoAppPage zp = lp.doLogin(Page.config.getProperty("userName"),Page.config.getProperty("password") );
        Thread.sleep(1000);
        zp.goToCRM();
        
        Page.driver.close();
	}

}
