package com.amol.testcases;

import static org.testng.Assert.fail;

import java.util.Hashtable;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amol.base.Page;
import com.amol.pages.HomePage;
import com.amol.pages.LoginPage;
import com.amol.pages.ZohoAppPage;
import com.amol.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends TestBase
{
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void loginTest(Hashtable<String,String>data) throws InterruptedException
	{
		    HomePage hp = new HomePage();
	        LoginPage lp = hp.goToLogin();
	        
	        ZohoAppPage zp = lp.doLogin(data.get("username"),data.get("password"));
	        Thread.sleep(10000);
	        if(!lp.verifyLoginPageTitle())
	        {
	        	Page.sa.fail();
	        }
	        Page.test.log(LogStatus.INFO, "1st Verification...");
	        Page.driver.navigate().back();
	        Page.sa.fail();
	        Page.test.log(LogStatus.INFO, "2nd  Verification...");
	        Page.driver.navigate().back();
	        Page.sa.assertAll();
	     
	}

}
