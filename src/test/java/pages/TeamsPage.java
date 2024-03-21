package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class TeamsPage {

    public TeamsPage() { // bu constructor her page sayfasında standart olacak
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement add_new_Team;
    @FindBy(xpath = "//div[@class=' css-19bb58m']")
    public WebElement Teams_Type;
    @FindBy(xpath = "//button[.='Save']")
    public WebElement Teams_Save;
      @FindBy(xpath = "//span[@class='fw-bold fs-4']")
    public WebElement Teams_assert;
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement Edit_Team;

}
