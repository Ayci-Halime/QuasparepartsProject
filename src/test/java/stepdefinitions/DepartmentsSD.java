package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.DepartmentsPage;
import pages.HomePage;
import pages.RemoteUnitsPage;
import utilities.ConfigReader;
import utilities.JavascriptUtils;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.awt.*;
import java.util.List;

public class DepartmentsSD {
    DepartmentsPage departmentsPage;
    HomePage homePage;
    RemoteUnitsPage remoteUnitsPage;

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
        departmentsPage.Department_oder_Team_Name.sendKeys(ConfigReader.getProperty("Department"));
    }

    @And("Der Benutzer schreibt den Kurznamen der Abteilung")
    public void derBenutzerSchreibtDenKurznamenDerAbteilung() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_oder_Team_Short_Name.sendKeys("Prs");

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
        List<WebElement> list = ParallelDriver.getDriver().findElements(By.xpath("//div[@class='col-4']"));
        boolean flag = false;
        for (WebElement element : list) {
            if (element.getText().contains((ConfigReader.getProperty("Department")))) {
                flag = true;
                Assert.assertTrue(true);
            }

        }
        if (flag == false) Assert.fail();


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
        departmentsPage.Department_oder_Team_Name.sendKeys(" ");
    }

    @Then("Uberpruft, ob dem Abschnitt „Abteilung“ eine neue Abteilung hinzugefugt wurde")
    public void uberpruftObDemAbschnittAbteilungEineNeueAbteilungHinzugefugtWurde() {
        homePage = new HomePage();
        departmentsPage = new DepartmentsPage();
        homePage.departments.click();
        List<WebElement> list = ParallelDriver.getDriver().findElements(By.xpath("//div[@class='col-4']"));
        boolean flag = false;
        for (WebElement element : list) {
            if (element.getText().contains(" ")) {
                flag = true;
                Assert.assertTrue(true);
            }

        }
        if (flag == false) Assert.fail();

    }

    @And("Im Abschnitt „Name der Benutzerabteilung“ konnen nur Zahlen eingegeben werden.")
    public void imAbschnittNameDerBenutzerabteilungKonnenNurZahlenEingegebenWerden() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_oder_Team_Name.sendKeys("1234");
    }

    @Then("Uberpruft, ob dem Abschnitt „Abteilung“\\(mit Zahlen) eine neue Abteilung hinzugefugt wurde")
    public void uberpruftObDemAbschnittAbteilungMitZahlenEineNeueAbteilungHinzugefugtWurde() {
        homePage = new HomePage();
        departmentsPage = new DepartmentsPage();
        homePage.departments.click();
        List<WebElement> list = ParallelDriver.getDriver().findElements(By.xpath("//div[@class='col-4']"));
        boolean flag = false;
        for (WebElement element : list) {
            if (element.getText().contains("1234")) {
                flag = true;
                Assert.assertTrue(true);
            }

        }
        if (flag == false) Assert.fail();

    }

    @And("Im Abschnitt „Name der Benutzerabteilung“ konnen nur Sonderzeichen eingegeben werden.")
    public void imAbschnittNameDerBenutzerabteilungKonnenNurSonderzeichenEingegebenWerden() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_oder_Team_Name.sendKeys("**");
    }

    @Then("Uberpruft, ob dem Abschnitt „Abteilung“\\(mit Sonderzeichen) eine neue Abteilung hinzugefugt wurde")
    public void uberpruftObDemAbschnittAbteilungMitSonderzeichenEineNeueAbteilungHinzugefugtWurde() {
        homePage = new HomePage();
        departmentsPage = new DepartmentsPage();
        homePage.departments.click();
        List<WebElement> list = ParallelDriver.getDriver().findElements(By.xpath("//div[@class='col-4']"));
        boolean flag = false;
        for (WebElement element : list) {
            if (element.getText().contains("**")) {
                flag = true;
                Assert.assertTrue(true);
            }

        }
        if (flag == false) Assert.fail();

    }

    @And("Der Benutzer lasst Abteilungstyp leer.")
    public void derBenutzerLasstAbteilungstypLeer() {

    }

    @Then("Uberpruft, ob dem Abschnitt „Abteilung“ keine neue Abteilung hinzugefugt wurde")
    public void uberpruftObDemAbschnittAbteilungKeineNeueAbteilungHinzugefugtWurde() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Type_Leer.isDisplayed();
    }

    @And("Der Benutzer klickt auf eine gespeicherte Abteilung")
    public void derBenutzerKlicktAufEineGespeicherteAbteilung() {
        departmentsPage = new DepartmentsPage();
        ReusableMethods.waitForPageToLoad(10);
        List<WebElement> list = ParallelDriver.getDriver().findElements(By.xpath("//b"));
        boolean flag = false;
        for (WebElement element : list) {
            if (element.getText().contains("P1")) {
                flag = true;
                ReusableMethods.waitForPageToLoad(10);
                element.click();
                break;
            }

        }
        if (flag == false) Assert.fail();

    }

    @And("Der Benutzer klickt auf „Abteilung bearbeiten“.")
    public void derBenutzerKlicktAufAbteilungBearbeiten() {
        departmentsPage = new DepartmentsPage();
        ReusableMethods.waitFor(5);
        departmentsPage.Edit_Department.click();
        ReusableMethods.waitFor(2);
        ParallelDriver.getDriver().navigate().refresh();

    }

    @And("Andert den Benutzernamen.")
    public void andertDenBenutzernamen() {
        departmentsPage = new DepartmentsPage();
        // ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),departmentsPage.Department_Name,20);
        ReusableMethods.waitForPageToLoad(10);
        Actions actions = new Actions(ParallelDriver.getDriver());
        ReusableMethods.waitForPageToLoad(10);
        departmentsPage.Department_oder_Team_Name.clear();
        ReusableMethods.waitForPageToLoad(10);
        actions.click(departmentsPage.Department_oder_Team_Name).sendKeys("P1").perform();
    }

    @And("Der Benutzer klickt auf den Abteilungsbereich")
    public void derBenutzerKlicktAufDenAbteilungsbereich() {
        homePage = new HomePage();
        homePage.departments.click();


    }

    @Then("Der Benutzer bestätigt den neuen Namen")
    public void derBenutzerBestatigtDenNeuenNamen() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> list = ParallelDriver.getDriver().findElements(By.xpath("//div[@class='col-4']"));
        boolean flag = false;
        for (WebElement element2 : list) {
            System.out.println(element2.getText());
        }
        Thread.sleep(3000);
        for (WebElement element : list) {
            if (element.getText().contains("P1")) {
                Thread.sleep(3000);
                flag = true;
                Assert.assertTrue(true);
            }

        }
        Thread.sleep(3000);
        if (flag == false) {
            Assert.fail();
        }

    }

    @And("Der Benutzer andert den Kurznamen.")
    public void derBenutzerAndertDenKurznamen() throws InterruptedException {
        departmentsPage = new DepartmentsPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), departmentsPage.Department_oder_Team_Short_Name, 10);
        Thread.sleep(2000);
        departmentsPage.Department_oder_Team_Short_Name.clear();
        Thread.sleep(2000);
        departmentsPage.Department_oder_Team_Short_Name.sendKeys("sss");
        Thread.sleep(2000);
    }

    @Then("Der Benutzer bestatigt den neuen Kurznamen")
    public void derBenutzerBestatigtDenNeuenKurznamen() throws InterruptedException {
        departmentsPage = new DepartmentsPage();

        System.out.println("********");
        ReusableMethods.waitForPageToLoad(10);
        String str = departmentsPage.Kurzname_Department_Personel_assert.getText();
        System.out.println(str);
        ReusableMethods.waitFor(4);
        System.out.println("********");
        Assert.assertTrue(str.contains("sss"));
    }

    @And("Der Benutzer andert den „Abteilungstyp“.")
    public void derBenutzerAndertDenAbteilungstyp() throws InterruptedException {
        departmentsPage = new DepartmentsPage();
        Actions actions = new Actions(ParallelDriver.getDriver());
        Thread.sleep(2000);
        actions.click(departmentsPage.Department_Type).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
    }

    @Then("Der Benutzer bestatigt, dass diese „Abteilung“ nicht zur Abteilung gehort")
    public void derBenutzerBestatigtDassDieseAbteilungNichtZurAbteilungGehort() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> list = ParallelDriver.getDriver().findElements(By.xpath("//b"));
        boolean flag = false;
        for (WebElement element2 : list) {
            System.out.println(element2.getText());
        }
        Thread.sleep(3000);
        for (WebElement element : list) {
            if (element.getText().contains("P1")) {
                Thread.sleep(3000);
                flag = true;
                Assert.assertTrue(true);
            }

        }
        Thread.sleep(3000);
        if (flag == false) {
            Assert.fail();
        }

    }

    @And("Der Benutzer andert die „Abteilungsbeschreibung“.")
    public void derBenutzerAndertDieAbteilungsbeschreibung()  {
        departmentsPage = new DepartmentsPage();
        ReusableMethods.waitForPageToLoad(10);
       // departmentsPage.description_Department.clear();
        ReusableMethods.deleteFields(departmentsPage.description_Department,"Personel abteilung");
        ReusableMethods.waitForPageToLoad(10);
        departmentsPage.description_Department.sendKeys("Personel abteilung");

    }

    @Then("Der Benutzer bestatigt, dass sich „Beschreibung“ in der Abteilung geandert hat")
    public void derBenutzerBestatigtDassSichBeschreibungInDerAbteilungGeandertHat() {
        departmentsPage = new DepartmentsPage();
        System.out.println("***********************************************");

       ReusableMethods.waitForPageToLoad(10);
        //ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),departmentsPage.Department_Personel_abteilung,10);
        Assert.assertTrue(departmentsPage.Department_Personel_abteilung.isDisplayed());
        ReusableMethods.waitForPageToLoad(2);
        System.out.println("***********************************************");
    }

    @And("Der Benutzer andert die Abteilungsrollen")
    public void derBenutzerAndertDieAbteilungsrollen() throws InterruptedException {
        departmentsPage = new DepartmentsPage();
        Actions actions = new Actions(ParallelDriver.getDriver());
        Thread.sleep(4000);
        actions.click(departmentsPage.description_Department).
                sendKeys(Keys.TAB).sendKeys("B" + Keys.ENTER).click().perform();
        Thread.sleep(4000);
    }

    @Then("Der Benutzer bestatigt, dass sich „Rollen“ in der Abteilung geandert haben")
    public void derBenutzerBestatigtDassSichRollenInDerAbteilungGeandertHaben() {
        departmentsPage = new DepartmentsPage();
        Assert.assertTrue(departmentsPage.Department_Rolle_assert.getText().contains("B"));
    }

    @And("Der Benutzer klickt auf die Schaltflache „Abteilung loschen“.")
    public void derBenutzerKlicktAufDieSchaltflacheAbteilungLoschen() {
        departmentsPage = new DepartmentsPage();
        ReusableMethods.waitForPageToLoad(10);
        departmentsPage.Department_Delete_button.click();
    }

    @And("Der Benutzer klickt auf dem angezeigten Bildschirm auf „Bestatigen“")
    public void derBenutzerKlicktAufDemAngezeigtenBildschirmAufBestatigen() {
        departmentsPage = new DepartmentsPage();
        ReusableMethods.waitForPageToLoad(10);
        departmentsPage.Department_Delete_Confirm.click();
    }

    @Then("Der Benutzer Uberpruft, ob die geloschte Abteilung geloscht wurde")
    public void derBenutzerUberpruftObDieGeloschteAbteilungGeloschtWurde() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> list = ParallelDriver.getDriver().findElements(By.xpath("//b"));
        boolean flag = false;
        for (WebElement element2 : list) {
            System.out.println(element2.getText());
        }
        Thread.sleep(3000);
        for (WebElement element : list) {
            if (element.getText().contains("P1")) {
                Thread.sleep(3000);
                flag = true;
                Assert.assertTrue(true);
            }

        }
        Thread.sleep(3000);
        if (flag == true) {
            Assert.fail();
        }
    }

    @And("Der Benutzer klickt auf „Bild andern“")
    public void derBenutzerKlicktAufBildAndern() {
        departmentsPage = new DepartmentsPage();
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\utilities\\gunes.png";
        ReusableMethods.imageHinzufuegen(departmentsPage.Department_Chance_image, path);
    ReusableMethods.waitFor(3);
    }

    @And("Der Benutzer ladt ein Bild vom Computer hoch")
    public void derBenutzerLadtEinBildVomComputerHoch() {
        departmentsPage = new DepartmentsPage();
        ReusableMethods.waitForPageToLoad(5);
        departmentsPage.Department_Crop.click();
        ReusableMethods.waitForPageToLoad(5);
        departmentsPage.Department_Save_Image.click();
        remoteUnitsPage = new RemoteUnitsPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), remoteUnitsPage.acceptMessage, 10);

        String errormessageText = remoteUnitsPage.acceptMessage.getText();
        System.out.println("errormessageText = " + errormessageText);
        Assert.assertFalse(errormessageText.contains("An error occurred. The picture could not be changed."));


    }


    @And("Delete  Department")
    public void deleteDepartment() {
        departmentsPage = new DepartmentsPage();
        ReusableMethods.waitForPageToLoad(10);
        List<WebElement> list = ParallelDriver.getDriver().findElements(By.xpath("//b"));
        boolean flag = false;
        for (WebElement element : list) {
            String text = element.getText();
            System.out.println(text);
            ReusableMethods.waitFor(2);
            if (text.contains("1234") || text.contains("Personel")) {
                flag = true;
                // ReusableMethods.waitForPageToLoad(10);
                // ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),element,10);
                JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(),element);
                // element.click();
                JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),element);
                break;
            }

        }
        if (flag == false) Assert.fail();

        ReusableMethods.waitFor(3);
        departmentsPage.Edit_Department.click();
        ReusableMethods.waitFor(2);
        ParallelDriver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);
        ParallelDriver.getDriver().navigate().refresh();


        ReusableMethods.waitForPageToLoad(10);
        departmentsPage.Department_Delete_button.click();

        ReusableMethods.waitForPageToLoad(10);
        departmentsPage.Department_Delete_Confirm.click();
    }

}
