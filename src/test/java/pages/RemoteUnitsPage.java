package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//input[@placeholder='Department Description']")
    public WebElement description;

    @FindBy(xpath = "(//div[@class='col-9']//b)[1]")
    public WebElement ilkRemoteUnit;

    @FindBy(xpath = "//div[@class='col-4']")
    public List<WebElement> remoteUnits;
    @FindBy(xpath = "(//div[@class='row'])[4]")
    public WebElement remoteUnitsrow;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement editRemoteUnitButton;

    @FindBy(xpath = "//button[text()='Delete Department']")
    public WebElement deleteDepartmentButton;

    @FindBy(xpath = "//button[text()='Confirm']")
    public WebElement deleteconfirmButton;

    @FindBy(xpath = "//button[text()=' Edit']")
    public WebElement editButton;


    @FindBy(xpath = "//input[@name='file']")
    public WebElement changeImageButton;


    @FindBy(xpath = "//div[@class='btn-group float-end']//button[1]")
    public WebElement cropButton;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement saveImageButton;


    @FindBy(xpath = "(//div[@class='col-md-4 row-cols-1']//div)[1]")
    public WebElement departmentTypeDropDown;

    @FindBy(xpath = "//div[text()='Department Roles']")
    public WebElement departmentRolesDropDown;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;


    @FindBy(xpath = "//span[text()='Please enter a name for department']")
    public WebElement nameErrorMessage;

    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement departmentTypeErrorMessage;

    @FindBy(xpath = "(//span[@class=' css-1u9des2-indicatorSeparator']/following-sibling::div)[2]")
    public WebElement rolesOk;

    @FindBy(xpath = "//div[@role='alert']//div[1]")
    public WebElement acceptMessage;
    @FindBy(xpath = "//button[@aria-label='Close']")
    public WebElement acceptMassageCloseButton;



    public void loeschenRemoteUnit(WebDriver driver, String newUnit) {

        HomePage homePage = new HomePage();
        ReusableMethods.waitForVisibility(driver,homePage.remoteUnits,10);
        homePage.remoteUnits.click();
        ReusableMethods.waitForVisibility(driver, search, 10);
        ReusableMethods.deleteFields(search,newUnit);
        search.sendKeys(newUnit);
        ReusableMethods.waitForVisibility(driver, ilkRemoteUnit, 10);
        ilkRemoteUnit.click();
        try {
            acceptMassageCloseButton.click();
        }catch (Exception e){
            System.out.println("message not found");
        }

        ReusableMethods.waitForVisibility(driver, editRemoteUnitButton, 10);

        editRemoteUnitButton.click();
        System.out.println("Löschen editButton");

        try {

            driver.navigate().refresh();

            ReusableMethods.waitForVisibility(driver, deleteDepartmentButton, 10);

        } catch (Exception e) {

            driver.navigate().refresh();

        }

        ReusableMethods.waitForPageToLoad(5);

        ReusableMethods.waitForVisibility(driver, deleteDepartmentButton, 10);
        deleteDepartmentButton.click();

        System.out.println("Löschen editButton tiklandi");
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), deleteconfirmButton, 10);
        deleteconfirmButton.click();
        System.out.println("delete confirm butonu tiklandi");

        ReusableMethods.waitFor(1);

    }



    public void erstellungRemoteUnit(WebDriver driver, String DepartmentName, String DepartmentType) {
        HomePage homePage = new HomePage();
        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(), homePage.remoteUnits, 10);
        homePage.remoteUnits.click();
        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(), addNewRemoteUnitButton, 10);
        addNewRemoteUnitButton.click();
        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(), name, 10);
        name.sendKeys(DepartmentName);
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), departmentTypeDropDown, 10);
        dropDownClick(ParallelDriver.getDriver(), DepartmentType, departmentTypeDropDown);
        ReusableMethods.waitForClickablility(ParallelDriver.getDriver(), saveButton, 10);
        saveButton.click();
        if (acceptMassageCloseButton.isDisplayed()) {
            acceptMassageCloseButton.click();
        }

    }

    public void erstellungRemoteUnit(WebDriver driver, String DepartmentName, String DepartmentType, String shortName, String descriptionText, String roleText) {
        HomePage homePage = new HomePage();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), homePage.remoteUnits, 10);
        homePage.remoteUnits.click();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), addNewRemoteUnitButton, 10);
        addNewRemoteUnitButton.click();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), name, 10);
        name.sendKeys(DepartmentName);
        ReusableMethods.waitForVisibility(driver, short_name, 10);
        short_name.sendKeys(shortName);
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), departmentTypeDropDown, 10);
        dropDownClick(ParallelDriver.getDriver(), DepartmentType, departmentTypeDropDown);
        ReusableMethods.waitForVisibility(driver, description, 10);
        description.sendKeys(descriptionText);
        ReusableMethods.waitForVisibility(driver, departmentRolesDropDown, 10);
        dropDownClick(driver, roleText, departmentRolesDropDown);
        rolesOk.click();
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), saveButton, 10);
        saveButton.click();
        if (acceptMassageCloseButton.isDisplayed()) {
            acceptMassageCloseButton.click();
        }
    }


    public void dropDownClick(WebDriver driver, String text, WebElement dropdown) {
        Actions actions = new Actions(driver);
        actions.click(dropdown).sendKeys(text).sendKeys(Keys.ENTER).perform();

    }





}
