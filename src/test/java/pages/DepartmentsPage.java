package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class DepartmentsPage {

    public DepartmentsPage() { // bu constructor her page sayfasında standart olacak
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div[1]/div[2]/a/button")
    public WebElement add_new_Department;

    @FindBy(xpath = "//b[.='Finance Department']")
    public WebElement Finance_Department;
    @FindBy(xpath = "//b[.='Logistics Department']")
    public WebElement Logistics_Department;
    @FindBy(xpath = "//b[.='Marketing and Sales Department']")
    public WebElement Marketing_and_Sales_Department;
    @FindBy(xpath = "//b[.='Quality Assurance Department']")
    public WebElement Quality_Assurance_Department;
    @FindBy(xpath = "//b[.='personel']")
    public WebElement personel_Department;
   // @FindBy(xpath = "//input[@id='name']")
     @FindBy(id = "name")
    public WebElement Department_oder_Team_Name;
    @FindBy(xpath = "//input[@name='short_name']")
    public WebElement Department_oder_Team_Short_Name;
    @FindBy(xpath = "//div[@class=' css-hlgwow']")
    public WebElement Department_Type;
    @FindBy(xpath = "//button[.='Save']")
    public WebElement Department_Save;
    @FindBy(xpath = "//span[.='Please enter a name for department']")
    public WebElement Name_Leer;

    @FindBy(xpath = "//span[.='Please select a type for department']")
    public WebElement Type_Leer;
//@FindBy(xpath = "(//button[@type='button'])[3]")
    @FindBy(xpath = "//button[text()=' Edit ']")
    public WebElement Edit_Department;

@FindBy(xpath = "//input[@name='description']")
    public WebElement description_Department;
@FindBy(xpath = "//div[@class='col-12']")
    public WebElement description_Department_assert;

@FindBy(xpath = "(//span)[8]")
    public WebElement Kurzname_Department_Personel_assert;
@FindBy(xpath = "//span[@class='roles-box p-2 me-2']")
    public WebElement Department_Rolle_assert;

@FindBy(xpath = "//button[.='Delete Department']")
    public WebElement Department_Delete_button;

@FindBy(xpath = "//button[.='Confirm']")
    public WebElement Department_Delete_Confirm;
@FindBy(xpath = "//input[@name='file']")
    public WebElement Department_Chance_image;




}
