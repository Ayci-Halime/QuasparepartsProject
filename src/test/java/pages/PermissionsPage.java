package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

import java.util.List;

public class PermissionsPage {

    public PermissionsPage() { // bu constructor her page sayfasında standart olacak
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-12 d-grid mb-2']")
    public List<WebElement> perList;


}