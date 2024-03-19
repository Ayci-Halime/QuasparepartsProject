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
    @FindBy(xpath = "//input[@id='name']")
    public WebElement Department_Name;
    @FindBy(xpath = "//input[@name='short_name']")
    public WebElement Department_Short_Name;
    @FindBy(xpath = "//div[@class=' css-hlgwow']")
    public WebElement Department_Type;
    @FindBy(xpath = "//button[.='Save']")
    public WebElement Department_Save;
    @FindBy(xpath = "//span[.='Please enter a name for department']")
    public WebElement Name_Leer;

    @FindBy(xpath = "//span[.='Please select a type for department']")
    public WebElement Type_Leer;


}
