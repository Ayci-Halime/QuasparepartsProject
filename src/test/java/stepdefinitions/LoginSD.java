package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;

public class LoginSD {
    LoginPage loginPage;
    HomePage homePage;


    @Given("Benutzer geht zur URL")
    public void benutzer_geht_zur_url() {

        ParallelDriver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Given("Benutzer klickt auf die Schaltflaeche Anmelden")
    public void benutzer_klickt_auf_die_schaltflaeche_anmelden() {
        loginPage = new LoginPage();
        loginPage.login.click();
    }

    @When("Benutzer gibt seine EMail oder Username ein {string}")
    public void benutzer_gibt_seine_e_mail_oder_username_ein(String username) {
        loginPage = new LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty(username));
    }

    @When("Benutzer gibt seinen Password ein {string}")
    public void benutzer_gibt_seinen_password_ein(String password) {
        loginPage = new LoginPage();
        loginPage.password.sendKeys(ConfigReader.getProperty(password));
    }

    @When("Benutzer klickt auf die Schaltflaeche Sigin")
    public void benutzer_klickt_auf_die_schaltflaeche_sigin() {
        loginPage = new LoginPage();
        loginPage.signin.click();
    }

    @Then("Benutzer prueft dass er angemeldet ist")
    public void benutzer_prueft_dass_er_angemeldet_ist() {
        homePage = new HomePage();
        Assert.assertTrue("Home button is not visible in homepage",homePage.home.isDisplayed());
    }

    @Then("Benutzer meldet sich ab")
    public void benutzer_meldet_sich_ab() {
        loginPage = new LoginPage();
        loginPage.logoutMethod(ParallelDriver.getDriver());
    }


    @When("Benutzer gibt E-Mail oder Username ein {string}")
    public void benutzerGibtEMailOderUsernameEin(String username) {
        loginPage = new LoginPage();
        loginPage.username.sendKeys(username);

    }

    @And("Benutzer gibt Password ein {string}")
    public void benutzerGibtPasswordEin(String password) {
        loginPage = new LoginPage();
        loginPage.password.sendKeys(password);
    }

    @Then("Benutzer bestaetigt dass er eine Felhlermeldung erhalten hat")
    public void benutzerBestaetigtDassErEineFelhlermeldungErhaltenHat() {
        loginPage = new LoginPage();
        String error  = "Invalid Credentials";
        Assert.assertEquals("Error message is not displayed",error,loginPage.errorMessage.getText());
    }

    @Then("Benutzer bestaetigt dass die Homepage angezeigt wird")
    public void benutzerBestaetigtDassDieHomepageAngezeigtWird() {
        homePage = new HomePage();
        Assert.assertTrue("Home button is not visible in homepage",homePage.home.isDisplayed());
    }
}
