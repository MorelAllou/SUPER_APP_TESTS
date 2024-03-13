package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import utils.AppiumDriverExt;

import java.net.MalformedURLException;
import java.net.URL;
public class DeconnexionUser {

    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> driver = AppiumDriverExt.getAppiumDriver();
        //Deconnexion Utilisateur
        MobileElement IconProfil = driver.findElementByXPath("//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]");
        Assert.assertEquals(IconProfil.isDisplayed(), true, "L'utilisateur n'est pas connecté à la page d'accueil");
        System.out.println("Utilisateur connecté");
        Thread.sleep(2000);
        IconProfil.click();
        Thread.sleep(2000);
        MobileElement DeconnexionButton = driver.findElementByXPath("//android.view.View[@content-desc=\"Déconnexion\"]");
        DeconnexionButton.click();
        Thread.sleep(3000);
        //Vérifier Page de choix de langue
        MobileElement Francais = driver.findElementByXPath("//android.view.View[@content-desc=\"Français\"]");
        Assert.assertEquals(Francais.isDisplayed(), true, "La Langue Francaise n'est pas affichée");
        System.out.println("Utilisateur Deconnecté");
        //Quitter l'application
        driver.quit();

    }
}