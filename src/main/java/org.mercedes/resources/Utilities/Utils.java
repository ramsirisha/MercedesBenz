package org.mercedes.resources.Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public WebDriver driver;


public static void waitForElementVisbility(WebDriver driver, WebElement element, long timeInSecs){
    WebDriverWait wait = new WebDriverWait(driver,timeInSecs);
    wait.until(ExpectedConditions.visibilityOf(element));
}

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, long timeInSecs){
        WebDriverWait wait = new WebDriverWait(driver,timeInSecs);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeInvisible(WebDriver driver, WebElement element, long timeInSecs){
        WebDriverWait wait = new WebDriverWait(driver,timeInSecs);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }




    public static void javascriptClick(WebElement element, WebDriver driver, String elementDescription)
            throws Exception {
//        if (!Utils.waitForElement(driver, element, 5))
//            throw new Exception(elementDescription + " not found in page!!");

        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (NoSuchElementException e) {
            throw new Exception(elementDescription + " not found in page!!");
        }
    }

    public static void javascriptType(WebElement element, String txtToType, WebDriver driver, String elementDescription)
            throws Exception {

        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + txtToType + "';", element);
        } catch (NoSuchElementException e) {
            throw new Exception(elementDescription + " field not found in page!!");

        }

    }

    public static void mouseHoverAndClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }




}
