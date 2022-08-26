package com.wiciproject.utility;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;
 
public class DriverCapabilities {
	TestUtility utils = new TestUtility();
	

    public DesiredCapabilities getCaps() throws IOException {
    	
        Properties props = new PropertyManager().getProps();

        try{
            utils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, props.getProperty("PlatformName"));
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("DeviceName"));
          
            switch(props.getProperty("PlatformName")){
                case "Android":
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.2.1.apk";
                    utils.log().info("appUrl is" + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    //caps.setCapability("systemPort", params.getSystemPort());
                    //caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
                    //String androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
                    break;
                case "iOS":
//                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
//                    //String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
//                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//                            + File.separator + "resources" + File.separator + "apps" + File.separator + "SwagLabsMobileApp.app";
//                    utils.log().info("appUrl is" + iOSAppUrl);
//                    caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
//                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
//                    caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
//                    caps.setCapability("app", iOSAppUrl);
                    break;
            }
            return caps;
        } catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
	
}
