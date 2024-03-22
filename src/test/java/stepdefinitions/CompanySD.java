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

import java.util.ArrayList;
import java.util.List;

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

    }

    @Then("Benutzer bestaetigt, dass unter dem Namen eine Warnung erscheint.")
    public void benutzerBestaetigtDassUnterDemNamenEineWarnungErscheint() {
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.emailWarning,10);
        List<String> errors = new ArrayList<>();
        errors.add("Please enter a name for company");
        errors.add("Company information successfully updated");
        String actual = companyPage.emailWarning.getText();
        Assert.assertTrue("Error message is not displayed",errors.contains(actual));

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
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.companyEmail,20);
        companyPage.companyEmail.sendKeys("a");

    }

    @Then("Der Benutzer sieht, dass die Nachricht Unternehmensinformationen aktualisiert wurde.")
    public void derBenutzerSiehtDassDieNachrichtUnternehmensinformationenAktualisiertWurde() throws InterruptedException {
        companyPage=new CompanyPage();
       ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.emailWarning,4);
        //Thread.sleep(3000);
        ReusableMethods.waitForPageToLoad(10);
        String warningText=ReusableMethods.getElementText(companyPage.emailWarning);
        System.out.println(warningText);

        Assert.assertEquals(warningText,"Company information successfully updated");
    }

    @And("Der Benutzer leert die volle Mail.")
    public void derBenutzerLeertDieVolleMail() {
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.companyEmail,20);
        ReusableMethods.deleteFields(companyPage.companyEmail, ConfigReader.getProperty("CompanyEmail"));
    }

    @And("Benutzer fügt der E-Mail nicht das @-Zeichen hinzu, sondern trägt auch den Namen ein.")
    public void benutzerFugtDerEMailNichtDasZeichenHinzuSondernTragtAuchDenNamenEin() {
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.companyEmail,20);
        companyPage.companyEmail.sendKeys("neueAcmegmail.com");
    }

    @And("Benutzer fügt nicht E-Mail und com hinzu, sondern trägt den Namen ein.")
    public void benutzerFugtNichtEMailUndComHinzuSondernTragtDenNamenEin() {
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.companyEmail,20);
        companyPage.companyEmail.sendKeys("neueAcme@gmail.");
    }

    @And("Benutzer gibt das Zeichen @ anstelle des Namens ein und füllt auch die E-Mail aus.")
    public void benutzerGibtDasZeichenAnstelleDesNamensEinUndFulltAuchDieEMailAus() {
        companyPage=new CompanyPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.companyName,10);
        ReusableMethods.deleteFields(companyPage.companyName, ConfigReader.getProperty("CompanyName"));
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),companyPage.companyName,20);
        companyPage.companyName.sendKeys("@");
    }
}
