package com.wiciproject.utility;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public class DriverManager {
	TestUtility utils = new TestUtility();
	
	 private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
	
	/**
	 * getDriver method will return AppiumDriver object
	 * 
	 */
	public AppiumDriver getDriver(){
        return driver.get();
    }
	
	/**
	 * setDriver method is to setting us AppiumDriver driver object
	 * 
	 */
    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }
    
    /**
     * initializeDriver method is to initialize a driver
     * @throws Exception
     */

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        Properties props = new PropertyManager().getProps();
        if(driver == null){
            try{
                utils.log().info("initializing Appium driver");
                switch(props.getProperty("PlatformName")){
                    case "Android":
                        driver = new AndroidDriver(new URL(props.getProperty("appiumURL")), new DriverCapabilities().getCaps());
                        break;
                    case "iOS":
                        driver = new IOSDriver(new URL(props.getProperty("appiumURL")), new DriverCapabilities().getCaps());
                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }
                utils.log().info("Driver is initialized");
                this.driver.set(driver);
                utils.waitForPageLoad(10);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
                throw e;
            }
        }

    }
    
    /**
     * quitDriver method is used to quit 
     * driver and set driver object to null
     */
    
    public void quitDriver() {
    if(getDriver() != null){
       getDriver().quit();
       setDriver(null);
       utils.log().info("Driver is closed and set to null");
    	}
    }
	
}
