package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class CompanyPage {

    public CompanyPage() { // bu constructor her page sayfasında standart olacak
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }



}
