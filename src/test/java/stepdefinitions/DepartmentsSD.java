package stepdefinitions;

import io.cucumber.java.en.*;
import net.bytebuddy.asm.Advice;
import org.apache.commons.collections4.functors.TruePredicate;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.DepartmentsPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.ParallelDriver;

import java.awt.*;
import java.util.List;

public class DepartmentsSD {
    DepartmentsPage departmentsPage;
    HomePage homePage;

    @Given("Der Benutzer klickt auf der linken Seite der Seite auf „Abteilung“.")
    public void der_benutzer_klickt_auf_der_linken_seite_der_seite_auf_abteilung() {
        homePage = new HomePage();
        homePage.departments.click();
    }

    @Then("Der Benutzer uberpruft, ob die Finanzabteilung angezeigt wird")
    public void der_benutzer_uberpruft_ob_die_finanzabteilung_angezeigt_wird() {
        departmentsPage = new DepartmentsPage();
        Assert.assertTrue(departmentsPage.Finance_Department.isDisplayed());
    }

    @Then("Der Benutzer uberpruft, ob die Logistikabteilung angezeigt wird")
    public void derBenutzerUberpruftObDieLogistikabteilungAngezeigtWird() {
        departmentsPage = new DepartmentsPage();
        Assert.assertTrue(departmentsPage.Logistics_Department.isDisplayed());

    }

    @Then("Der Benutzer uberpruft, ob die Abteilung „Marketing und Vertrieb“ angezeigt wird")
    public void derBenutzerUberpruftObDieAbteilungMarketingUndVertriebAngezeigtWird() {
        departmentsPage = new DepartmentsPage();
        Assert.assertTrue(departmentsPage.Marketing_and_Sales_Department.isDisplayed());

    }

    @Then("Der Benutzer uberpruft, ob die Qualitetssicherungsabteilung angezeigt wird")
    public void derBenutzerUberpruftObDieQualitetssicherungsabteilungAngezeigtWird() {
        departmentsPage = new DepartmentsPage();
        Assert.assertTrue(departmentsPage.Quality_Assurance_Department.isDisplayed());

    }


