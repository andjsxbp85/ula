package AndroidDriverAppium;

import Utils.data;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumConfig {
    Scenario scenario;
    boolean isAndroid = false;

    @Before
    public void initConfig(Scenario scenario){
        this.scenario = scenario;

        for(String tag : scenario.getSourceTagNames()){
            if(tag.toLowerCase().contains("android")){
                this.isAndroid = true;
                break;
            }
        }

        if(this.isAndroid){
            File f = new File(System.getProperty("user.dir")+"/src/test/resources/apk//");
            File fs = new File(f, data.fileApk);

            //Status Awal
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,data.deviceName);
            caps.setCapability(MobileCapabilityType.UDID,data.deviceID);
            caps.setCapability("appPackage",data.packages);
            caps.setCapability("appActivity",data.activity);
            caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
            //caps.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
            caps.setCapability(MobileCapabilityType.NO_RESET,true);

            try{DriverLocator.setTlDriver(new AndroidDriver(new URL(data.url),caps));}catch (MalformedURLException e){}
            DriverLocator.getTLDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        }
    }

    @After
    public void closeApps(Scenario scenario){
        if(this.isAndroid){
            AndroidDriver driver = DriverLocator.getTLDriver();
            driver.closeApp();
        }
    }
}
