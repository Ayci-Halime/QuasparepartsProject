package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

public class LoginPage {

    public LoginPage() { // bu constructor her page sayfasında standart olacak
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='login-button']")
    public WebElement login;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signin;

    @FindBy (linkText = "Forgot password ?")
    public WebElement forgotPasswordLink;


    public void loginMethod (WebDriver driver) {
        ReusableMethods.waitForVisibility(driver,login,10);
        login.click();

        ReusableMethods.waitForVisibility(driver,username,10);
        username.sendKeys(ConfigReader.getProperty("username"));

        ReusableMethods.waitForVisibility(driver,password,10);
        password.sendKeys(ConfigReader.getProperty("password"));

        ReusableMethods.waitForVisibility(driver,signin,10);
        signin.click();

    }

    public void logoutMethod (WebDriver driver) {
        HomePage homePage = new HomePage();

        ReusableMethods.waitForVisibility(driver,homePage.profilDropDown,10);
        homePage.profilDropDown.click();

        ReusableMethods.waitForVisibility(driver,homePage.logout,10);
        homePage.logout.click();
    }


}
