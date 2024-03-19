package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }


    @FindBy (xpath = "//button[.='Home']")
    public WebElement home;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement nioyaTech;

    @FindBy (xpath = "//li[@id='link0']/a")
    public WebElement profil;

    @FindBy (xpath = "//li[@id='link4']/a")
    public WebElement company;

    @FindBy (xpath = "//li[@id='link5']/a")
    public WebElement departments;

    @FindBy (xpath = "//li[@id='link6']/a")
    public WebElement remoteUnits;

    @FindBy (xpath = "//li[@id='link7']/a")
    public WebElement teams;

    @FindBy (xpath = "//li[@id='link8']/a")
    public WebElement users;

    @FindBy (xpath = "//li[@id='link9']/a")
    public WebElement roles;

    @FindBy (xpath = "//li[@id='link10']/a")
    public WebElement permissions;

    @FindBy (xpath = "//div[@class='btnCollapse']")
    public WebElement menubarOk;

    @FindBy (xpath = "(//span[@class='fw-bold'])[1]")
    public WebElement profilDropDown;
     @FindBy (xpath = "(//span[@class='fw-bold'])[2]")
    public WebElement profilEmailTitel;

     @FindBy(xpath = "(//td[contains(@class,'text-start text-nowrap')])[1]")
     public WebElement profilDropDown2;




    @FindBy(linkText = "Logout")
    public WebElement logout;

    @FindBy (xpath = "(//span[@class='fw-bold'])[2]")
    public WebElement profile;
     @FindBy (xpath = "//li[@id='link0']/a[1]")
    public WebElement profileText;

       @FindBy (id= "link0")
    public WebElement profileText2;




       @FindBy(xpath = "//div[@class='container-fluid sidenav minimize']")
    public WebElement sidebarMin;

   @FindBy(xpath = "//div[@class='container-fluid sidenav']")
    public WebElement sidebarMax;
   @FindBy (id="Sidebar")
    public WebElement sidebar;





}
