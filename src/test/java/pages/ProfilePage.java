package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

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












}
