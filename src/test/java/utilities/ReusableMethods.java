package utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;





public class ReusableMethods {

    // Edit yaparken field ları silen metot
    public static void deleteFields(WebElement element,String text) {

        int size = text.length();
        for (int i = 0; i < size; i++){
            element.sendKeys(Keys.BACK_SPACE);
        }
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

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(ParallelDriver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

        //   HARD WAIT WITH THREAD.SLEEP
        //   waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }










}
