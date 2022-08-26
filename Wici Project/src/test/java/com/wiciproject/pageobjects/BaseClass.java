package com.wiciproject.pageobjects;

import static java.time.Duration.ofMillis;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.wiciproject.utility.DriverManager;
import com.wiciproject.utility.TestUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class BaseClass {
	TestUtility utils = new TestUtility();
	 private AppiumDriver driver;

	    public BaseClass(){
	       this.driver = new DriverManager().getDriver();
	        PageFactory.initElements(driver,this);    
	    }
	   
}
