package com.wiciproject.runner;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.wiciproject.utility.DriverManager;
import com.wiciproject.utility.PropertyManager;
import com.wiciproject.utility.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber/report.html"
                , "me.jvt.cucumber.report.PrettyReports:target/cucumber-html-reports"}
        ,features = {"src/test/resources/feature"}
        ,glue = {"com.wiciproject.stepdefination"}
        ,tags ="@test")

public class TestRunner {
	
	 @BeforeClass
	    public static void initialize() throws Exception {
		 
		    Properties props = new PropertyManager().getProps();
	        ThreadContext.put("ROUTINGKEY", props.getProperty("PlatformName") + "_"
	                + props.getProperty("DeviceName"));
	        new ServerManager().startServer();   
	    }

	    @AfterClass
	    public static void quit() throws IOException{
	       new ServerManager().stopServer();   
		}
	    
	    
}
