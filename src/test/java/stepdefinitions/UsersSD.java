package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
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
import java.util.ArrayList;
import java.util.List;


public class UsersSD {
    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;
    List<WebElement> usersRoles;
    static List<String> emails = new ArrayList<>();

    @Given("Benutzer meldet sich an")
    public void benutzer_meldet_sich_an() {
        loginPage = new LoginPage();
        loginPage.loginMethod(ParallelDriver.getDriver());
    }

    @When("Benutzer klickt auf das Menu Benutzer")
    public void benutzer_klickt_auf_das_menu_benutzer() {
        homePage = new HomePage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), homePage.menubarOk, 15);
        homePage.menubarOk.click();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), homePage.users, 15);
        JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(), homePage.users);
    }

    @When("Benutzer fuegt einen Benutzer hinzu")
    public void benutzer_fuegt_einen_benutzer_hinzu() {
        usersPage = new UsersPage();
        homePage = new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.addNewMember, 10);
        usersPage.addNewMember.click();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.departmentField, 10);
        usersPage.departmentField.click();
        usersPage.departmentField.sendKeys(ConfigReader.getProperty("new_user_department") + Keys.ENTER + Keys.ESCAPE);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.roleField, 10);
        usersPage.roleField.sendKeys(ConfigReader.getProperty("new_user_default_role") + Keys.ENTER);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.emailField, 10);
        usersPage.emailField.sendKeys(ConfigReader.getProperty("new_user_mail"));

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.registerButton, 10);
        usersPage.registerButton.click();

        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(), usersPage.closeButton, 10);
        usersPage.closeButton.click();

    }

    @When("Benutzer sucht die E-Mail Adresse des neuen Benutzers")
    public void benutzer_sucht_die_e_mail_adresse_des_neuen_benutzers() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.searchBox, 15);
        usersPage.searchBox.clear();
        usersPage.searchBox.sendKeys(ConfigReader.getProperty("new_user_mail"));

    }

    @Then("Benutzer bestaetigt dass der neue Benutzer hinzugefuegt ist")
    public void benutzer_bestaetigt_dass_der_neue_benutzer_hinzugefuegt_ist() {
        usersPage = new UsersPage();

        ReusableMethods.waitForPageToLoad(3);

        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(), usersPage.newUserEmailAfterSearch, 15);
        Assert.assertTrue("New added user is not visible", usersPage.newUserEmailAfterSearch.isDisplayed());
        ParallelDriver.getDriver().navigate().refresh();

    }

    @Then("Benutzer loescht den neuen hinzugefuegten Benutzer")
    public void benutzer_loescht_den_neuen_hinzugefuegten_benutzer() {
        usersPage = new UsersPage();
        WebDriverWait wait = new WebDriverWait(ParallelDriver.getDriver(), Duration.ofSeconds(15));

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.perPageDropDown, 15);
        Select select = new Select(usersPage.perPageDropDown);
        select.selectByIndex(4);

        ParallelDriver.getDriver().navigate().refresh();
        //  WebElement element = ParallelDriver.getDriver().findElement(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']"));
        // WebElement element = ParallelDriver.getDriver().
