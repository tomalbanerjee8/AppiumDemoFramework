package com.wiciproject.utility;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestUtility {
	public static final long WAIT = 10;
	/**
	 * dateTime method will return 
	 * date & time as (yyyy-MM-dd-HH-mm-ss) formate
	 * @return
	 */
	public String dateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * log method is ised to log some information
	 * @return
	 */
	
	public Logger log() {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
	
	/**
	 * waitForPageLoad method will 
	 * wait for certain timeUnits
	 */
	
	public void waitForPageLoad(int timeUnits) {
		new DriverManager().getDriver().manage().timeouts().implicitlyWait(timeUnits, TimeUnit.SECONDS);
	}
	
	/**
	 * waitForExpectedElement method will wait for 
	 * certain timeUnits for provided expected elements
	 */
	
	public void waitForExpectedElement(int timeUnits,String locator) {
		WebDriverWait wait = new WebDriverWait(new DriverManager().getDriver(),timeUnits);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));		
		
	}

}
