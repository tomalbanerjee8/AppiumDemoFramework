package com.wiciproject.stepdefination;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.wiciproject.genericmethod.BaseUtil;
import com.wiciproject.utility.DriverManager;
import com.wiciproject.utility.PropertyManager;
import com.wiciproject.utility.ServerManager;
import com.wiciproject.utility.TestUtility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks{

	public Scenario scenario;
	@Before
    public void eachStep(Scenario scenario) throws Exception {
			new DriverManager().initializeDriver();
        	byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png", scenario.getName());
        	
        }
	@AfterStep
    public void AftereachStep(Scenario scenario) throws IOException, WebDriverException {
        	byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png", scenario.getName());
        }
	  @After
	    public void quit(Scenario scenario) throws IOException, WebDriverException {
	        if(scenario.isFailed()){
	        	byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
	        	scenario.attach(screenshot, "image/png", scenario.getName());
	        }  
	  Properties props = new PropertyManager().getProps();
	    new DriverManager().getDriver().removeApp(props.getProperty("androidAppPackage"));
	  }
}
