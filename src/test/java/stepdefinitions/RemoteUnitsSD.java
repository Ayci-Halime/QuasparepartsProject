package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.RemoteUnitsPage;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class RemoteUnitsSD {

    RemoteUnitsPage remoteUnitsPage;
    HomePage homePage;
    @When("Benutzer klickt auf dieSchaltflaeche RemoteUnits")
    public void benutzerKlicktAufDieSchaltflaecheRemoteUnits() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        remoteUnitsPage=new RemoteUnitsPage();
        homePage=new HomePage();
        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),homePage.remoteUnits,10);
        homePage.remoteUnits.click();


    }


    @Then("Benutzer bestaetigt, dass sich die RemoteUnit {string} betrachtet")
    public void benutzerBestaetigtDassSichDieRemoteUnitBetrachtet(String ActRemoteUnit) {

        remoteUnitsPage=new RemoteUnitsPage();
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.remoteUnits.get(0),10);
        Assert.assertTrue(remoteUnitsPage.ilkRemoteUnit.getText().contains(ActRemoteUnit));


    }

    @And("Benutzer klickt auf dieSchaltflaeche Add new Remote Unit")
    public void benutzerKlicktAufDieSchaltflaecheAddNewRemoteUnit() {

        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),remoteUnitsPage.addNewRemoteUnitButton,10);
        remoteUnitsPage.addNewRemoteUnitButton.click();
    }

    @And("Benutzer gibt den Abteilungsnamen {string} ein")
    public void benutzerGibtDenAbteilungsnamenEin(String arg0) {
        remoteUnitsPage=new RemoteUnitsPage();
       // ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),remoteU,10);
        remoteUnitsPage.addNewRemoteUnitButton.click();

    }

    @And("Benutzer waehlt als Abteilungstyp Remote-Unit aus")
    public void benutzerWaehltAlsAbteilungstypRemoteUnitAus() {
    }

    @And("Benutzer klickt auf dieSchaltflaeche save")
    public void benutzerKlicktAufDieSchaltflaecheSave() {
    }




    @And("Benutzer loescht die hinzugefuegte Remote Unit {string}")
    public void benutzerLoeschtDieHinzugefuegteRemoteUnit(String newRemoteUnit) {
    }
}
