package com.wiciproject.genericmethod;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wiciproject.pageobjects.LoginPage;
import com.wiciproject.utility.DriverManager;
import com.wiciproject.utility.TestUtility;



public class GenericMethods {
	TestUtility utils = new TestUtility();
	
	public String getText(WebElement element) {
		utils.waitForPageLoad(10);
		return element.getText();
	}
	
	
	
}
