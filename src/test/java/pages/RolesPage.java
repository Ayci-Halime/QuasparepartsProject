package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

import java.util.List;

public class RolesPage {

    public RolesPage() {

        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-12 d-grid mb-2']")
    public List<WebElement> rolList;


    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement rolesAccountButton;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement rolesLogisticsManagerButton;

    @FindBy(xpath = "(//button[@type='button'])[9]")
    public WebElement rolesPurchasePersonnelButton;

    @FindBy(xpath = "(//button[@type='button'])[12]")
    public WebElement rolesSalesManagerButton;

    @FindBy(xpath = "(//button[@type='button'])[15]")
    public WebElement rolesWarehouseManagerButton;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement rolesBusinessOwnerButton;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement rolesLogisticsPersonnelButton;
    @FindBy(xpath = "(//button[@type='button'])[10]")
    public WebElement rolesQualityControllerButton;

    @FindBy(xpath = "(//button[@type='button'])[13]")
    public WebElement rolesSalesPersonnelButton;

    @FindBy(xpath = "(//button[@type='button'])[16]")
    public WebElement rolesWarehousePersonnelButton;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement rolesCustomerButton;

    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement rolesPurchaseManagerButton;

    @FindBy(xpath = "(//button[@type='button'])[11]")
    public WebElement rolesQualityManagerButton;

    @FindBy(xpath = "(//button[@type='button'])[14]")
    public WebElement rolesStoreManagerButton;



}
