package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.RolesPage;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class RolesSD {
RolesPage rolesPage;
HomePage homePage;

    @Given("Benutzer klickt auf der linken Seite der Seite auf „Rolles“.")
    public void benutzerKlicktAufDerLinkenSeiteDerSeiteAufRolles() {
        homePage = new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.roles,10);
        homePage.roles.click();

    }

    @Then("Benutzer bestaetigt, dass es im Modul Alle Rollen {int} Rollen gibt.")
    public void benutzerBestaetigtDassEsImModulAlleRollenRollenGibt(int arg0) {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        int size = rolesPage.rolList.size();
        System.out.println(size);
        Assert.assertEquals(14,size);

    }

    @Then("Der Benutzer sieht, dass der Accountant angekommen ist.")
    public void derBenutzerSiehtDassDerAccountantAngekommenIst()  {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesAccountButton.isDisplayed();

    }

    @Then("Der Benutzer sieht, dass der Logistics Manager angekommen ist.")
    public void derBenutzerSiehtDassDerLogisticsManagerAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesLogisticsManagerButton.isDisplayed();
    }

    @Then("Der Benutzer sieht, dass der Purchase Personnel angekommen ist.")
    public void derBenutzerSiehtDassDerPurchasePersonnelAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesPurchasePersonnelButton.isDisplayed();
    }


    @Then("Der Benutzer sieht, dass der Sales Manager angekommen ist.")
    public void derBenutzerSiehtDassDerSalesManagerAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesSalesManagerButton.isDisplayed();


    }

    @Then("Der Benutzer sieht, dass der Warehouse Manager angekommen ist.")
    public void derBenutzerSiehtDassDerWarehouseManagerAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesWarehouseManagerButton.isDisplayed();

    }

    @Then("Der Benutzer sieht, dass der Business Owner angekommen ist.")
    public void derBenutzerSiehtDassDerBusinessOwnerAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesBusinessOwnerButton.isDisplayed();

    }

    @Then("Der Benutzer sieht, dass der Logistics Personnel angekommen ist.")
    public void derBenutzerSiehtDassDerLogisticsPersonnelAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesLogisticsPersonnelButton.isDisplayed();
    }

    @Then("Der Benutzer sieht, dass der Quality Controller angekommen ist.")
    public void derBenutzerSiehtDassDerQualityControllerAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesQualityControllerButton.isDisplayed();

    }

    @Then("Der Benutzer sieht, dass der Sales Personnel angekommen ist.")
    public void derBenutzerSiehtDassDerSalesPersonnelAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesSalesPersonnelButton.isDisplayed();

    }

    @Then("Der Benutzer sieht, dass der Warehouse Personnel angekommen ist.")
    public void derBenutzerSiehtDassDerWarehousePersonnelAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesWarehousePersonnelButton.isDisplayed();
    }

    @Then("Der Benutzer sieht, dass der Customer angekommen ist.")
    public void derBenutzerSiehtDassDerCustomerAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesCustomerButton.isDisplayed();
    }

    @Then("Der Benutzer sieht, dass der Purchase Manager angekommen ist.")
    public void derBenutzerSiehtDassDerPurchaseManagerAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesPurchaseManagerButton.isDisplayed();
    }

    @Then("Der Benutzer sieht, dass der Quality Manager angekommen ist.")
    public void derBenutzerSiehtDassDerQualityManagerAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesQualityManagerButton.isDisplayed();

    }

    @Then("Der Benutzer sieht, dass der Store Manager angekommen ist.")
    public void derBenutzerSiehtDassDerStoreManagerAngekommenIst() {
        homePage = new HomePage();
        rolesPage = new RolesPage();
        rolesPage.rolesStoreManagerButton.isDisplayed();

    }

    @Given("Benutzer klickt links auf der Seite auf Rolles.")
    public void benutzerKlicktLinksAufDerSeiteAufRolles() {
        homePage = new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.roles,10);
        homePage.roles.click();
    }

    @Then("Der Benutzer bestaetigt, dass er auf Accountant geklickt hat.")
    public void derBenutzerBestaetigtDassErAufAccountantGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesAccountButton,10);
        rolesPage.rolesAccountButton.click();
    }

    @Then("Der Benutzer bestaetigt, dass er auf Logistics Manager geklickt hat.")
    public void derBenutzerBestaetigtDassErAufLogisticsManagerGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesLogisticsManagerButton,10);
        rolesPage.rolesLogisticsManagerButton.click();

    }

    @Then("Der Benutzer bestaetigt, dass er auf Purchase Manager geklickt hat.")
    public void derBenutzerBestaetigtDassErAufPurchaseManagerGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesPurchasePersonnelButton,10);
        rolesPage.rolesPurchasePersonnelButton.click();

    }

    @Then("Der Benutzer bestaetigt, dass er auf Sales Manager geklickt hat.")
    public void derBenutzerBestaetigtDassErAufSalesManagerGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesSalesManagerButton,10);
        rolesPage.rolesSalesManagerButton.click();
    }

    @Then("Der Benutzer bestaetigt, dass er auf  Warehouse Manager geklickt hat.")
    public void derBenutzerBestaetigtDassErAufWarehouseManagerGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesWarehouseManagerButton,10);
        rolesPage.rolesWarehouseManagerButton.click();
    }

    @Then("Der Benutzer bestaetigt, dass er auf Business Owner geklickt hat.")
    public void derBenutzerBestaetigtDassErAufBusinessOwnerGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesBusinessOwnerButton,10);
        rolesPage.rolesBusinessOwnerButton.click();
    }

    @Then("Der Benutzer bestaetigt, dass er auf Logistics Personnel  geklickt hat.")
    public void derBenutzerBestaetigtDassErAufLogisticsPersonnelGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesLogisticsPersonnelButton,10);
        rolesPage.rolesLogisticsPersonnelButton.click();

    }

    @Then("Der Benutzer bestaetigt, dass er auf Quality Controll geklickt hat.")
    public void derBenutzerBestaetigtDassErAufQualityControllGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesQualityControllerButton,10);
        rolesPage.rolesQualityControllerButton.click();

    }

    @Then("Der Benutzer bestaetigt, dass er auf Sales Personnel geklickt hat.")
    public void derBenutzerBestaetigtDassErAufSalesPersonnelGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesSalesPersonnelButton,10);
        rolesPage.rolesSalesPersonnelButton.click();


    }

    @Then("Der Benutzer bestaetigt, dass er auf Warehouse Personnel geklickt hat.")
    public void derBenutzerBestaetigtDassErAufWarehousePersonnelGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesWarehousePersonnelButton,10);
        rolesPage.rolesWarehousePersonnelButton.click();
    }

    @Then("Der Benutzer bestaetigt, dass er auf Customer geklickt hat.")
    public void derBenutzerBestaetigtDassErAufCustomerGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesCustomerButton,10);
        rolesPage.rolesCustomerButton.click();
    }

    @Then("Der Benutzer bestaetigt, dass er  Purchase Manager geklickt hat.")
    public void derBenutzerBestaetigtDassErPurchaseManagerGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesPurchaseManagerButton,10);
        rolesPage.rolesPurchaseManagerButton.click();
    }

    @Then("Der Benutzer bestaetigt, dass er auf Quality Manager geklickt hat.")
    public void derBenutzerBestaetigtDassErAufQualityManagerGeklicktHat() {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesQualityManagerButton,10);
        rolesPage.rolesQualityManagerButton.click();

    }

    @Then("Der Benutzer bestaetigt, dass er auf Store Manager geklickt hat.")
    public void derBenutzerBestaetigtDassErAufStoreManagerGeklicktHat() throws InterruptedException {
        rolesPage = new RolesPage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),rolesPage.rolesStoreManagerButton,10);
        rolesPage.rolesStoreManagerButton.click();
    }
}

