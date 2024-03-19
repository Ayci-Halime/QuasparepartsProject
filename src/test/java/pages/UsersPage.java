package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.ParallelDriver;

import java.util.List;

public class UsersPage {

    public UsersPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }


    @FindBy (xpath = "//div[@class='col-12']/a/button")
    public WebElement addMultipleMembers;

    @FindBy (xpath = "//div[@class='col-12']/button[2]")
    public WebElement addNewMember;

    @FindBy (xpath = "//div[@class='col-12']/button[1]")
    public WebElement inviteNewMember;

    @FindBy (xpath = "//input[@name='search']")
    public WebElement searchBox;

    @FindBy (xpath = "//tbody[@class='tableRows']/tr/td[2]/a")
    public WebElement newUserEmailAfterSearch;


    @FindBy(linkText = "Reset Password")
    public WebElement resetPassword;

    @FindBy(linkText = "Verify Email")
    public WebElement verifryEmail;

    @FindBy(linkText = "Remove from Organization")
    public WebElement removeFromOrganizaiton;


    @FindBy (xpath = "(//div[@class=' css-19bb58m']/input)[1]")
    public  WebElement departmentInAddNewMember;

    @FindBy (xpath = "(//div[@class=' css-19bb58m']/input)[2]")
    public WebElement roleInAddNewMember;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy (xpath = "//button[.='Register']")
    public WebElement registerButton;

    @FindBy (xpath = "//button[.='Close']")
    public WebElement closeButton;

    @FindBy (xpath = "//button[.='Invite']")
    public WebElement inviteButton;

    @FindBy (xpath = "(//div[@class=' css-19bb58m'])[1]")
    public WebElement departmentInInviteNewMember;

    @FindBy (xpath = "(//div[@class=' css-19bb58m'])[2]")
    public WebElement roleInInviteNewMember;

    @FindBy(xpath = "//div[@class='toast-body']/p")
    public WebElement invitationMessage;

    @FindBy(xpath = "//div[@class='toast-body']/p")
    public WebElement userRemovedMessage;

    @FindBy(xpath = "//strong[@class='me-auto']")
    public WebElement addingNewMemberMessage; // bu mesajı close butonuna tıklamadan önce al


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








}
