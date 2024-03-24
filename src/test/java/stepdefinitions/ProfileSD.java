package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProfilePage;
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
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.editButton,10);
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
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.changePasswordButton,10);
        profilePage.changePasswordButton.click();
    }

    @And("Benutzer gibt ein  {string} ein")
    public void benutzerGibtEinEin(String password) {

        profilePage=new ProfilePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.newPassword,10);
        profilePage.newPassword.sendKeys(password);


    }

    @And("Benutzer gibt ein  wiederholte {string} ein")
    public void benutzerGibtEinWiederholteEin( String password) {


        profilePage=new ProfilePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.newPassword2,10);
        profilePage.newPassword2.sendKeys(password);

    }

    @And("Benutzer gibt   {string} {string} ein")
    public void benutzerGibtEin( String password, String password2) {

        profilePage=new ProfilePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.newPassword,10);
        profilePage.newPassword.click();
        profilePage.newPassword.sendKeys(password);
        profilePage.newPassword2.click();
        profilePage.newPassword2.sendKeys(password2);


    }



    @And("Benutzer klickt auf die Schaltflaeche Confirm")
    public void benutzerKlicktAufDieSchaltflaecheConfirm() {

        profilePage=new ProfilePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.confirm,10);
        profilePage.confirm.click();

    }

    @And("Benutzer klickt auf dieSchaltflaeche cancel")
    public void benutzerKlicktAufDieSchaltflaecheCancel() {
        profilePage=new ProfilePage();

        try {
            profilePage.alertClose.click();
        }catch (Exception e) {

        }
    }


    @Then("Benutzer bestaetigt, Password wurde aktualisiert")
    public void benutzerBestaetigtPasswordWurdeAktualisiert() {

        profilePage=new ProfilePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.alertAccept,10);
        String alertAcceptStr= ReusableMethods.getElementText(profilePage.alertAccept);

        Assert.assertTrue(alertAcceptStr.contains("Change password successfully"));


    }



    @And("Benutzer aktualisiert altes Passwort")
    public void benutzerAktualisiertAltesPasswort() {

        profilePage=new ProfilePage();
        profilePage.passwordAktualisieren(ParallelDriver.getDriver());
    }


    @Then("Benutzer bestaetigt, Password wurde nicht aktualisiert")
    public void benutzerBestaetigtPasswordWurdeNichtAktualisiert() {
        profilePage=new ProfilePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.alert,10);
        Assert.assertTrue(profilePage.alertNegativeExpectedMessage(ParallelDriver.getDriver(),profilePage.alert));
    }

    @And("Benutzer klickt auf die dieSchaltflaeche cancel")
    public void benutzerKlicktAufDieDieSchaltflaecheCancel() {
        profilePage=new ProfilePage();
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),profilePage.cancel,10);
        profilePage.cancel.click();
    }
}
