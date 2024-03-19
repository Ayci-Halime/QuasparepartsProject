package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class ProfilePage {

    public ProfilePage() { // bu constructor her page sayfasında standart olacak
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }



    @FindBy(xpath = "//button[contains(@class,'btn btn-ghost-dark')]")
    public WebElement editButton;

    @FindBy(id= "changePasswordButton")
    public WebElement changePasswordButton;

     @FindBy(id= "email")
    public WebElement email;

     @FindBy(id= "username")
    public WebElement username;
        @FindBy(id= "newPassword")
    public WebElement newPassword;

    @FindBy(id= "newPassword2")
    public WebElement newPassword2;

 @FindBy(xpath= "//button[text()='Confirm']")
    public WebElement confirm;

  @FindBy(xpath= "//button[text()='Cancel']")
    public WebElement cancel;

@FindBy(xpath= "//div[@role='alert']//div[1]")
    public WebElement alertAccept;

@FindBy(xpath= "//div[text()='Password must be between 8 to 20 characters long.']")
    public WebElement alertlong;

@FindBy(xpath= "//div[@role='alert']")
    public WebElement alertUppercase;

@FindBy(xpath= "//div[@role='alert']")
    public WebElement alertLowercase;

@FindBy(xpath= "//div[@role='alert']")
    public WebElement alertSpecCharacters;

@FindBy(xpath= "//div[@role='alert']")
    public WebElement alertNegative;

@FindBy(xpath= "//div[@role='alert']")
    public WebElement alertDigit;










    public void loginMethodProfile (WebDriver driver) {
        LoginPage loginPage=new LoginPage();
        ReusableMethods.waitForVisibility(driver,loginPage.login,10);
        loginPage.login.click();

        ReusableMethods.waitForVisibility(driver,username,10);
        username.sendKeys(ConfigReader.getProperty("userNameProfile"));

        ReusableMethods.waitForVisibility(driver,loginPage.password,10);
        loginPage.password.sendKeys(ConfigReader.getProperty("passwordProfile"));

        ReusableMethods.waitForVisibility(driver,loginPage.signin,10);
        loginPage.signin.click();



    }

    public void passwordAktualisieren(WebDriver driver){
        ReusableMethods.waitForVisibility(driver,changePasswordButton,10);
        changePasswordButton.click();
        ReusableMethods.waitForVisibility(driver,newPassword,10);
        newPassword.sendKeys(ConfigReader.getProperty("passwordProfile"));
        newPassword2.sendKeys(ConfigReader.getProperty("passwordProfile"));
        confirm.click();
        cancel.click();

    }

}
