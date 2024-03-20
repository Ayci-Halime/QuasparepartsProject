package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;
import utilities.ConfigReader;
import utilities.JavascriptUtils;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class UsersSD {
    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;
    List<WebElement> usersRoles;

    @Given("Benutzer meldet sich an")
    public void benutzer_meldet_sich_an() {
        loginPage = new LoginPage();
        loginPage.loginMethod(ParallelDriver.getDriver());
    }
    @When("Benutzer klickt auf das Menu Benutzer")
    public void benutzer_klickt_auf_das_menu_benutzer() {
        homePage = new HomePage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.menubarOk,15);
        homePage.menubarOk.click();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.users,15);
        homePage.users.click();
    }

    @When("Benutzer fuegt einen Benutzer hinzu")
    public void benutzer_fuegt_einen_benutzer_hinzu() {
        usersPage = new UsersPage();
        homePage = new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.addNewMember,10);
        usersPage.addNewMember.click();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.departmentInAddNewMember,10);
        usersPage.departmentInAddNewMember.click();
        usersPage.departmentInAddNewMember.sendKeys(ConfigReader.getProperty("new_user_department")+Keys.ENTER+Keys.ESCAPE);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.roleInAddNewMember,10);
        usersPage.roleInAddNewMember.sendKeys(ConfigReader.getProperty("new_user_default_role")+Keys.ENTER);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.email,10);
        usersPage.email.sendKeys(ConfigReader.getProperty("new_user_mail"));

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.registerButton,10);
        usersPage.registerButton.click();

        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),usersPage.closeButton,10);
        usersPage.closeButton.click();

    }

    @When("Benutzer sucht die E-Mail Adresse des neuen Benutzers")
    public void benutzer_sucht_die_e_mail_adresse_des_neuen_benutzers() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.searchBox,15);
        usersPage.searchBox.clear();
        usersPage.searchBox.sendKeys(ConfigReader.getProperty("new_user_mail"));

    }
    @Then("Benutzer bestaetigt dass der neue Benutzer hinzugefuegt ist")
    public void benutzer_bestaetigt_dass_der_neue_benutzer_hinzugefuegt_ist() {
        usersPage = new UsersPage();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),usersPage.newUserEmailAfterSearch,15);
        Assert.assertTrue("New added user is not visible",usersPage.newUserEmailAfterSearch.isDisplayed());
        ParallelDriver.getDriver().navigate().refresh();

    }

    @Then("Benutzer loescht den neuen hinzugefuegten Benutzer")
    public void benutzer_loescht_den_neuen_hinzugefuegten_benutzer() {
        usersPage = new UsersPage();
        WebDriverWait wait = new WebDriverWait(ParallelDriver.getDriver(), Duration.ofSeconds(15));

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.perPageDropDown,15);
        Select select = new Select(usersPage.perPageDropDown);
        select.selectByIndex(4);

        ParallelDriver.getDriver().navigate().refresh();
      //  WebElement element = ParallelDriver.getDriver().findElement(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']"));
       // WebElement element = ParallelDriver.getDriver().
