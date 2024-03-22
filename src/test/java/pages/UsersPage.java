package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.util.List;

public class UsersPage {

    public UsersPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }


    @FindBy (xpath = "//div[@class='col-12']/a/button")
    public WebElement addMultipleMembers;

    @FindBy (xpath = "//button[.='+ Add New Member']")
    public WebElement addNewMember;

    @FindBy (xpath = "//div[@class='col-12']/button[1]")
    public WebElement inviteNewMember;

    @FindBy (xpath = "//input[@name='search']")
    public WebElement searchBox;

    @FindBy (xpath = "//tbody[@class='tableRows']/tr/td[2]/a")
    public WebElement newUserEmailAfterSearch;


    @FindBy(linkText = "Reset Password")
    public WebElement resetPassword;

    @FindBy(xpath = "//button[.='Reset Password']")
    public WebElement resetPasswordButtonInUserDetail;

    @FindBy(xpath = "//button[.='Confirm']")
    public WebElement confirmButtonForResetPassword;

    @FindBy(tagName = "h5")
    public WebElement resetPasswordMessage;

    @FindBy(xpath = "//button[.='Close']")
    public WebElement closeButtonAfterPasswordReset;

    @FindBy(linkText = "Verify Email")
    public WebElement verifryEmail;

    @FindBy(linkText = "Remove from Organization")
    public WebElement removeFromOrganizaiton;


    @FindBy (xpath = "(//div[@class=' css-19bb58m']/input)[1]")
    public  WebElement departmentField;  // Add new member ve invite new member butonları ile yapılan eklemelerdeki alan

    @FindBy (xpath = "(//div[@class=' css-19bb58m']/input)[2]")
    public WebElement roleField;  // Add new member ve invite new member butonları ile yapılan eklemelerdeki alan

    @FindBy (xpath = "//input[@name='email']")
    public WebElement emailField;  // Add new member ve invite new member butonları ile yapılan eklemelerdeki alan

    @FindBy (xpath = "//button[.='Register']")
    public WebElement registerButton;

    @FindBy (xpath = "//button[.='Close']")
    public WebElement closeButton;

    @FindBy (xpath = "//button[.='Invite']")
    public WebElement inviteButton;

    @FindBy(xpath = "//div[@class='toast-body']/p")
    public WebElement invitationMessage;

    @FindBy(xpath = "//div[@class='toast-body']/p")
    public WebElement userRemovedMessage;

    @FindBy(xpath = "//strong[@class='me-auto']")
    public WebElement addingNewMemberMessage; // Add New Member butonu ile kullanıcı eklerken gelen success mesajı. bu mesajı close butonuna tıklamadan önce al


    @FindBy(xpath = "//img[contains(@class,'cursor-pointer')]")
    public WebElement plusRoles;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement addNewRole;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='toast-body']/p")
    public WebElement addingNewRoleMessage;

    @FindBy(xpath = "//span[@class='mx-2']")
    public List<WebElement> usersRoles;  // bu liste olarak bir kullancınını kaç tane rolü olduğunu belirler

    @FindBy(xpath = "//select[@class='form-select form-select-sm']") // bu select tag ile çalışıyor
    public WebElement perPageDropDown;

    @FindBy(xpath = "//div[contains(@class,'btn-group dropup')]/button")
    public WebElement deleteRoleThreeDots;

    @FindBy(xpath = "//a[.='Remove Role']")
    public WebElement removeRole;

    @FindBy(xpath = "//button[.='Confirm']")
    public WebElement confirmButtonForDeleteRole;

    @FindBy(xpath = "//div[@class='toast-body']/p")
    public WebElement deleteRoleMessage;

    @FindBy(xpath = "//span[contains(@class,'float-end')]/button")
    public WebElement editIconInUserDetail;

    @FindBy(xpath = "//span[contains(@class,'float-end')]/button[1]")
    public WebElement saveIconInUserDetail;

    @FindBy(xpath = "//span[contains(@class,'float-end')]/button[2]")
    public WebElement closeIconInUserDetail;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInUserDetail;

    @FindBy(xpath = "//label[@name='username']")
    public WebElement usernameInUserDetailAfterEditing;

    @FindBy(xpath = "//label[@name='email']")
    public WebElement emailInUserDetail;

    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement usernameErrorMessageInUserDetail;

    @FindBy(xpath = "(//div[@class='btn-group'])[2]/button")
    public WebElement threeDots;

    @FindBy(xpath = "//div[@class='toast-body']/p")
    public WebElement usernameUpdateMessage;

    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement errorMessageInAddingInInviting;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement roleInMultipleUser;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement departmentTypeInMultipleUser;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement departmentInMultipleUser;

    @FindBy(xpath = "//textarea[@name='newEmails']")
    public WebElement emailFieldInMultipleUser;

    @FindBy(xpath = "//button[.='Register Emails']")
    public WebElement registerEmailsButtonInMultipleUser;

    @FindBy(xpath = "//span[@class='text-success']")
    public List<WebElement> successMessageInAddingMultipleMember; // birden fazla mail ekleyince liste şeklinde mesajları alsın diye

    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement errorMessageInAddingMultipleMember;



    public void changeUsernameToPreviousOne() {
        String text = usernameInUserDetailAfterEditing.getText();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),editIconInUserDetail,10);
        editIconInUserDetail.click();

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),usernameInUserDetail,10);
        usernameInUserDetail.click();

        ReusableMethods.deleteFields(usernameInUserDetail,text);
        ReusableMethods.waitFor(3);

        usernameInUserDetail.sendKeys(ConfigReader.getProperty("new_user_mail"));
        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),saveIconInUserDetail,10);
        saveIconInUserDetail.click();
    }



}
