package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.ProfilePage;
import pages.RemoteUnitsPage;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class RemoteUnitsSD {

    RemoteUnitsPage remoteUnitsPage;
    HomePage homePage;
    ProfilePage profilePage;
    @When("Benutzer klickt auf dieSchaltflaeche RemoteUnits")
    public void benutzerKlicktAufDieSchaltflaecheRemoteUnits() {

        remoteUnitsPage=new RemoteUnitsPage();
        homePage=new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.remoteUnits,10);
        homePage.remoteUnits.click();


    }


    @Then("Benutzer bestaetigt, dass sich die RemoteUnit {string} betrachtet")
    public void benutzerBestaetigtDassSichDieRemoteUnitBetrachtet(String ActRemoteUnit) {

        remoteUnitsPage=new RemoteUnitsPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.remoteUnits.get(0),10);
        String remoteUnitsText=ReusableMethods.getElementText(remoteUnitsPage.ilkRemoteUnit);
        Assert.assertTrue(remoteUnitsText.contains(ActRemoteUnit));


    }

    @And("Benutzer klickt auf dieSchaltflaeche Add new Remote Unit")
    public void benutzerKlicktAufDieSchaltflaecheAddNewRemoteUnit() {

        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.addNewRemoteUnitButton,10);
        remoteUnitsPage.addNewRemoteUnitButton.click();
    }

    @And("Benutzer loest Abteilungsnamen {string} ein")
    public void benutzerLoestAbteilungsnamenEin(String name) {
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.name,10);
        ReusableMethods.deleteFields(remoteUnitsPage.name,name);

    }

    @And("Benutzer gibt den Abteilungsnamen {string} ein")
    public void benutzerGibtDenAbteilungsnamenEin(String name) {
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.name,10);

        remoteUnitsPage.name.sendKeys(name);

    }



    @And("Benutzer waehlt als Abteilungstyp {string} aus")
    public void benutzerWaehltAlsAbteilungstypAus(String strDropDown) {

        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.departmentTypeDropDown,10);
        remoteUnitsPage.dropDownClick(ParallelDriver.getDriver(),strDropDown,remoteUnitsPage.departmentTypeDropDown);

    }

    @And("Benutzer klickt auf dieSchaltflaeche save")
    public void benutzerKlicktAufDieSchaltflaecheSave() {
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.saveButton,10);
        remoteUnitsPage.saveButton.click();



    }


    @And("Benutzer gibt den search {string} ein")
    public void benutzerGibtDenSearchEin(String DepartmentName) {
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.search,10);
        remoteUnitsPage.search.sendKeys(DepartmentName);

    }

    @And("Benutzer loescht die hinzugefuegte Remote Unit {string}")
    public void benutzerLoeschtDieHinzugefuegteRemoteUnit(String newRemoteUnit) {
        remoteUnitsPage=new RemoteUnitsPage();
        homePage=new HomePage();
        remoteUnitsPage.loeschenRemoteUnit(ParallelDriver.getDriver(),newRemoteUnit);

    }


    @Then("Benutzer bestätigt, dass er Remote-Units anzeigt")
    public void benutzerBestatigtDassErRemoteUnitsAnzeigt() {
        remoteUnitsPage=new RemoteUnitsPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.remoteUnits.get(0),10);
        Assert.assertFalse(remoteUnitsPage.remoteUnits.isEmpty());


    }

    @When("Benutzer erstellt Remote unit {string}")
    public void benutzerErstelltRemoteUnit(String departmentName) {
        remoteUnitsPage=new RemoteUnitsPage();
        remoteUnitsPage.erstellungRemoteUnit(ParallelDriver.getDriver(),departmentName,"Remote Unit");
    }

    @Then("Benutzer bestaetigt, dass sich die errormessage betrachtet")
    public void benutzerBestaetigtDassSichDieErrormessageBetrachtet() {
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.nameErrorMessage,10);
        Assert.assertTrue(remoteUnitsPage.nameErrorMessage.getText().contains("Please enter a name for department"));

    }

    @Then("Benutzer bestaetigt, dass sich die type errormessage betrachtet")
    public void benutzerBestaetigtDassSichDieTypeErrormessageBetrachtet() {
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.departmentTypeErrorMessage,10);
        Assert.assertTrue(remoteUnitsPage.departmentTypeErrorMessage.getText().contains("Please select a type for department"));


    }


    @And("Benutzer gibt den  Short Name {string} ein")
    public void benutzerGibtDenShortNameEin(String shortName) {
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.short_name,10);
        remoteUnitsPage.short_name.sendKeys(shortName);

    }

    @And("Benutzer gibt den Description {string}ein")
    public void benutzerGibtDenDescriptionEin(String descriptionText) {

        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.description,10);
        remoteUnitsPage.description.sendKeys(descriptionText);


    }


    @And("Benutzer wählt Role {string} aus")
    public void benutzerWahltRoleAus(String role) {
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.departmentRolesDropDown,10);
        remoteUnitsPage.dropDownClick(ParallelDriver.getDriver(),role,remoteUnitsPage.departmentRolesDropDown);
        remoteUnitsPage.rolesOk.click();

    }


    @When("Benutzer erstellt Remote unit {string} {string} {string} {string} {string}")
    public void benutzerErstelltRemoteUnit(String departmentName, String departmentType, String shortName, String descriptionText, String roleText) {
        remoteUnitsPage=new RemoteUnitsPage();
        remoteUnitsPage.erstellungRemoteUnit(ParallelDriver.getDriver(),departmentName, departmentType, shortName, descriptionText,roleText);

    }

    @And("Benutzer klickt auf die Schaltflaeche editButton")
    public void benutzerKlicktAufDieSchaltflaecheEditButton() {
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.editButton,10);
        remoteUnitsPage.editButton.click();

    }

    @Then("Benutzer bestaetigt, dass die departments name aktualisiert wurde")
    public void benutzerBestaetigtDassDieDepartmentsNameAktualisiertWurde() {
        profilePage=new ProfilePage();
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.acceptMessage,10);
       Assert.assertTrue(profilePage.alertacceptMessage(ParallelDriver.getDriver(),remoteUnitsPage.acceptMessage));
        remoteUnitsPage.acceptMassageCloseButton.click();


    }

    @And("Benutzer klickt auf die Shalteflaeche Change Image")
    public void benutzerKlicktAufDieShalteflaecheChangeImage() {
        remoteUnitsPage=new RemoteUnitsPage();

        String path=System.getProperty("user.dir")+"\\src\\test\\java\\utilities\\image.jpg";
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.changeImageButton,10);
        ReusableMethods.imageHinzufuegen(remoteUnitsPage.changeImageButton,path);

    }
    @And("Benutzer klickt auf die Schalteflaeche Crop")
    public void benutzerKlicktAufDieSchalteflaecheCrop() {
        remoteUnitsPage=new RemoteUnitsPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.cropButton,10);
        remoteUnitsPage.cropButton.click();


    }

    @And("Benutser klickt auf die Schalteflaeche ImageSave")
    public void benutserKlicktAufDieSchalteflaecheImageSave() {
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.saveImageButton,10);
        remoteUnitsPage.saveImageButton.click();

    }
    @Then("Benutzer bestaetigt, dass sich die Imageerrormessage betrachtet")
    public void benutzerBestaetigtDassSichDieImageerrormessageBetrachtet() {

        remoteUnitsPage=new RemoteUnitsPage();


        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.acceptMessage,10);

        String errormessageText= ReusableMethods.getElementText(remoteUnitsPage.acceptMessage);
        Assert.assertTrue(errormessageText.contains("An error occurred. The picture could not be changed."));
        try {
            remoteUnitsPage.acceptMassageCloseButton.click();
        }catch (Exception e){
            System.out.println("message not found");
        }


    }



    @Then("Benutzer bestaetigt, dass Remote Unit {string}  betrachtet geloescht wurde")
    public void benutzerBestaetigtDassRemoteUnitBetrachtetGeloeschtWurde(String remoteUnitDlt) {
        remoteUnitsPage=new RemoteUnitsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),remoteUnitsPage.search,10);
        remoteUnitsPage.search.clear();
        ReusableMethods.waitFor(1);
        remoteUnitsPage.search.sendKeys(remoteUnitDlt);
        ReusableMethods.waitFor(1);
        System.out.println("remoteUnitsPage.remoteUnitsrow.getText() = " + remoteUnitsPage.remoteUnitsrow.getText());
        Assert.assertTrue(remoteUnitsPage.remoteUnitsrow.getText().isEmpty());
    }


}
