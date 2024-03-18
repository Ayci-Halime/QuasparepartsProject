package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.HomePage;

public class HomeSD {

    HomePage homePage;
    @Then("Benutzer bestaetigt, dass  das Nioyatech-Logo sichtbar ist")
    public void benutzerBestaetigtDassDasNioyatechLogoSichtbarIst() {
        homePage=new HomePage();
        homePage.nioyaTech.isDisplayed();

    }
}
