package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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


    @FindBy(xpath = "//button[text()='Crop']")
    public WebElement cropButton;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement saveImageButton;

    @FindBy(xpath = "//p[text()='An error occurred. The picture could not be changed.']")
    public WebElement imageErrorButton;


    @FindBy(xpath = "(//div[@class='col-md-4 row-cols-1']//div)[1]")
    public WebElement departmentTypeDropDown;

    @FindBy(xpath = "//div[text()='Department Roles']")
    public WebElement departmentRolesDropDown;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;

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



    public  void acceptMessageCloseMethod(WebDriver driver, WebElement element){

        try {
            acceptMassageCloseButton.click();
        }catch (Exception ignored){

        }

    }
    public void loeschenRemoteUnit(WebDriver driver, String newUnit) {

        HomePage homePage = new HomePage();
        homePage.remoteUnits.click();
        ReusableMethods.waitForVisibility(driver, search, 10);
        search.clear();
        search.sendKeys(newUnit);
        ReusableMethods.waitForVisibility(driver, ilkRemoteUnit, 10);
        ilkRemoteUnit.click();
        ReusableMethods.waitForVisibility(driver, editRemoteUnitButton, 10);
        editRemoteUnitButton.click();
        System.out.println("Löschen editButton");



        try {
            driver.navigate().refresh();
            ReusableMethods.waitForVisibility(driver, deleteDepartmentButton, 10);

        } catch (Exception e) {
            driver.navigate().refresh();
        }


        ReusableMethods.waitForVisibility(driver, deleteDepartmentButton, 10);
        deleteDepartmentButton.click();
        System.out.println("Löschen editButton tiklandi");
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), deleteconfirmButton, 10);
        deleteconfirmButton.click();
        System.out.println("delete confirm butonu tiklandi");

        ReusableMethods.waitFor(1);
//        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.profil,10);
//        homePage.profil.click();
//        System.out.println("profil butonu tiklandi");

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

    public void executeScript(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("location.reload()");
    }

    public void imageHinzufuegen(WebDriver driver,WebElement imageButton){

        String path=System.getProperty("user.dir")+"\\test-output\\image.jpg";//yükleyecegimiz dosyanin yolu
        System.out.println("path = " + path);
        //Click on Upload button.-->click yapilinca window acilacagi icin robot class gerekir.

        //driver.findElement(By.xpath("(//td)[4]")).click();//Robot class kullanacagimiz icin click yaptik
        ReusableMethods.waitFor(3);
        changeImageButton.click();
        ReusableMethods.waitFor(3);
        //girilecek dosyanin yolunu hafizaya alalim
        StringSelection ss=new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        ReusableMethods.waitFor(3);


        //Robot class kullanarak hafizaya alinan yolu ctrl+V ile acilan pencereye yapistirabiliriz
        Robot robot= null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        //Enter e basalim
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        //click yerine sendKeys metodu ile filepath gönderecegiz
        WebElement chooseFileButton=driver.findElement(By.name("image.jpg"));
        chooseFileButton.sendKeys(path);//input type file oldugu icin bu yöntem kullanilabilir.

        chooseFileButton.submit();//enter e bastik.

        ReusableMethods.waitFor(1);

    }


}
