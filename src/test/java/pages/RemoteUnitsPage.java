package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.util.List;

public class RemoteUnitsPage {

    public RemoteUnitsPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//b[text()='K��ln Warehouse']")
    public WebElement element;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement addNewRemoteUnitButton;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "search")
    public WebElement search;


    @FindBy(name = "short_name")
    public WebElement short_name;

    @FindBy(name = "(//input[@name='description'])[1]")
    public WebElement description;

    @FindBy(xpath = "(//div[@class='col-9']//b)[1]")
    public WebElement ilkRemoteUnit;

    @FindBy(xpath = "//div[@class='col-4']")
    public List<WebElement> remoteUnits;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement editRemoteUnitButton;

    @FindBy(xpath = "//button[text()='Delete Department']")
    public WebElement deleteDepartmentButton;

 @FindBy(xpath = "//button[text()='Confirm']")
    public WebElement deleteconfirmButton;



    @FindBy(xpath = "//input[@name='file']")
    public WebElement changeImageButton;


    @FindBy(xpath = "//button[text()='Crop']")
    public WebElement cropButton;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement saveImageButton;

    @FindBy(xpath = "//p[text()='An error occurred. The picture could not be changed.']")
    public WebElement imageErrorButton;


    @FindBy(xpath = "//div[text()='Department Type']")
    public WebElement departmentTypeDropDown;

    @FindBy(xpath = "//div[text()='Department Roles']")
    public WebElement departmentRolesDropDown;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;



    public void loeschen(WebDriver driver,String newUnit){

        search.sendKeys(newUnit);
        ReusableMethods.waitForClickablility(driver,ilkRemoteUnit,10);
        ilkRemoteUnit.click();
        ReusableMethods.waitForClickablility(driver,editRemoteUnitButton,10);
        editRemoteUnitButton.click();
        ReusableMethods.waitForVisibility(driver,deleteDepartmentButton,10);
        deleteDepartmentButton.click();

    }


}
