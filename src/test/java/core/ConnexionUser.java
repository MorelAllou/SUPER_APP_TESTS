package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import models.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AppiumDriverExt;
import utils.JsonReader;

import java.io.File;
import java.io.IOException;

public class ConnexionUser {

    public static void main(String[] args) throws IOException, ParseException {
        //Launch Application
        AppiumDriver<MobileElement> driver = AppiumDriverExt.getAppiumDriver();

        //Authentification
        MobileElement AllowButton = driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
        //Attendre que l'élément soit affiché
        WebDriverWait wait = new WebDriverWait(driver, 20L);
        wait.until(ExpectedConditions.visibilityOf(AllowButton));
        AllowButton.click();

        //Vérifier et cliquer sur le bouton Francais
        MobileElement Francais = driver.findElementByXPath("//android.view.View[@content-desc=\"Français\"]");
        Assert.assertTrue(Francais.isDisplayed(), "La Langue Francaise n'est pas affichée");
        Francais.click();

        //Vérifier et cliquer sur le bouton continuer
        MobileElement ContinueButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Continuer\"]");
        Assert.assertTrue(ContinueButton.isDisplayed(), "Le bouton Continuer n'est pas affiché");
        ContinueButton.click();

        //Vérifier et cliquer sur le bouton AccederCompte
        MobileElement AccessCptButton = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Accéder à mes comptes\"]");
        Assert.assertTrue(AccessCptButton.isDisplayed(), "Le bouton AccederCompte n'est pas affiché");
        AccessCptButton.click();
        System.out.println("Page d'authentification affichée");
        //Saisir login
        MobileElement PaysIcon = driver.findElementByXPath("//android.view.View[@content-desc=\"\uD83C\uDDE8\uD83C\uDDEE +225\"]");
        Assert.assertTrue(PaysIcon.isDisplayed(), "Le Pays n'est pas la Cote d'Ivoire");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login().click();
        loginPage.login().sendKeys(JsonReader.getTestData("login"));

        //Saisir Mot de passe
        loginPage.mdp().click();
        loginPage.mdp().sendKeys(JsonReader.getTestData("mdp"));
        // Envoyer le code de la touche Tabulation
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));

        //Vérifier et cliquer le bouton MeConnecter
        Assert.assertTrue(loginPage.BtnSeConnecter().isDisplayed(), "Le bouton Me connecter n'est pas affiché");
        // Faire une capture d'écran lorsque l'élément est visible
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Déplacer la capture d'écran vers un emplacement souhaité
        String screenshotPath = System.getProperty("user.dir") + "EVIDENCE_AFGEBANKCIV/ConnexionUtilisataur/Capture1.png";
        FileUtils.copyFile(screenshotFile, new File(screenshotPath));

        loginPage.BtnSeConnecter().click();
        System.out.println("Authentification effectuée");

        /* Check reconnaisance vocale(Don't Allow)*/
        MobileElement DntAllowButton = driver.findElementById("com.android.permissioncontroller:id/permission_deny_button");
        DntAllowButton.click();

        /* Check position (Allow)*/
        MobileElement AllowButton2 = driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
        AllowButton2.click();

        /*Check reconnaisance vocale(Don't Allow)
        MobileElement DntAllowButton2 = driver.findElementById("com.android.permissioncontroller:id/permission_deny_button");
        DntAllowButton2.click();
        Thread.sleep(3000);*/
        System.out.println("Permission accordée");
        //Mot de passe
        MobileElement ZeroButton = driver.findElementByXPath("//android.view.View[@content-desc=\"0\"]");
        Assert.assertTrue(ZeroButton.isDisplayed(), "Le bouton 0 est affiché");
        for (int i = 0; i < 4; i++) {
            ZeroButton.click();
        }
        //Vérifier Page repeter mot de passe
        Assert.assertTrue(ZeroButton.isDisplayed(), "Le bouton 0 est affiché");
        //Repeter mot de passe
        for (int i = 0; i < 4; i++) {
            ZeroButton.click();
        }

        System.out.println("Code validé");
        //Vérifiez que l'utilisateur est connecté à la page d'acceuil
        MobileElement Bonjour = driver.findElementByXPath("//android.view.View[@content-desc=\"Bonjour, \"]");
        Assert.assertTrue(Bonjour.isDisplayed(), "L'utilisateur n'est pas connecté à la page d'accueil");
        System.out.println("Utilisateur connecté");
        // Faire une capture d'écran lorsque l'élément est visible
        screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Déplacer la capture d'écran vers un emplacement souhaité
        screenshotPath = System.getProperty("user.dir") + "EVIDENCE_AFGEBANKCIV/ConnexionUtilisataur/Capture2.png";
        FileUtils.copyFile(screenshotFile, new File(screenshotPath));

        //Quitter l'application
        if (null != driver){
            driver.quit();
        }

    }
}