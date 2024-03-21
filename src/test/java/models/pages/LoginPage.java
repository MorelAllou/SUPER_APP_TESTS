package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.SendKeysAction;

public class LoginPage {

   /* LoginPage loginPage = new LoginPage(appiumDriver);
    loginPage.login().SendKeysAction("login");*/

    private AppiumDriver<MobileElement> appiumDriver;
    private final By loginSelByXpath = MobileBy.xpath("//android.widget.EditText[1]");
    private final By mdpSelByXpath = MobileBy.xpath("//android.widget.EditText[2]");
    private final By BtnSeConnecterSelByXpath = MobileBy.xpath("//android.widget.Button[@content-desc=\"Me connecter\"]");
    public LoginPage(AppiumDriver<MobileElement> appiumDriver){

        this.appiumDriver = appiumDriver;
    }
    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }
    public MobileElement login() {
        return appiumDriver.findElement(loginSelByXpath);
    }
    public MobileElement mdp() {
        return appiumDriver.findElement(mdpSelByXpath);
    }
    public MobileElement BtnSeConnecter() {
        return appiumDriver.findElement(BtnSeConnecterSelByXpath);
    }
}
