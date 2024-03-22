package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class RollesSD {


    @And("Der Benutzer sieht, dass der Store Manager angekommen ist.")
    public void derBenutzerSiehtDassDerStoreManagerAngekommenIst() {

    }

    @Then("Der Benutzer bestätigt, dass er auf Store Manager geklickt hat.")
    public void derBenutzerBestatigtDassErAufStoreManagerGeklicktHat() {
    }


    @Then("Benutzer bestaetigt, dass es im Modul Alle Rollen {int} Rollen gibt.")
    public void benutzerBestaetigtDassEsImModulAlleRollenRollenGibt(int arg0) {

    }

    @Given("Benutzer klickt auf der linken Seite der Seite auf „ Rolles“.")
    public void benutzerKlicktAufDerLinkenSeiteDerSeiteAufRolles() {


    }
}
