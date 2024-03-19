package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class CompanyPage {

    public CompanyPage() {

        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='list-group-item active']")
    public WebElement company;

}
