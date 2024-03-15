package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ReusableMethods {


    public static void dropdownDisplay(String text) {


    }

    public static void dropDownClick(WebDriver driver,String text) {


    }

    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static List<WebElement> waitForVisibilityOfAllElements(List<WebElement> element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
    public static WebElement waitForClickablility(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static String getElementText(WebElement element) {
        System.out.println(element.getText());
        return element.getText();
    }

    //Bu method, elementin text'indeki string sayısal ifadeyi int ifadeye çevirir
    public static int convertElementTextIntoInteger(WebElement element) {
        System.out.println(element.getText());
        String text = element.getText();
        text = text.replaceAll("[^0-9]","");
        System.out.println(text);
        return Integer.parseInt(text);
    }

    //Bu method, elementin text'indeki string sayısal ifadeyi double ifadeye çevirir
    public static double convertElementTextIntoDouble(WebElement element) {
        System.out.println(element.getText());
        String text = element.getText();
        text = text.replaceAll("[^0-9]","");
        System.out.println(text);
        return Double.parseDouble(text);
    }




}
