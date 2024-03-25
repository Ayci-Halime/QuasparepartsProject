package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.PermissionsPage;
import pages.RolesPage;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class PermissionSD {

    HomePage homePage;
   PermissionsPage permissionPage;
    @Given("Benutzer klickt auf der linken Seite der Seite auf „ Permissions“.")
    public void benutzerKlicktAufDerLinkenSeiteDerSeiteAufPermissions() {

        homePage = new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.permissions,10);
        homePage.permissions.click();

    }

    @Then("Der Benutzer sieht, dass der accounting_read angekommen ist.")
    public void derBenutzerSiehtDassDerAccounting_readAngekommenIst() {
        homePage = new HomePage();
        permissionPage = new PermissionsPage();
        permissionPage.accountingRead.isDisplayed();

    }

    @Then("Der Benutzer wird sehen, dass {int} Permission eingegangen sind.")
    public void derBenutzerWirdSehenDassPermissionEingegangenSind(int arg0) {
        homePage = new HomePage();
        permissionPage= new PermissionsPage();
        ReusableMethods.waitForVisibilityOfAllElements(ParallelDriver.getDriver(),permissionPage.perList,10);
        int size = permissionPage.perList.size();
        System.out.println(size);
        Assert.assertEquals(94,size);

    }

    @Then("Der Benutzer sieht, dass der accounting_write angekommen ist.")
    public void derBenutzerSiehtDassDerAccounting_writeAngekommenIst() {
        homePage = new HomePage();
        permissionPage = new PermissionsPage();
        permissionPage.accountingWrite.isDisplayed();

    }
}
