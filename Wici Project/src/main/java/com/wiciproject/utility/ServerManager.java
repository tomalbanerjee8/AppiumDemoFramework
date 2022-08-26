package com.wiciproject.utility;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServerManager {
	
	private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
	
	TestUtility utils = new TestUtility();
	/**
	 * getServer method will 
	 * return AppiumDriverLocalService  
	 * @return
	 */
	public AppiumDriverLocalService getServer(){
        return server.get();
    }
	
	/**
	 * startServer method will start AppiumDriverLocalService
	 * @throws IOException
	 */
    public void startServer() throws IOException{
        utils.log().info("starting appium server");
        //Set Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("noReset", "false");

        //Build the Appium service
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        builder.withCapabilities(caps);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        //Start the server with the builder
        AppiumDriverLocalService server = AppiumDriverLocalService.buildService(builder);
        server.start();               
        if(server == null || !server.isRunning()){
            utils.log().fatal("Appium server not started. ABORT!!!");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
        server.clearOutPutStreams();
        this.server.set(server);
        utils.log().info("Appium server started");
    }
    
	    /**
	     * stopServer method will stop the localAppiumServer
	     */
    	public void stopServer() {
    	if(getServer() != null){
           getServer().stop();
           utils.log().info("Appium server Stopped");
        }
    }

}
