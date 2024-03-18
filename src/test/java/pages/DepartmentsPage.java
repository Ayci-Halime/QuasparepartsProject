package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class DepartmentsPage {

    public DepartmentsPage() { // bu constructor her page sayfasında standart olacak
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }
@FindBy(xpath = "(//button[@type='button'])[3]")
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

}
