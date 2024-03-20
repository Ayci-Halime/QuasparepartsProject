package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class RolesPage {
    public static void main(String[] args) {
        System.out.println("RollesPage");
    }

    public RolesPage() { // bu constructor her page sayfasında standart olacak
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }
}
