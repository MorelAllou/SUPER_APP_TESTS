package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverExt {

    public static AppiumDriver<MobileElement> getAppiumDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformVersion","14.0");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("appPackage","com.afg.ebank");
        caps.setCapability("appActivity","MainActivity");
        //driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps) ;

        //Create an instance of AppiumDriver
        AppiumDriver<MobileElement> driver = null;

        try{
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps) ;
            driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

}
