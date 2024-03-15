package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ParallelDriver;


public class Hooks {


    @Before
    public void setUp(Scenario scenario) {

        System.out.println("Senaryodan önce: Test ortamı ayarlanıyor...");
        System.out.println("Senaryo ID'si= " + scenario.getId());
        System.out.println();
    }

    @After
    public void teardown(Scenario scenario) {
        System.out.println("\nSenaryodan sonra: Test ortamı temizleniyor...");

        if (scenario.isFailed()) {
            System.out.println("Senaryo başarısız oldu");
            final byte[] screenshot = ((TakesScreenshot) ParallelDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Başarısız Senaryo Ekran Görüntüsü");
            System.out.println("Başarısız senaryo için ekran görüntüsü alındı: " + scenario.getName());

        }
        System.out.println();

        ParallelDriver.closeDriver();

    }

}
