package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

import java.util.List;

public class RemoteUnitsPage {

    public RemoteUnitsPage() { // bu constructor her page sayfasında standart olacak
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

    @FindBy(xpath = "((//div[@class='col-4'])[1]")
    public WebElement ilkRemoteUnit;

    @FindBy(xpath = "//div[@class='col-4']")
    public List<WebElement> remoteUnits;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public List<WebElement> editRemoteUnitButton;

    @FindBy(xpath = "//button[text()='Delete Department']")
    public List<WebElement> deleteDepartmentButton;

 @FindBy(xpath = "//button[text()='Confirm']")
    public List<WebElement> deleteconfirmButton;



    @FindBy(xpath = "//input[@name='file']")
    public List<WebElement> changeImageButton;


    @FindBy(xpath = "//button[text()='Crop']")
    public List<WebElement> cropButton;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public List<WebElement> saveImageButton;

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




}
