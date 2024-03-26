package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.JavascriptUtils;
import utilities.ParallelDriver;
import utilities.ReusableMethods;

import java.time.Duration;
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

    @FindBy(xpath = "//button[.='Reset Password']")
    public WebElement resetPasswordButtonInUserDetail;

    @FindBy(xpath = "//button[.='Confirm']")
    public WebElement confirmButtonForResetPassword;

    @FindBy(tagName = "h5")
    public WebElement resetPasswordMessage;

    @FindBy(xpath = "//button[.='Close']")
    public WebElement closeButtonAfterPasswordReset;


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

    @FindBy(xpath = "//button[text()='Save']")
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

    @FindBy(xpath = "//div[@role='alert']") // alert olduğu için, alerte geçmek gerekebilir
    public WebElement emailErrorMessageInAddingMultipleMember;



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

    public void deleteUser() {
        HomePage homePage = new HomePage();
        WebDriverWait wait = new WebDriverWait(ParallelDriver.getDriver(), Duration.ofSeconds(15));

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),homePage.users,15);
        homePage.users.click();

        ReusableMethods.waitForPageToLoad(5);

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), perPageDropDown, 15);
        Select select = new Select(perPageDropDown);
        select.selectByIndex(4);

        ParallelDriver.getDriver().navigate().refresh();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + ConfigReader.getProperty("new_user_mail") + "']")));

        try {
            JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(), element);
        } catch (StaleElementReferenceException e) {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(ConfigReader.getProperty("new_user_mail"))));
            JavascriptUtils.scrollIntoViewJS(ParallelDriver.getDriver(), element);
        }

        ReusableMethods.waitForPageToLoad(10);

        WebElement threeDots = ParallelDriver.getDriver().
                findElement(By.xpath("//a[.='" + ConfigReader.getProperty("new_user_mail") + "']//parent::td//parent::tr//child::td[7]//div//button"));

        try {
            ReusableMethods.waitForVisibility(ParallelDriver.getDriver(),threeDots,15);
            threeDots.click();
           // JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),threeDots);
        } catch (StaleElementReferenceException e) {
            threeDots = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='" + ConfigReader.getProperty("new_user_mail") + "']//parent::td//parent::tr//child::td[7]//div//button")));
            JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),threeDots);
            // threeDots.click();
        }

        WebElement removefromorganization = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']//parent::td//parent::tr//child::td[7]//div//ul//li[4]/a/a")));
        try {
            removefromorganization.click();
            // JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),removefromorganization);
        } catch (Exception e) {
            removefromorganization = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='"+ConfigReader.getProperty("new_user_mail")+"']//parent::td//parent::tr//child::td[7]//div//ul//li[4]/a/a")));
            // JavascriptUtils.clickElementByJS(ParallelDriver.getDriver(),removefromorganization);
            removefromorganization.click();
        }

        ReusableMethods.waitForVisibility(ParallelDriver.getDriver(), userRemovedMessage, 10);
        ParallelDriver.getDriver().navigate().refresh();
    }





}
