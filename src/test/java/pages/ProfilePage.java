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



    @FindBy(xpath= "//div[@role='alert']")
    public WebElement alert;


@FindBy(xpath = "//button[@aria-label='Close']")
public WebElement alertClose;










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
        ReusableMethods.waitForVisibility(driver,confirm,10);
        confirm.click();
        ReusableMethods.waitFor(1);
//        cancel.click();
        try {
          alertClose.click();
        }catch (Exception e) {

        }

    }


    public boolean alertNegativeExpectedMessage(WebDriver driver,WebElement alert){
       boolean flag=false;

       String alertText= ReusableMethods.getElementText(alert);
        if(alertText.contains("Password must be between 8 to 20 characters long.")){
           flag=true;

        }else if(alertText.contains("Password must contain at least one uppercase.")){
            flag=true;
        }else if(alertText.contains("Password may contain only uppercase (A-Z) letters, lowercase (a-z) letters, numbers (0-9), and special characters of .@#$%_&")){
            flag=true;
        }else if(alertText.contains("Password must contain at least one lowercase.")){
            flag=true;
        }else if(alertText.contains("Password must contain special characters from .@#$%_&")){
            flag=true;
        }else if(alertText.contains("Password must contain at least one digit.")){
            flag=true;
        }



    return flag;
    }

    public boolean alertacceptMessage(WebDriver driver,WebElement alert){
        boolean flag=false;

        String alertText= ReusableMethods.getElementText(alert);
        if(alertText.contains("New department successfully created")){
            flag=true;
            alertClose.click();

        }else if(alertText.contains("Change password successfully")){
            flag=true;
            alertClose.click();

        }else if(alertText.contains("Changes successfully saved")){
            flag=true;
            alertClose.click();

        }


        else {flag=false;}



        return flag;
    }

}