    @And("Der Benutzer klickt auf die Schaltflache „Neue Abteilung hinzufugen“.")
    public void derBenutzerKlicktAufDieSchaltflacheNeueAbteilungHinzufugen() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.add_new_Department.click();
    }

    @And("Der Benutzer schreibt den Abteilungsnamen")
    public void derBenutzerSchreibtDenAbteilungsnamen() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_Name.sendKeys(ConfigReader.getProperty("Department"));
    }

    @And("Der Benutzer schreibt den Kurznamen der Abteilung")
    public void derBenutzerSchreibtDenKurznamenDerAbteilung() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_Short_Name.sendKeys("Prs");

    }

    @And("Der Benutzer wahlt den Abteilungstyp aus")
    public void derBenutzerWahltDenAbteilungstypAus() {
        departmentsPage = new DepartmentsPage();
        Actions actions = new Actions(ParallelDriver.getDriver());
        actions.click(departmentsPage.Department_Type).sendKeys(Keys.ENTER).perform();
    }

    @Then("Uberpruft, ob eine neue Abteilung zum Abschnitt „Abteilung“ hinzugefugt werden kann")
    public void uberpruftObEineNeueAbteilungZumAbschnittAbteilungHinzugefugtWerdenKann() {
      homePage = new HomePage();
        departmentsPage = new DepartmentsPage();
      homePage.departments.click();
     List<WebElement> list= ParallelDriver.getDriver().findElements(By.xpath("//div[@class='col-4']"));
      boolean flag=false;
        for (WebElement element : list) {
            if(element.getText().contains((ConfigReader.getProperty("Department")))){
                flag=true;
                Assert.assertTrue(true);
            }

        }
        if (flag==false) Assert.fail();



    }

    @And("Der Benutzer klickt auf die Schaltflache „Speichern“.")
    public void derBenutzerKlicktAufDieSchaltflacheSpeichern() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_Save.click();
    }

    @Then("Der Benutzer uberpruft, ob die Schaltflache „Neue Abteilung hinzufugen“ im Abschnitt „Abteilung“ angezeigt wird")
    public void derBenutzerUberpruftObDieSchaltflacheNeueAbteilungHinzufugenImAbschnittAbteilungAngezeigtWird() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.add_new_Department.isDisplayed();

    }

    @And("Der Benutzer lasst den Abschnitt „Abteilungsname“ leer.")
    public void derBenutzerLasstDenAbschnittAbteilungsnameLeer() {

    }

    @And("Stellt sicher, dass dem Abschnitt „Abteilung“ keine neue Abteilung hinzugefugt werden kann.")
    public void stelltSicherDassDemAbschnittAbteilungKeineNeueAbteilungHinzugefugtWerdenKann() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Name_Leer.isDisplayed();
    }

    @And("Drucken Sie im Abschnitt „Name der Benutzerabteilung“ einfach die Leertaste.")
    public void druckenSieImAbschnittNameDerBenutzerabteilungEinfachDieLeertaste() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_Name.sendKeys(" ");
    }

    @Then("Uberpruft, ob dem Abschnitt „Abteilung“ eine neue Abteilung hinzugefugt wurde")
    public void uberpruftObDemAbschnittAbteilungEineNeueAbteilungHinzugefugtWurde() {
        homePage = new HomePage();
        departmentsPage = new DepartmentsPage();
        homePage.departments.click();
        List<WebElement> list= ParallelDriver.getDriver().findElements(By.xpath("//div[@class='col-4']"));
        boolean flag=false;
        for (WebElement element : list) {
            if(element.getText().contains(" ")){
                flag=true;
                Assert.assertTrue(true);
            }

        }
        if (flag==false) Assert.fail();

    }

    @And("Im Abschnitt „Name der Benutzerabteilung“ konnen nur Zahlen eingegeben werden.")
    public void imAbschnittNameDerBenutzerabteilungKonnenNurZahlenEingegebenWerden() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_Name.sendKeys("1234");
    }

    @Then("Uberpruft, ob dem Abschnitt „Abteilung“\\(mit Zahlen) eine neue Abteilung hinzugefugt wurde")
    public void uberpruftObDemAbschnittAbteilungMitZahlenEineNeueAbteilungHinzugefugtWurde() {
        homePage = new HomePage();
        departmentsPage = new DepartmentsPage();
        homePage.departments.click();
        List<WebElement> list= ParallelDriver.getDriver().findElements(By.xpath("//div[@class='col-4']"));
        boolean flag=false;
        for (WebElement element : list) {
            if(element.getText().contains("1234")){
                flag=true;
                Assert.assertTrue(true);
            }

        }
        if (flag==false) Assert.fail();

    }

    @And("Im Abschnitt „Name der Benutzerabteilung“ konnen nur Sonderzeichen eingegeben werden.")
    public void imAbschnittNameDerBenutzerabteilungKonnenNurSonderzeichenEingegebenWerden() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_Name.sendKeys("**");
    }

    @Then("Uberpruft, ob dem Abschnitt „Abteilung“\\(mit Sonderzeichen) eine neue Abteilung hinzugefugt wurde")
    public void uberpruftObDemAbschnittAbteilungMitSonderzeichenEineNeueAbteilungHinzugefugtWurde() {
        homePage = new HomePage();
        departmentsPage = new DepartmentsPage();
        homePage.departments.click();
        List<WebElement> list= ParallelDriver.getDriver().findElements(By.xpath("//div[@class='col-4']"));
        boolean flag=false;
        for (WebElement element : list) {
            if(element.getText().contains("**")){
                flag=true;
                Assert.assertTrue(true);
            }

        }
        if (flag==false) Assert.fail();

    }

    @And("Der Benutzer lasst Abteilungstyp leer.")
    public void derBenutzerLasstAbteilungstypLeer() {

    }

    @Then("Uberpruft, ob dem Abschnitt „Abteilung“ keine neue Abteilung hinzugefugt wurde")
    public void uberpruftObDemAbschnittAbteilungKeineNeueAbteilungHinzugefugtWurde() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Type_Leer.isDisplayed();
    }
}