//                findElement(By.xpath("//tbody[@class='tableRows']/tr/td[2]/a"));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(ConfigReader.getProperty("new_user_mail"))));

        try {
            //element.click();
            JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(),element);
        } catch (StaleElementReferenceException e) {
            element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(ConfigReader.getProperty("new_user_mail"))));
            JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(),element);
           // JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),element);
        }
      //  ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),element,15);
     //   JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(),element);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement threeDots = ParallelDriver.getDriver().
               findElement(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']//parent::td//parent::tr//child::td[7]//div//button"));
       // WebElement threeDots = ParallelDriver.getDriver().findElement(By.xpath("(//div[@class='btn-group'])[2]/button"));
        try {
            threeDots.click();
        } catch (StaleElementReferenceException e) {
            threeDots = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']//parent::td//parent::tr//child::td[7]//div//button")));
            //JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),threeDots);
            threeDots.click();
        }

       // ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),threeDots,20);

        //JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),threeDots);
     //   threeDots.click();


        //ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),usersPage.removeFromOrganizaiton,10);
        WebElement removefromorganization = usersPage.removeFromOrganizaiton;
        try {
            removefromorganization.click();
        } catch (StaleElementReferenceException e) {
           // threeDots = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']//parent::td//parent::tr//child::td[7]//div")));
            removefromorganization = usersPage.removeFromOrganizaiton;
            removefromorganization.click();
        }
        //usersPage.removeFromOrganizaiton.click();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.userRemovedMessage,10);
        ParallelDriver.getDriver().navigate().refresh();

    }


    @And("Benutzer klickt auf den gesuchten Benutzer")
    public void benutzerKlicktAufDenGesuchtenBenutzer() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.perPageDropDown,15);
        Select select = new Select(usersPage.perPageDropDown);
        select.selectByIndex(4);

        WebElement element = ParallelDriver.getDriver().
                findElement(By.linkText(ConfigReader.getProperty("new_user_mail")));


        JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(),element);
        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),element,10);
        JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),element);
       // element.click();

        //ParallelDriver.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    @And("Benutzer klickt auf das + Symbol neben den Rollen unten rechts")
    public void benutzerKlicktAufDasSymbolNebenDenRollenUntenRechts() {
        usersPage = new UsersPage();
        usersRoles = usersPage.usersRoles; // burda yeni rol eklemeden önce rolleri listeye aldım
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.plusRoles,10);
        JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),usersPage.plusRoles);
    }

    @And("Benutzer fuegt eine neue Rolle hinzu {string}")
    public void benutzerFuegtEineNeueRolleHinzu(String new_user_another_role) {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.addNewRole,10);
        usersPage.addNewRole.click();

        usersPage.addNewRole.sendKeys(ConfigReader.getProperty(new_user_another_role)+Keys.ENTER);
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.saveButton,10);
        usersPage.saveButton.click();

    }

    @Then("Benutzer prueft dass die Rolle hinzugefuegt ist")
    public void benutzerPrueftDassDieRolleHinzugefuegtIst() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.addingNewRoleMessage,10);
        String actualResult = ReusableMethods.getElementText(usersPage.addingNewRoleMessage);
        String expectedResult = "New role added for this user successfuly";

        Assert.assertEquals(expectedResult,actualResult);
    }

    @And("Benutzer kehrt zum Benutzermenu zuruck")
    public void benutzerKehrtZumBenutzermenuZuruck() {
        homePage = new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.users,10);
        homePage.users.click();
    }


    @And("Benutzer loescht die hinzugefuegte Rolle")
    public void benutzerLoeschtDieHinzugefuegteRolle() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.deleteRoleThreeDots,10);
        usersPage.deleteRoleThreeDots.click();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.removeRole,10);
        usersPage.removeRole.click();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.confirmButtonForDeleteRole,10);
        usersPage.confirmButtonForDeleteRole.click();

    }

    @Then("Benutzer bestaetigt dass die Rolle geloescht wurde")
    public void benutzerBestaetigtDassDieRolleGeloeschtWurde() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.deleteRoleMessage,10);
        int roleListSize = usersPage.usersRoles.size();

        Assert.assertTrue(usersPage.deleteRoleMessage.isDisplayed());
        Assert.assertEquals(usersRoles.size(),roleListSize);
    }

    @And("Benutzer klickt auf das Bearbeitungssymbol \\(Stift) oben rechts")
    public void benutzerKlicktAufDasBearbeitungssymbolStiftObenRechts() {
        usersPage = new UsersPage();

        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),usersPage.editIconInUserDetail,10);
        usersPage.editIconInUserDetail.click();

    }

    @Then("Benutzer bestaetigt dass die E-Mail Adresse nicht geandert werden konnen")
    public void benutzerBestaetigtDassDieEMailAdresseNichtGeandertWerdenKonnen() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.emailInUserDetail,10);
        Assert.assertTrue(usersPage.emailInUserDetail.isDisplayed());

    }

    @And("Benutzer klickt auf das Symbol Speichern oben rechts")
    public void benutzerKlicktAufDasSymbolSpeichernObenRechts() {

        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.saveIconInUserDetail,10);
        usersPage.saveIconInUserDetail.click();

    }

    @And("Benutzer loescht das Feld fuer den Benutzernamen")
    public void benutzerLoeschtDasFeldFuerDenBenutzernamen() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.usernameInUserDetail,10);
        usersPage.usernameInUserDetail.click();
        usersPage.usernameInUserDetail.clear();
    }

    @Then("Benutzer bestaetigt dass er eine Fehlermeldung im Users erhalten hat")
    public void benutzerBestaetigtDassErEineFehlermeldungImUsersErhaltenHat() {
        usersPage = new UsersPage();
        String errorMessage = "Username cannot be empty";
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.usernameErrorMessageInUserDetail,10);
        Assert.assertTrue(usersPage.usernameErrorMessageInUserDetail.getText().equalsIgnoreCase(errorMessage));
    }

    @And("Benutzer klickt auf das Schließen-Symbol oben rechts")
    public void benutzerKlicktAufDasSchließenSymbolObenRechts() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.closeIconInUserDetail,10);
        usersPage.closeIconInUserDetail.click();
    }

}
