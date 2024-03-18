package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;

public class LoginSD {
    LoginPage loginPage;

    @Given("Benutzer geht zur URL")
    public void benutzer_geht_zur_url() {

    }

    @Given("Benutzer klickt auf die Schaltflaeche Anmelden")
    public void benutzer_klickt_auf_die_schaltflaeche_anmelden() {

    }

    @When("Benutzer gibt seine EMail oder Username ein {string}")
    public void benutzer_gibt_seine_e_mail_oder_username_ein(String username) {

    }

    @When("Benutzer gibt seinen Password ein {string}")
    public void benutzer_gibt_seinen_password_ein(String password) {

    }

    @When("Benutzer klickt auf die Schaltflaeche Sigin")
    public void benutzer_klickt_auf_die_schaltflaeche_sigin() {

    }

    @Then("Benutzer prueft dass er angemeldet ist")
    public void benutzer_prueft_dass_er_angemeldet_ist() {

    }

    @Then("Benutzer meldet sich ab")
    public void benutzer_meldet_sich_ab() {
        loginPage.logoutMethod(ParallelDriver.getDriver());

    }


    @When("Benutzer gibt E-Mail oder Username ein {string}")
    public void benutzerGibtEMailOderUsernameEin(String username) {
        loginPage = new LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty(""));

    }

    @And("Benutzer gibt Password ein {string}")
    public void benutzerGibtPasswordEin(String password) {

    }

    @Then("Benutzer bestaetigt dass er eine Felhlermeldung erhalten hat")
    public void benutzerBestaetigtDassErEineFelhlermeldungErhaltenHat() {

    }

    @Then("Benutzer bestaetigt dass die Homepage angezeigt wird")
    public void benutzerBestaetigtDassDieHomepageAngezeigtWird() {
    }
}
