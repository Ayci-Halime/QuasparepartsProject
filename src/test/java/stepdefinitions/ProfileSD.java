package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProfilePage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class ProfileSD {

    ProfilePage profilePage;

    @And("Benutzer meldet sich an Profile")
    public void benutzerMeldetSichAnProfile() {
        profilePage=new ProfilePage();
        profilePage.loginMethodProfile(ParallelDriver.getDriver());

    }

    @And("Benutzer klickt auf die Schaltflaeche edit")
    public void benutzerKlicktAufDieSchaltflaecheEdit() {
        profilePage=new ProfilePage();
        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),profilePage.editButton,10);
        profilePage.editButton.click();

    }



    @Then("Benutzer bestaetigt, dass sich die E-Mail-Adresse nicht geaendert hat")
    public void benutzerBestaetigtDassSichDieEMailAdresseNichtGeaendertHat() {

        profilePage=new ProfilePage();
       Assert.assertFalse(profilePage.email.getTagName().contains("input"));
    }

    @When("Benutzer klickt auf dieSchaltflaeche Change Password")
    public void benutzerKlicktAufDieSchaltflaecheChangePassword() {

        profilePage=new ProfilePage();
        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),profilePage.changePasswordButton,10);
        profilePage.changePasswordButton.click();
    }

    @And("Benutzer gibt ein  {string} ein")
    public void benutzerGibtEinEin(String password) {

        profilePage=new ProfilePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.newPassword,10);
        profilePage.newPassword.sendKeys(password);
        profilePage.newPassword2.sendKeys(password);

    }

    @And("Benutzer klickt auf die Schaltflaeche Confirm")
    public void benutzerKlicktAufDieSchaltflaecheConfirm() {

        profilePage=new ProfilePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.confirm,10);
        profilePage.confirm.click();

    }

    @Then("Benutzer bestaetigt, Der Text {string} wurde angezeigt")
    public void benutzerBestaetigtDerTextChangePasswordSuccessfullyWurdeAngezeigt() {
        profilePage=new ProfilePage();
        String alertAcceptStr= ReusableMethods.getElementText(profilePage.alertAccept);

       Assert.assertEquals(alertAcceptStr,"Change password successfully");
    }

    @And("Benutzer klickt auf dieSchaltflaeche cancel")
    public void benutzerKlicktAufDieSchaltflaecheCancel() {
        profilePage=new ProfilePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.cancel,10);
        profilePage.cancel.click();
    }

    @And("Benutzer aktualisiert altes Passwort")
    public void benutzerAktualisiertAltesPasswort() {
        profilePage=new ProfilePage();
        profilePage.passwordAktualisieren(ParallelDriver.getDriver());
    }
}
