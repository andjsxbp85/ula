package AndroidDriverAppium;

import Utils.WebExe;
import io.appium.java_client.android.AndroidDriver;

public class DriverLocator extends WebExe {
    private static ThreadLocal<AndroidDriver> tlDriver = new ThreadLocal<>();
    public static void setTlDriver(AndroidDriver driver){tlDriver.set(driver);}
    public static AndroidDriver getTLDriver(){return tlDriver.get();}
}