//                findElement(By.xpath("//tbody[@class='tableRows']/tr/td[2]/a"));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+   ConfigReader.getProperty("new_user_mail")   +"']")));
        ReusableMethods.waitForPageToLoad(3);
        try {
            //element.click();
            JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(), element);
        } catch (StaleElementReferenceException e) {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+   ConfigReader.getProperty("new_user_mail")  +"']")));
            JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(), element);
            // JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),element);
        }
        //  ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),element,15);
        //   JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(),element);

        ReusableMethods.waitForPageToLoad(3);

        WebElement threeDots = ParallelDriver.getDriver().
                findElement(By.xpath("//a[text()='" + ConfigReader.getProperty("new_user_mail") + "']//parent::td//parent::tr//child::td[7]//div//button"));
        // WebElement threeDots = ParallelDriver.getDriver().findElement(By.xpath("(//div[@class='btn-group'])[2]/button"));
        try {
            threeDots.click();
        } catch (StaleElementReferenceException e) {
            threeDots = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + ConfigReader.getProperty("new_user_mail") + "']//parent::td//parent::tr//child::td[7]//div//button")));
            JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),threeDots);
          //  threeDots.click();
        }catch (Exception e){
            threeDots.click();
        }


        // ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),threeDots,20);

        //JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),threeDots);
        //   threeDots.click();


        //ReusableMethods.waitForClickablility(ParallelDriver.getDriver(),usersPage.removeFromOrganizaiton,10);
        WebElement removefromorganization = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']//parent::td//parent::tr//child::td[7]//div//ul//li[4]/a/a")));
        ReusableMethods.waitForPageToLoad(3);
        try {
            removefromorganization.click();
           // JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),removefromorganization);
        } catch (StaleElementReferenceException e) {
            // threeDots = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']//parent::td//parent::tr//child::td[7]//div")));
            removefromorganization = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']//parent::td//parent::tr//child::td[7]//div//ul//li[4]/a/a")));
           // JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),removefromorganization);
            removefromorganization.click();
        }catch (Exception e) {
            removefromorganization = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']//parent::td//parent::tr//child::td[7]//div//ul//li[4]/a/a")));
            removefromorganization.click();
        }

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.userRemovedMessage, 10);
        ParallelDriver.getDriver().navigate().refresh();

    }


    @And("Benutzer klickt auf den gesuchten Benutzer")
    public void benutzerKlicktAufDenGesuchtenBenutzer() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.perPageDropDown, 15);
        Select select = new Select(usersPage.perPageDropDown);
        select.selectByIndex(4);

        WebElement element = ParallelDriver.getDriver().
                findElement(By.xpath("//a[text()='"+ConfigReader.getProperty("new_user_mail")+"']"));



        JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(), element);
        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(), element, 10);
        JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(), element);
        // element.click();

        //ParallelDriver.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    @And("Benutzer klickt auf das + Symbol neben den Rollen unten rechts")
    public void benutzerKlicktAufDasSymbolNebenDenRollenUntenRechts() {
        usersPage = new UsersPage();
        ReusableMethods.waitForPageToLoad(3);
        usersRoles = usersPage.usersRoles; // burda yeni rol eklemeden önce rolleri listeye aldım
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.plusRoles, 10);
        JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(), usersPage.plusRoles);
    }

    @And("Benutzer fuegt eine neue Rolle hinzu {string}")
    public void benutzerFuegtEineNeueRolleHinzu(String new_user_another_role) {
        usersPage = new UsersPage();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.addNewRole, 10);
        usersPage.addNewRole.click();
        ReusableMethods.waitForPageToLoad(3);

        usersPage.addNewRole.sendKeys(ConfigReader.getProperty(new_user_another_role));
        ReusableMethods.waitForPageToLoad(3);
        usersPage.addNewRole.sendKeys(Keys.ENTER);
        ReusableMethods.waitForPageToLoad(2);
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.saveButton, 10);
        try {
            usersPage.saveButton.click();
        }catch (Exception e){
            usersPage.saveButton.click();
        }

    }

    @Then("Benutzer prueft dass die Rolle hinzugefuegt ist")
    public void benutzerPrueftDassDieRolleHinzugefuegtIst() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.addingNewRoleMessage, 10);
        String actualResult = ReusableMethods.getElementText(usersPage.addingNewRoleMessage);
        String expectedResult = "New role added for this user successfuly";

        Assert.assertEquals(expectedResult, actualResult);
    }

    @And("Benutzer kehrt zum Benutzermenu zuruck")
    public void benutzerKehrtZumBenutzermenuZuruck() {
        homePage = new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), homePage.users, 10);
        homePage.users.click();
    }


    @And("Benutzer loescht die hinzugefuegte Rolle")
    public void benutzerLoeschtDieHinzugefuegteRolle() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.deleteRoleThreeDots, 10);
        usersPage.deleteRoleThreeDots.click();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.removeRole, 10);
        usersPage.removeRole.click();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.confirmButtonForDeleteRole, 10);
        usersPage.confirmButtonForDeleteRole.click();

    }

    @Then("Benutzer bestaetigt dass die Rolle geloescht wurde")
    public void benutzerBestaetigtDassDieRolleGeloeschtWurde() {
        usersPage = new UsersPage();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.deleteRoleMessage, 10);
        int roleListSize = usersPage.usersRoles.size();
        ReusableMethods.waitForPageToLoad(3);
        Assert.assertTrue(usersPage.deleteRoleMessage.isDisplayed());
        Assert.assertEquals(usersRoles.size(), roleListSize);
    }

    @And("Benutzer klickt auf das Bearbeitungssymbol \\(Stift) oben rechts")
    public void benutzerKlicktAufDasBearbeitungssymbolStiftObenRechts() {
        usersPage = new UsersPage();

        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(), usersPage.editIconInUserDetail, 10);
        usersPage.editIconInUserDetail.click();

    }

    @Then("Benutzer bestaetigt dass die E-Mail Adresse nicht geandert werden konnen")
    public void benutzerBestaetigtDassDieEMailAdresseNichtGeandertWerdenKonnen() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.emailInUserDetail, 10);
        Assert.assertTrue(usersPage.emailInUserDetail.isDisplayed());

    }

    @And("Benutzer klickt auf das Symbol Speichern oben rechts")
    public void benutzerKlicktAufDasSymbolSpeichernObenRechts() {

        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.saveIconInUserDetail, 10);
        usersPage.saveIconInUserDetail.click();

    }

    @And("Benutzer loescht das Feld fuer den Benutzernamen")
    public void benutzerLoeschtDasFeldFuerDenBenutzernamen() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.click();
        String text = ConfigReader.getProperty("new_user_mail");
        ReusableMethods.deleteFields(usersPage.usernameInUserDetail, text);

    }

    @Then("Benutzer bestaetigt dass er eine Fehlermeldung im Users erhalten hat")
    public void benutzerBestaetigtDassErEineFehlermeldungImUsersErhaltenHat() {
        usersPage = new UsersPage();
        String errorMessage = "Username cannot be empty";
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameErrorMessageInUserDetail, 10);
        Assert.assertTrue(usersPage.usernameErrorMessageInUserDetail.getText().equalsIgnoreCase(errorMessage));
    }

    @And("Benutzer klickt auf das Schließen-Symbol oben rechts")
    public void benutzerKlicktAufDasSchließenSymbolObenRechts() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.closeIconInUserDetail, 10);
        usersPage.closeIconInUserDetail.click();
    }

    @And("Benutzer gibt Daten ein, die mit einem Buchstaben beginnen {string}")
    public void benutzerGibtDatenEinDieMitEinemBuchstabenBeginnen(String new_user_username) {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.click();
        ReusableMethods.deleteFields(usersPage.usernameInUserDetail, ConfigReader.getProperty("new_user_mail"));
       // ReusableMethods.waitFor(5);
        ReusableMethods.waitForPageToLoad(5);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.sendKeys(ConfigReader.getProperty(new_user_username));
    }

    @Then("Benutzer bestaetigt dass der Benutzername aktualisiert wurde")
    public void benutzerBestaetigtDassDerBenutzernameAktualisiertWurde() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        String expectedResult = ConfigReader.getProperty("new_user_username");
        String actualResult = ReusableMethods.getElementText(usersPage.usernameInUserDetailAfterEditing);

        Assert.assertEquals(expectedResult, actualResult);

        usersPage.changeUsernameToPreviousOne();
    }

    @And("Benutzer gibt Daten ein, die mit einer Zahl beginnen {string}")
    public void benutzerGibtDatenEinDieMitEinerZahlBeginnen(String new_user_username1) {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.click();
        ReusableMethods.deleteFields(usersPage.usernameInUserDetail, ConfigReader.getProperty("new_user_mail"));
       // ReusableMethods.waitFor(5);
        ReusableMethods.waitForPageToLoad(5);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.sendKeys(ConfigReader.getProperty(new_user_username1));
    }

    @Then("Benutzer bestaetigt dass er eine Fehlermeldung im Users mit Zahl erhalten hat")
    public void benutzerBestaetigtDassErEineFehlermeldungImUsersMitZahlErhaltenHat() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        String expectedResult = "Username must start with letters (A-Za-z)";
        String actualResult = ReusableMethods.getElementText(usersPage.usernameErrorMessageInUserDetail);

        Assert.assertEquals(expectedResult, actualResult);


    }

    @Then("Benutzer bestaetigt dass Benutzername nicht aktualisiert wurde")
    public void benutzerBestaetigtDassBenutzernameNichtAktualisiertWurde() {
        usersPage = new UsersPage();
        loginPage = new LoginPage();

        String actualResult = ReusableMethods.getElementText(usersPage.usernameInUserDetailAfterEditing);
        String expectedResult = ConfigReader.getProperty("new_user_mail");
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);
        usersPage.changeUsernameToPreviousOne();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameUpdateMessage, 10);

        usersPage.deleteUser();
        loginPage.logoutMethod(ParallelDriver.getDriver());

        Assert.assertEquals(expectedResult, actualResult);

    }

    @And("Benutzer gibt Daten ein, die mit einem Sonderzeichen beginnen {string}")
    public void benutzerGibtDatenEinDieMitEinemSonderzeichenBeginnen(String new_user_username2) {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.click();
        ReusableMethods.deleteFields(usersPage.usernameInUserDetail, ConfigReader.getProperty("new_user_mail"));
       // ReusableMethods.waitFor(5);
        ReusableMethods.waitForPageToLoad(5);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.sendKeys(ConfigReader.getProperty(new_user_username2));
    }

    @Then("Benutzer bestaetigt dass er eine Fehlermeldung im Users mit Sonderzeichen erhalten hat")
    public void benutzerBestaetigtDassErEineFehlermeldungImUsersMitSonderzeichenErhaltenHat() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        String expectedResult = "Username may contain letters (A-Za-z), numbers (0-9), and special characters of -._";
        String actualResult = ReusableMethods.getElementText(usersPage.usernameErrorMessageInUserDetail);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @And("Benutzer gibt Daten ein, die mit einem Sonderzeichen enden {string}")
    public void benutzerGibtDatenEinDieMitEinemSonderzeichenEnden(String new_user_username3) {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.click();
        ReusableMethods.deleteFields(usersPage.usernameInUserDetail, ConfigReader.getProperty("new_user_mail"));
      //  ReusableMethods.waitFor(5);
        ReusableMethods.waitForPageToLoad(5);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.sendKeys(ConfigReader.getProperty(new_user_username3));
    }

    @And("Benutzer gibt Daten ein, die mit einem Sonderzeichen enthalten {string}")
    public void benutzerGibtDatenEinDieMitEinemSonderzeichenEnthalten(String new_user_username4) {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.click();
        ReusableMethods.deleteFields(usersPage.usernameInUserDetail, ConfigReader.getProperty("new_user_mail"));
      //  ReusableMethods.waitFor(5);
        ReusableMethods.waitForPageToLoad(5);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.sendKeys(ConfigReader.getProperty(new_user_username4));
    }

    @And("Benutzer gibt Daten ein, die ein Sonderzeichen enthalten {string}")
    public void benutzerGibtDatenEinDieEinSonderzeichenEnthalten(String new_user_username5) {

        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.click();
        ReusableMethods.deleteFields(usersPage.usernameInUserDetail, ConfigReader.getProperty("new_user_mail"));
     //   ReusableMethods.waitFor(5);
        ReusableMethods.waitForPageToLoad(5);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetail, 10);
        usersPage.usernameInUserDetail.sendKeys(new_user_username5);
    }

    @Then("Benutzer bestaetigt dass er keine Fehlermeldung erhalten hat")
    public void benutzerBestaetigtDassErKeineFehlermeldungErhaltenHat() {
        usersPage = new UsersPage();

        boolean element;
        try {
            element = usersPage.usernameErrorMessageInUserDetail.isDisplayed();
            Assert.assertFalse(element);
        } catch (NoSuchElementException e) {
            element = false;
            Assert.assertFalse(element);
        }

    }

    @Then("Benutzer bestaetigt dass der Benutzername aktualisiert ist")
    public void benutzerBestaetigtDassDerBenutzernameAktualisiertIst() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.usernameInUserDetailAfterEditing, 10);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("ad-min");
        expectedResult.add("ad_min");
        expectedResult.add("ad.min");
        String actualResult = ReusableMethods.getElementText(usersPage.usernameInUserDetailAfterEditing);

        Assert.assertTrue(expectedResult.contains(actualResult));

        usersPage.changeUsernameToPreviousOne();

    }

    @And("Benutzer klickt auf den Link Password zurucksetzen")
    public void benutzerKlicktAufDenLinkPasswordZurucksetzen() {

        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.resetPasswordButtonInUserDetail, 10);
        usersPage.resetPasswordButtonInUserDetail.click();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.confirmButtonForResetPassword, 10);
        usersPage.confirmButtonForResetPassword.click();
    }

    @Then("Benutzer bestaetigt dass das Password zuruckgesetzt wurde")
    public void benutzerBestaetigtDassDasPasswordZuruckgesetztWurde() {

        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.resetPasswordMessage, 10);
        String expectedMessage = "Reset Password Successfully";
        String actualMessage = usersPage.resetPasswordMessage.getText();
        System.out.println("actualMessage = " + actualMessage);

        Assert.assertTrue(expectedMessage.contains(actualMessage));

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.closeButtonAfterPasswordReset, 10);
        usersPage.closeButtonAfterPasswordReset.click();

    }


    @Then("Benutzer bestaetigt dass die Schaltflache Neues Mitglied einladen angezeigt wird")
    public void benutzerBestaetigtDassDieSchaltflacheNeuesMitgliedEinladenAngezeigtWird() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.inviteNewMember, 10);
        Assert.assertTrue("Invite New Member button is not displayed", usersPage.inviteNewMember.isDisplayed());
    }

    @Then("Benutzer bestaetigt dass die Schaltflache Neues Mitglied hinzufugen angezeigt wird")
    public void benutzerBestaetigtDassDieSchaltflacheNeuesMitgliedHinzufugenAngezeigtWird() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.addNewMember, 10);
        Assert.assertTrue("Add New Member button is not displayed", usersPage.addNewMember.isDisplayed());
    }

    @Then("Benutzer bestaetigt dass die Schaltflache Mehrere Mitglieder hinzufugen angezeigt wird")
    public void benutzerBestaetigtDassDieSchaltflacheMehrereMitgliederHinzufugenAngezeigtWird() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.addMultipleMembers, 10);
        Assert.assertTrue("Add Multiple Members button is not displayed", usersPage.addMultipleMembers.isDisplayed());

    }

    @And("Benutzer klickt auf die Schaltflaeche Neues Mitglied Einladen")
    public void benutzerKlicktAufDieSchaltflaecheNeuesMitgliedEinladen() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.inviteNewMember, 10);
        usersPage.inviteNewMember.click();

    }

    @And("Benutzer waehlt Abteilung")
    public void benutzerWaehltAbteilung() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.departmentField, 10);
        usersPage.departmentField.sendKeys(ConfigReader.getProperty("new_user_department") + Keys.ENTER + Keys.ESCAPE);
    }

    @And("Benutzer waehlt Rolle")
    public void benutzerWaehltRolle() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.roleField, 10);
        usersPage.roleField.sendKeys(ConfigReader.getProperty("new_user_default_role") + Keys.ENTER);
    }

    @And("Benutzer gibt seine E-Mail Adresse ein")
    public void benutzerGibtSeineEMailAdresseEin() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.emailField, 10);
        usersPage.emailField.sendKeys(ConfigReader.getProperty("new_user_mail") + Keys.ENTER);
    }

    @And("Benutzer klickt auf Schaltflaeche Einladen")
    public void benutzerKlicktAufSchaltflaecheEinladen() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.inviteButton, 10);
        usersPage.inviteButton.click();
    }

    @Then("Benutzer bestaetigt dass die Einladungs E-Mail verschickt wurde")
    public void benutzerBestaetigtDassDieEinladungsEMailVerschicktWurde() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.invitationMessage, 10);
        String expected = "A invitation e-mail has been sent to the e-mail address you entered";
        String actual = usersPage.invitationMessage.getText();
        Assert.assertEquals("Invitatiton message is not visible", expected, actual);
        System.out.println("actual = " + actual);
    }

    @And("Benutzer klickt auf Schaltflaeche Schliessen")
    public void benutzerKlicktAufSchaltflaecheSchliessen() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.closeButton, 10);
        usersPage.closeButton.click();
        ParallelDriver.getDriver().navigate().refresh();
    }

    @And("Benutzer laesst die Rolle leer")
    public void benutzerLaesstDieRolleLeer() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.roleField, 10);
        usersPage.roleField.click();
        usersPage.roleField.sendKeys(Keys.ESCAPE);
    }

    @Then("Benutzer bestaetigt dass er eine Fehlermeldung beim Einladen und Hinzufuegun erhalten hat")
    public void benutzerBestaetigtDassErEineFehlermeldungBeimEinladenUndHinzufuegunErhaltenHat() {
        usersPage = new UsersPage();

        List<String> errors = new ArrayList<>();
        errors.add("Please enter a valid email");
        errors.add("Please select a role for the user you will add");

        String actual = usersPage.errorMessageInAddingInInviting.getText();
        Assert.assertTrue("Error message is not displayed", errors.contains(actual));
        System.out.println("actual = " + actual);

    }

    @And("Benutzer laesst die E-Mail-Adresse leer")
    public void benutzerLaesstDieEMailAdresseLeer() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.emailField, 10);
        usersPage.emailField.click();
        usersPage.emailField.sendKeys(Keys.ESCAPE);
    }

    @And("Benutzer laesst Abteilung leer")
    public void benutzerLaesstAbteilungLeer() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.departmentField, 10);
        usersPage.departmentField.click();
        usersPage.departmentField.sendKeys(Keys.ESCAPE);
    }

    @And("Benutzer klickt auf die Schaltflaeche Neues Mitglied hinzufugen")
    public void benutzerKlicktAufDieSchaltflaecheNeuesMitgliedHinzufugen() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.addNewMember, 10);
        usersPage.addNewMember.click();
    }

    @And("Benutzer klickt auf die Schaltflaeche Registrieren")
    public void benutzerKlicktAufDieSchaltflaecheRegistrieren() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.registerButton, 10);
        usersPage.registerButton.click();

    }

    @Then("Benutzer ueberprueft, dass ein neuer Benutzer hinzugefuegt wurde")
    public void benutzerUeberprueftDassEinNeuerBenutzerHinzugefuegtWurde() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.addingNewMemberMessage, 10);
        String actual = usersPage.addingNewMemberMessage.getText();
        Assert.assertEquals("Successful", actual);
        System.out.println("actual = " + actual);

    }

    @And("Benutzer klickt auf die Schaltflaeche Mehrere Mitglieder hinzufugen")
    public void benutzerKlicktAufDieSchaltflaecheMehrereMitgliederHinzufugen() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.addMultipleMembers, 10);
        usersPage.addMultipleMembers.click();
    }

    @And("Benutzer waehlt die Rolle aus")
    public void benutzerWaehltDieRolleAus() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.roleInMultipleUser, 10);
        usersPage.roleInMultipleUser.sendKeys(ConfigReader.getProperty("new_user_default_role") + Keys.ENTER);
    }


    @And("Benutzer waehld die Abteilungsart aus")
    public void benutzerWaehldDieAbteilungsartAus() {
        usersPage = new UsersPage();
        int secim = (int) (Math.random() * 3);
        List<String> deparmentType = new ArrayList<>();
        deparmentType.add("Departments");
        deparmentType.add("Remote Units");
        deparmentType.add("Teams");

        System.out.println("Department Type => " + deparmentType.get(secim));

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.departmentTypeInMultipleUser, 10);
        usersPage.departmentTypeInMultipleUser.sendKeys(deparmentType.get(secim) + Keys.ENTER);

    }

    @And("Benutzer waehlt die Abteilung aus")
    public void benutzerWaehltDieAbteilungAus() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.departmentInMultipleUser, 10);
        usersPage.departmentInMultipleUser.sendKeys("P1" + Keys.ENTER);
    }

    @And("Benutzer gibt seine E-Mail-Adresse in das E-Mail-Feld ein")
    public void benutzerGibtSeineEMailAdresseInDasEMailFeldEin() {
        usersPage = new UsersPage();
        String email1 = Faker.instance().internet().emailAddress();
        System.out.println("email1 = " + email1);
        String email2 = Faker.instance().internet().emailAddress();
        System.out.println("email2 = " + email2);
        emails = new ArrayList<>();
        emails.add(email1);
        emails.add(email2);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.emailFieldInMultipleUser, 10);
        usersPage.emailFieldInMultipleUser.sendKeys(email1 + Keys.ENTER);
        usersPage.emailFieldInMultipleUser.sendKeys(email2 );
    }

    @And("Benutzer klickt auf die Schaltflaeche E-Mails Registrieren")
    public void benutzerKlicktAufDieSchaltflaecheEMailsRegistrieren() {
        usersPage = new UsersPage();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.registerEmailsButtonInMultipleUser, 10);
        usersPage.registerEmailsButtonInMultipleUser.click();
    }

    @Then("Benutzer bestaetigt, dass neue Benutzer hinzugefuegt wurde")
    public void benutzerBestaetigtDassNeueBenutzerHinzugefuegtWurde() {
        usersPage = new UsersPage();
        String expected = "User registered";

        ReusableMethods.waitForVisibilityOfAllElements(ParallelDriver.getDriver(), usersPage.successMessageInAddingMultipleMember, 20);
        List<WebElement> messages = usersPage.successMessageInAddingMultipleMember;

        if (messages.size() != 1) {
            int count = 0;
            for (int i = 0; i < messages.size(); i++) {
                if (messages.get(i).getText().equals(expected)) count++;
            }
            Assert.assertEquals("Succes message is not matching", count, messages.size());
        } else {
            int count = 0;
            for (int i = 0; i < messages.size(); i++) {
                if (messages.get(i).getText().equals(expected)) count++;
            }
            Assert.assertEquals("Succes message is not matching", count, messages.size());
        }

    }

    @And("Benutzer loescht die neuen hinzugefuegten Benutzern")
    public void benutzerLoeschtDieNeuenHinzugefuegtenBenutzern() {
        usersPage = new UsersPage();
        homePage = new HomePage();
        WebDriverWait wait = new WebDriverWait(ParallelDriver.getDriver(), Duration.ofSeconds(15));

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), homePage.users, 10);
        homePage.users.click();

        if (emails.size() != 1) {

            ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.perPageDropDown, 15);
            Select select = new Select(usersPage.perPageDropDown);
            select.selectByIndex(4);

            for (int i = 0; i < emails.size(); i++) {

                ParallelDriver.getDriver().navigate().refresh();

                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(emails.get(i))));

                try {
                    //element.click();
                    JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(), element);
                } catch (StaleElementReferenceException e) {
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(emails.get(i))));
                    JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(), element);
                    // JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),element);
                }

                ReusableMethods.waitForPageToLoad(5);

                WebElement threeDots = ParallelDriver.getDriver().
                        findElement(By.xpath("//a[.='" + emails.get(i) + "']//parent::td//parent::tr//child::td[7]//div//button"));

                try {
                    ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),threeDots,10);
                    threeDots.click();
                    //JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),threeDots);
                } catch (StaleElementReferenceException e) {
                    threeDots = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='" + emails.get(i) + "']//parent::td//parent::tr//child::td[7]//div//button")));
                    ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),threeDots,10);
                    //JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),threeDots);
                    threeDots.click();
                }

                WebElement removefromorganization = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='"+emails.get(i)+"']//parent::td//parent::tr//child::td[7]//div//ul//li[4]/a/a")));
                try {
                    ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),removefromorganization,10);
                    removefromorganization.click();
                } catch (StaleElementReferenceException e) {
                    // threeDots = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']//parent::td//parent::tr//child::td[7]//div")));
                    removefromorganization = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='"+emails.get(i)+"']//parent::td//parent::tr//child::td[7]//div//ul//li[4]/a/a")));
                    ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),removefromorganization,10);
                 //   removefromorganization.click();
                    JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),removefromorganization);
                }
                //usersPage.removeFromOrganizaiton.click();

                ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.userRemovedMessage, 10);
            }

        } else {
            ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.perPageDropDown, 15);
            Select select = new Select(usersPage.perPageDropDown);
            select.selectByIndex(4);

            ParallelDriver.getDriver().navigate().refresh();
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(emails.get(0))));
            ParallelDriver.getDriver().navigate().refresh();
            try {
                //element.click();
                JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(), element);
            } catch (StaleElementReferenceException e) {
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(emails.get(0))));
                JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(), element);
                // JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),element);
            }

            ReusableMethods.waitForPageToLoad(5);

            WebElement threeDots = ParallelDriver.getDriver().
                    findElement(By.xpath("//a[.='" + emails.get(0) + "']//parent::td//parent::tr//child::td[7]//div//button"));

            try {
                threeDots.click();
            } catch (StaleElementReferenceException e) {
               threeDots = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='" + emails.get(0) + "']//parent::td//parent::tr//child::td[7]//div//button")));
                //JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),threeDots);
                threeDots.click();
            }

            WebElement removefromorganization = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='"+emails.get(0)+"']//parent::td//parent::tr//child::td[7]//div//ul//li[4]/a/a")));
            try {
                removefromorganization.click();
            } catch (StaleElementReferenceException e) {
                removefromorganization = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='"+emails.get(0)+"']//parent::td//parent::tr//child::td[7]//div//ul//li[4]/a/a")));
                removefromorganization.click();
            }
            //usersPage.removeFromOrganizaiton.click();

            ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.userRemovedMessage, 10);

        }


    }

    @And("Benutzer laesst das Feld Benutzerrolle leer")
    public void benutzerLaesstDasFeldBenutzerrolleLeer() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.roleInMultipleUser, 10);
        usersPage.departmentField.click();
        usersPage.departmentField.sendKeys(Keys.ESCAPE);
    }

    @Then("Benutzer bestaetigt dass er eine Fehlermeldung beim mehrere mitglieder Hinzufuegen erhalten hat")
    public void benutzerBestaetigtDassErEineFehlermeldungBeimMehrereMitgliederHinzufuegenErhaltenHat() {
        usersPage = new UsersPage();
        String expected = "Please select a role for the user you will add";
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.errorMessageInAddingMultipleMember, 10);
        String actual = usersPage.errorMessageInAddingMultipleMember.getText();
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        Assert.assertEquals("Error mesasge is not maching",expected,actual);
    }

    @And("Benutzer laesst das Feld Abteilungstyp leer")
    public void benutzerLaesstDasFeldAbteilungstypLeer() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.departmentTypeInMultipleUser, 10);
        usersPage.departmentTypeInMultipleUser.click();
        usersPage.departmentTypeInMultipleUser.sendKeys("Teams"+Keys.ENTER+Keys.BACK_SPACE);
    }

    @And("Benutzer laesst das Feld Abteilung leer")
    public void benutzerLaesstDasFeldAbteilungLeer() {
        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.departmentInMultipleUser, 10);
        usersPage.departmentInMultipleUser.click();
        usersPage.departmentInMultipleUser.sendKeys(Keys.ESCAPE);
    }

    @And("Benutzer laesst das EMail Feld leer")
    public void benutzerLaesstDasEMailFeldLeer() {

        usersPage = new UsersPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.emailFieldInMultipleUser, 10);
        usersPage.emailFieldInMultipleUser.click();
    }

    @Then("Benutzer bestaetigt dass er eine Fehlermeldung im Email beim mehrere mitglieder Hinzufuegen erhalten hat")
    public void benutzerBestaetigtDassErEineFehlermeldungImEmailBeimMehrereMitgliederHinzufuegenErhaltenHat() {
        usersPage = new UsersPage();
        String expected = "Please enter an email at least.";
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.emailErrorMessageInAddingMultipleMember, 10);
        String actual = usersPage.emailErrorMessageInAddingMultipleMember.getText();

        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);

        Assert.assertEquals("Error message does not match",expected,actual);
    }

    @And("Benutzer gibt eine E-Mail-Adresse in das E-Mail-Feld ein")
    public void benutzerGibtEineEMailAdresseInDasEMailFeldEin() {
        usersPage = new UsersPage();
        String email = Faker.instance().internet().emailAddress();
        System.out.println("email = " + email);

        emails = new ArrayList<>();
        emails.add(email);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), usersPage.emailFieldInMultipleUser, 10);
        usersPage.emailFieldInMultipleUser.sendKeys(email);

    }
}
