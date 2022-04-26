package utilities;

import BrowserFactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {
     // This method will click on element
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }
    //This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    //This method will send text on element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

 }
