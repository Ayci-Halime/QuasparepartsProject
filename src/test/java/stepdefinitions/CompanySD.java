package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CompanyPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class CompanySD {
    HomePage homePage;
    CompanyPage companyPage;
    @Given("Benutzer klickt auf der linken Seite der Seite auf „Company“.")
    public void benutzerKlicktAufDerLinkenSeiteDerSeiteAufCompany() {
        homePage = new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.company,10);
        homePage.company.click();
    }

    @And("Benutzer klickt auf der Edit.")
    public void benutzerKlicktAufDerEdit() {
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.editCompanyButton,10);
        companyPage.editCompanyButton.click();
    }

    @And("Loescht den Benutzernamen")
    public void loeschtDenBenutzernamen() throws InterruptedException {
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.companyName,10);
        ReusableMethods.deleteFields(companyPage.companyName, ConfigReader.getProperty("CompanyName"));
    }

    @And("Benutzer klickt auf der Save.")
    public void benutzerKlicktAufDerSave() throws InterruptedException {
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.saveButton,10);
        companyPage.saveButton.click();
        Thread.sleep(5000);
    }

    @Then("Benutzer bestaetigt, dass unter dem Namen eine Warnung erscheint.")
    public void benutzerBestaetigtDassUnterDemNamenEineWarnungErscheint() {
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.warning,10);
        String warningText=companyPage.warning.getText();
        Assert.assertEquals(warningText,"Please enter a name for company");
    }

    @And("Laesst den E-Mail leer.")
    public void laesstDenEMailLeer() {
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.companyEmail,10);
        ReusableMethods.deleteFields(companyPage.companyEmail, ConfigReader.getProperty("CompanyEmail"));
    }


    @And("Laesst den E-Mail und das Namen leer.")
    public void laesstDenEMailUndDasNamenLeer() {
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.companyName,10);
        ReusableMethods.deleteFields(companyPage.companyName, ConfigReader.getProperty("CompanyName"));
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.companyEmail,10);
        ReusableMethods.deleteFields(companyPage.companyEmail, ConfigReader.getProperty("CompanyEmail"));
    }

    @And("Benutzer gibt einen Buchstaben in das E-Mail ein und füllt auch das Namens aus.")
    public void benutzerGibtEinenBuchstabenInDasEMailEinUndFulltAuchDasNamensAus() {

    }

    @Then("Der Benutzer sieht, dass die Nachricht Unternehmensinformationen aktualisiert wurde.")
    public void derBenutzerSiehtDassDieNachrichtUnternehmensinformationenAktualisiertWurde() throws InterruptedException {
        companyPage=new CompanyPage();
       //ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.emailWarning,30);
        Thread.sleep(3000);
        String warningText=companyPage.emailWarning.getText();
        Assert.assertEquals(warningText,"Company information successfully updated");
    }
}
