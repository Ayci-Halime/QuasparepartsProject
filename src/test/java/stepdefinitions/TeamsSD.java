package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.DepartmentsPage;
import pages.HomePage;
import pages.TeamsPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import javax.swing.text.Utilities;
import java.util.List;

public class TeamsSD {
    HomePage homePage;
    DepartmentsPage departmentsPage;
    TeamsPage teamsPage;

    @Given("Der Benutzer klickt auf der linken Seite der Seite auf Team")
    public void derBenutzerKlicktAufDerLinkenSeiteDerSeiteAufTeam() {
        homePage = new HomePage();
        homePage.teams.click();

    }


    @And("Der Benutzer klickt auf die Schaltflaeche Neues Team hinzufugen")
    public void derBenutzerKlicktAufDieSchaltflaecheNeuesTeamHinzufugen() throws InterruptedException {
        teamsPage = new TeamsPage();
       // ReusableMethods.waitForClickablility(ParallelDriver.getDriver(), teamsPage.add_new_Team, 20);
       Thread.sleep(3000);
        teamsPage.add_new_Team.click();
    }

    @And("Der Benutzer schreibt den TAbteilungsnamen")
    public void derBenutzerSchreibtDenTAbteilungsnamen() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_oder_Team_Name.sendKeys(ConfigReader.getProperty("Team"));
    }

    @And("Der Benutzer schreibt den TKurznamen der Abteilung")
    public void derBenutzerSchreibtDenTKurznamenDerAbteilung() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_oder_Team_Short_Name.sendKeys("Prs");
    }

    @And("Der Benutzer wahlt den TAbteilungstyp aus")
    public void derBenutzerWahltDenTAbteilungstypAus() {
        departmentsPage = new DepartmentsPage();
        teamsPage=new TeamsPage();
        Actions actions = new Actions(ParallelDriver.getDriver());
        actions.click(teamsPage.Teams_Type).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        teamsPage.Teams_Save.click();
    }

    @Then("Uberpruft, ob Sie das neue Team zum Abschnitt „Team“ hinzufugen konnen")
    public void uberpruftObSieDasNeueTeamZumAbschnittTeamHinzufugenKonnen() {
        homePage = new HomePage();
        departmentsPage = new DepartmentsPage();
        homePage.teams.click();
        List<WebElement> list = ParallelDriver.getDriver().findElements(By.xpath("//b"));
        boolean flag = false;
        for (WebElement element : list) {
            if (element.getText().contains((ConfigReader.getProperty("Team")))) {
                flag = true;
                Assert.assertTrue(true);
            }

        }
        if (flag == false) {
            Assert.fail();
        }


    }


    @And("Der Benutzer klickt auf das gespeicherte Team")
    public void derBenutzerKlicktAufDasGespeicherteTeam() {
        teamsPage=new TeamsPage();
homePage=new HomePage();
homePage.teams.click();
        List<WebElement> list= ParallelDriver.getDriver().findElements(By.xpath("//b"));
        boolean flag=false;
        ReusableMethods.waitFor(2);
        for (WebElement element : list) {
            if(element.getText().contains("P1")){
                ReusableMethods.waitFor(2);
                flag=true;
                element.click();
            }

        }
        if (flag==false) Assert.fail();
    }

    @Then("Der Benutzer Uberpruft die Anklickbarkeit des gespeicherten Teams.")
    public void derBenutzerUberpruftDieAnklickbarkeitDesGespeichertenTeams() {
teamsPage=new TeamsPage();
ReusableMethods.waitFor(5);
Assert.assertTrue(teamsPage.Teams_assert.isDisplayed());
    }

    @And("Der Benutzer bearbeiten Teamklicks")
    public void derBenutzerBearbeitenTeamklicks() {
        departmentsPage = new DepartmentsPage();
       // ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),departmentsPage.Edit_Department,20);
        ReusableMethods.waitFor(2);
        departmentsPage.Edit_Department.click();
        ParallelDriver.getDriver().navigate().refresh();
        ParallelDriver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);

        // ParallelDriver.getDriver().navigate().refresh();
    }

    @And("Der Benutzer aendert den Benutzernamen")
    public void derBenutzerAendertDenBenutzernamen() {
        departmentsPage = new DepartmentsPage();
        //ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),departmentsPage.Department_oder_Team_Short_Name,20);
       ReusableMethods.waitForPageToLoad(10);
       ReusableMethods.deleteFields(departmentsPage.Department_oder_Team_Name,"P11");
        Actions actions=new Actions(ParallelDriver.getDriver());

       // departmentsPage.Department_oder_Team_Name.clear();

        actions.click(departmentsPage.Department_oder_Team_Name).sendKeys("P2").perform();
    }


    @And("Der Benutzer klickt auf die Schaltflaeche Speichern")
    public void derBenutzerKlicktAufDieSchaltflaecheSpeichern() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_Save.click();

    }

    @And("Der Benutzer klickt auf den Abschnitt Team")
    public void derBenutzerKlicktAufDenAbschnittTeam() {
        homePage = new HomePage();
        ReusableMethods.waitForPageToLoad(10);
        homePage.teams.click();

    }

    @Then("Der Benutzer bestätigt den neuen TNamen")
    public void derBenutzerBestatigtDenNeuenTNamen() {
        List<WebElement> list= ParallelDriver.getDriver().findElements(By.xpath("//div[@class='col-4']"));
        boolean flag=false;
        ReusableMethods.waitFor(2);
        for (WebElement element2 : list){
            System.out.println(element2.getText());
        }
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),teamsPage.add_new_Team,20);
        for (WebElement element : list) {
            if(element.getText().contains("P1")){
                ReusableMethods.waitFor(2);
                flag=true;
                Assert.assertTrue(true);
            }

        }

        if (flag==false)
        {Assert.fail();}

    }


    @And("Der Benutzer andert den TKurznamen.")
    public void derBenutzerAndertDenTKurznamen() {
        departmentsPage = new DepartmentsPage();
        ReusableMethods.waitForPageToLoad(10);
        departmentsPage.Department_oder_Team_Short_Name.clear();
        ReusableMethods.waitForPageToLoad(10);
        departmentsPage.Department_oder_Team_Short_Name.sendKeys("sss");
        ReusableMethods.waitFor(2);
    }

    @Then("Der Benutzer bestatigt den neuen TKurznamen")
    public void derBenutzerBestatigtDenNeuenTKurznamen() {
        departmentsPage = new DepartmentsPage();

        System.out.println("********");
        ReusableMethods.waitForPageToLoad(10);
        String str=departmentsPage.Kurzname_Department_Personel_assert.getText();
        System.out.println(str);
        ReusableMethods.waitFor(4);
        System.out.println("********");
         Assert.assertTrue(str.contains("sss"));

    }

    @And("Der Benutzer andert den Abteilungstyp.")
    public void derBenutzerAndertDenAbteilungstyp() {
        departmentsPage = new DepartmentsPage();
        Actions actions = new Actions(ParallelDriver.getDriver());
        ReusableMethods.waitForPageToLoad(10);
        actions.click(departmentsPage.Department_Type).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();

    }

    @Then("Der Benutzer uberpruft den neuen Abteilungstyp")
    public void derBenutzerUberpruftDenNeuenAbteilungstyp() {
        ReusableMethods.waitForPageToLoad(10);
        List<WebElement> list= ParallelDriver.getDriver().findElements(By.xpath("//b"));
        boolean flag=false;
        for (WebElement element2 : list){
            System.out.println(element2.getText());
        }
        ReusableMethods.waitForPageToLoad(10);
        for (WebElement element : list) {
            if(element.getText().contains("P1")){
                ReusableMethods.waitForPageToLoad(10);
                flag=true;
                Assert.assertTrue(true);
            }

        }

        if (flag==true)
        {Assert.fail();}
    }

    @And("Delete Team")
    public void deleteTeam() {

        departmentsPage = new DepartmentsPage();
        ReusableMethods.waitForPageToLoad(10);
        homePage = new HomePage();
        homePage.teams.click();
        List<WebElement> list = ParallelDriver.getDriver().findElements(By.xpath("//b"));
        boolean flag = false;
        for (WebElement element : list) {
            if (element.getText().contains("1") || element.getText().contains("P1")) {
                flag = true;
                ReusableMethods.waitForPageToLoad(10);
                element.click();
                break;
            }

        }
        if (flag == false) Assert.fail();

        ReusableMethods.waitFor(5);
        departmentsPage.Edit_Department.click();
        ReusableMethods.waitFor(2);
        ParallelDriver.getDriver().navigate().refresh();


        ReusableMethods.waitForPageToLoad(10);
        departmentsPage.Department_Delete_button.click();

        ReusableMethods.waitForPageToLoad(10);
        departmentsPage.Department_Delete_Confirm.click();

    }
}
