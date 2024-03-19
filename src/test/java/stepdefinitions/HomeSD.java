package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class HomeSD {

    HomePage homePage;
    LoginPage loginPage;
    @Then("Benutzer bestaetigt, dass  das Nioyatech-Logo sichtbar ist")
    public void benutzerBestaetigtDassDasNioyatechLogoSichtbarIst() {
        homePage=new HomePage();
       Assert.assertTrue(homePage.nioyaTech.isDisplayed());

    }

    @And("Benutzer klickt auf das Nioyatech-Logo")
    public void benutzerKlicktAufDasNioyatechLogo() {
        homePage=new HomePage();
        homePage.nioyaTech.click();
    }

    @Then("Benutzer bestaetigt, dass er die Startseite anzeigt")
    public void benutzerBestaetigtDassErDieStartseiteAnzeigt() {
        loginPage=new LoginPage();
       // homePage=new HomePage();
       // ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.nioyaTech,10);


       Assert.assertTrue(loginPage.login.isDisplayed());


    }

    @Then("Benutzer bestaetigt, dass er die Seitenleiste unten links anzeigt")
    public void benutzerBestaetigtDassErDieSeitenleisteUntenLinksAnzeigt() {

        homePage=new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.menubarOk,10);
        Assert.assertTrue(homePage.menubarOk.isDisplayed());


    }

    @And("Benutzer klickt auf die Menubar")
    public void benutzerKlicktAufDieMenubar() {
        homePage=new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.menubarOk,10);
        homePage.menubarOk.click();
    }



    @Then("Benutzer bestaetigt, dass Menubar angezeigt wird")
    public void benutzerBestaetigtDassMenubarAngezeigtWird() {

        homePage=new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.profileText,10);
        Assert.assertTrue(homePage.profileText.isDisplayed());
    }


    @Then("Benutzer bestaetigt, dass er die E-Mail-Adresse in der oberen rechten Ecke sieht.")
    public void benutzer_bestaetigt_dass_er_die_e_mail_adresse_in_der_oberen_rechten_ecke_sieht() {
        homePage=new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.profilDropDown,10);
        String titel=homePage.profilDropDown.getText();
        Assert.assertTrue(titel.contains(ConfigReader.getProperty("username")));
    }

    @Then("Benutzer bestaetigt, dass sein Titel in der oberen rechten Ecke angezeigt wird")
    public void benutzerBestaetigtDassSeinTitelInDerOberenRechtenEckeAngezeigtWird() {

        homePage=new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.profilDropDown,10);
        String titel=homePage.profilDropDown.getText();
        Assert.assertTrue(titel.contains("Business Owner"));
    }

    @Then("Benutzer bestaetigt, dass er die E-Mail-Adresse in der oberen in DropDown sieht.")
    public void benutzerBestaetigtDassErDieEMailAdresseInDerOberenInDropDownSieht() {

        homePage=new HomePage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.profilEmailTitel,10);
        String titel=homePage.profilEmailTitel.getText();
        Assert.assertTrue(titel.contains(ConfigReader.getProperty("username")));

    }

    @Then("Benutzer bestaetigt, dass er die Titel in der oberen in DropDown sieht.")
    public void benutzerBestaetigtDassErDieTitelInDerOberenInDropDownSieht() {
        homePage=new HomePage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.profilEmailTitel,10);
        String titel=homePage.profilEmailTitel.getText();
        Assert.assertTrue(titel.contains("Business Owner"));

    }



    @And("Benutzer klickt auf das Menu Benutzerr")
    public void benutzerKlicktAufDasMenuBenutzerr()  {

        homePage=new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.profilDropDown,10);
        homePage.profilDropDown.click();


    }



    @Then("Benutzer bestaetigt,dass Menubar ausgeblendet wird")
    public void benutzer_bestaetigt_dass_menubar_ausgeblendet_wird() {
        homePage=new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.sidebar,10);
        String strMinimize=homePage.sidebar.getAttribute("class");
        System.out.println("strMinimize = " + strMinimize);
        Assert.assertTrue(strMinimize.contains("minimize"));

    }
}
