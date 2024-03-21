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
        List<WebElement> list= ParallelDriver.getDriver().findElements(By.xpath("//b"));
        boolean flag=false;

        for (WebElement element : list) {
            if(element.getText().contains("P1")){
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
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),departmentsPage.Edit_Department,20);

        departmentsPage.Edit_Department.click();
        ParallelDriver.getDriver().navigate().refresh();
        // ParallelDriver.getDriver().navigate().refresh();
    }

    @And("Der Benutzer aendert den Benutzernamen")
    public void derBenutzerAendertDenBenutzernamen() {
        departmentsPage = new DepartmentsPage();
        // ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),departmentsPage.Department_Name,20);

        Actions actions=new Actions(ParallelDriver.getDriver());
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),departmentsPage.Department_oder_Team_Name,20);
       // ReusableMethods.waitFor(3);
        departmentsPage.Department_oder_Team_Name.clear();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),departmentsPage.Department_oder_Team_Name,20);
       // ReusableMethods.waitFor(3);
        actions.click(departmentsPage.Department_oder_Team_Name).sendKeys("P2").perform();
      //  ReusableMethods.waitFor(3);
    }


    @And("Der Benutzer klickt auf die Schaltflaeche Speichern")
    public void derBenutzerKlicktAufDieSchaltflaecheSpeichern() {
        departmentsPage = new DepartmentsPage();
        departmentsPage.Department_Save.click();
    }

    @And("Der Benutzer klickt auf den Abschnitt Team")
    public void derBenutzerKlicktAufDenAbschnittTeam() {
        homePage = new HomePage();
        homePage.teams.click();
    }

    @Then("Der Benutzer bestätigt den neuen TNamen")
    public void derBenutzerBestatigtDenNeuenTNamen() {
        List<WebElement> list= ParallelDriver.getDriver().findElements(By.xpath("//div[@class='col-4']"));
        boolean flag=false;
        for (WebElement element2 : list){
            System.out.println(element2.getText());
        }
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),teamsPage.add_new_Team,20);
        for (WebElement element : list) {
            if(element.getText().contains("P2")){

                flag=true;
                Assert.assertTrue(true);
            }

        }

        if (flag==false)
        {Assert.fail();}

    }
}
