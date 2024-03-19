package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;
import utilities.ConfigReader;
import utilities.JavascriptUtils;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.awt.event.KeyEvent;

public class UsersSD {
    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;

    @Given("Benutzer meldet sich an")
    public void benutzer_meldet_sich_an() {
        loginPage = new LoginPage();
        loginPage.loginMethod(ParallelDriver.getDriver());
    }
    @When("Benutzer klickt auf das Menu Benutzer")
    public void benutzer_klickt_auf_das_menu_benutzer() {
        homePage = new HomePage();
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
        usersPage.closeButton.click();

    }

    @When("Benutzer sucht die E-Mail Adresse des neuen Benutzers")
    public void benutzer_sucht_die_e_mail_adresse_des_neuen_benutzers() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.searchBox,15);
        usersPage.searchBox.sendKeys(ConfigReader.getProperty("new_user_mail"));

    }
    @Then("Benutzer bestaetigt dass der neue Benutzer hinzugefuegt ist")
    public void benutzer_bestaetigt_dass_der_neue_benutzer_hinzugefuegt_ist() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.newUserEmailAfterSearch,15);
        Assert.assertTrue("New added user is not visible",usersPage.newUserEmailAfterSearch.isDisplayed());

        ParallelDriver.getDriver().navigate().refresh();
        ParallelDriver.getDriver().navigate().refresh();

    }
    @Then("Benutzer loescht den neuen hinzugefuegten Benutzer")
    public void benutzer_loescht_den_neuen_hinzugefuegten_benutzer() {
        usersPage = new UsersPage();
        ParallelDriver.getDriver().navigate().refresh();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.perPageDropDown,15);
        Select select = new Select(usersPage.perPageDropDown);
        select.selectByIndex(4);

        WebElement element = ParallelDriver.getDriver().
                findElement(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']"));

        JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(),element);
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),element,10);

        WebElement threeDots = ParallelDriver.getDriver().
                findElement(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']//parent::td//parent::tr//child::td[7]//div//button"));
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),threeDots,10);

        JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),threeDots);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.removeFromOrganizaiton,10);
        JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),usersPage.removeFromOrganizaiton);

    }


    @And("Benutzer klickt auf den gesuchten Benutzer")
    public void benutzerKlicktAufDenGesuchtenBenutzer() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.perPageDropDown,15);
        Select select = new Select(usersPage.perPageDropDown);
        select.selectByIndex(4);

        WebElement element = ParallelDriver.getDriver().
                findElement(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']"));

        JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(),element);
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),element,10);
        JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),element);
    }

    @And("Benutzer klickt auf das + Symbol neben den Rollen unten rechts")
    public void benutzerKlicktAufDasSymbolNebenDenRollenUntenRechts() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usersPage.plusRoles,10);
        JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),usersPage.plusRoles);
    }

    @And("Benutzer fuegt eine neue Rolle hinzu {string}")
    public void benutzerFuegtEineNeueRolleHinzu(String new_user_another_role) {
        usersPage = new UsersPage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.addNewRole,10);
        usersPage.addNewRole.click();

        usersPage.addNewRole.sendKeys(ConfigReader.getProperty("new_user_another_role")+Keys.ENTER);
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



}
