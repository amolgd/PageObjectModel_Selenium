package com.amol.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.amol.base.Page;

public class TestBase 
{

	 @AfterSuite
	 public void tearDown()
	 {
		 Page.quit();
	 }
}
