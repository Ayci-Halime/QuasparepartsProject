package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.ParallelDriver;

public class UsersSD {

    @Given("Benutzer meldet sich an")
    public void benutzer_meldet_sich_an() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginMethod(ParallelDriver.getDriver());
    }
    @When("Benutzer klickt auf das Menu Benutzer")
    public void benutzer_klickt_auf_das_menu_benutzer() {

    }

    @When("Benutzer fuegt einen Benutzer hinzu")
    public void benutzer_fuegt_einen_benutzer_hinzu() {

    }
    @When("Benutzer sucht die E-Mail Adresse des neuen Benutzers")
    public void benutzer_sucht_die_e_mail_adresse_des_neuen_benutzers() {

    }
    @Then("Benutzer bestaetigt dass der neue Benutzer hinzugefuegt ist")
    public void benutzer_bestaetigt_dass_der_neue_benutzer_hinzugefuegt_ist() {

    }
    @Then("Benutzer loescht den neuen hinzugefuegten Benutzer")
    public void benutzer_loescht_den_neuen_hinzugefuegten_benutzer() {

    }



}
