package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class CompanyPage {

    public CompanyPage() {

        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='list-group-item active']")
    public WebElement company;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement editCompanyButton;

    @FindBy(id = "name")
    public WebElement companyName;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement warning;

    public void companyMethod (WebDriver driver) {

        ReusableMethods.waitForVisibility(driver,company,10);
        company.click();

        ReusableMethods.waitForVisibility(driver,company,10);
        editCompanyButton.click();

        ReusableMethods.waitForVisibility(driver,companyName,10);
        companyName.clear();

        ReusableMethods.waitForVisibility(driver,companyName,10);
        companyName.click();

        ReusableMethods.waitForVisibility(driver,saveButton,10);
        saveButton.click();

        ReusableMethods.waitForVisibility(driver,warning,10);
        warning.click();




    }





}
