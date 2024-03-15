package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class UsersPage {

    public UsersPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }
}
