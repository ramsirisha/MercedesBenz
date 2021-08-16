package org.mercedes.pages;

import java.util.*;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mercedes.resources.Utilities.Utils;
import org.mercedes.resources.base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homePage {

    public WebDriver driver;

//    public By acceptCookies = By.xpath("//button[text()='Settings']/following-sibling::button[text()='Agree to all']");
//   public By bodyType = By.xpath("//span[@class='dcp-vehicle-category-filter-row__label']");

//    @FindBy(xpath = "//button[text()='Agree to all']")
//    public WebElement acceptCookies;

//    @FindBy(xpath = "//span[@class='dcp-vehicle-category-filter-row__label']")
//    public List<WebElement> bodyType;

    public static Logger log = LogManager.getLogger(homePage.class.getName());


    @FindBy(how=How.XPATH, using = "//h2[text()='Mercedes-Benz (Thailand) Ltd. uses cookies for various purposes.']")
    public WebElement acceptCookiesDialog;

    @FindBy(how=How.XPATH, using = "//button[text()='Settings']/following-sibling::button[text()='Agree to all']")
    public WebElement acceptCookies;

//    @FindBy(how=How.XPATH, using = "//span[@class='dcp-vehicle-category-filter-row__label'][text()=' "+Type +" ']/parent::div/button")
//    public WebElement bodyType;

    @FindBy(how=How.XPATH, using = "//span[text()='More details']")
    public List<WebElement> results;

    @FindBy(how=How.XPATH, using = "//iframe[@title='Messenger button']")
    public WebElement iframeMessengerbtn;

    @FindBy(how=How.XPATH, using = "//button[@Class='frame-494qi7 e13411jb0']")
    public WebElement MessengerIcon;


    @FindBy(how=How.XPATH, using = "//iframe[@title='Messenger']")
    public WebElement iframeMessenger;

    @FindBy(how=How.XPATH, using = "//button[@class='e1jpo3mb1 frame-1eq3b13 e1pp1tri8']")
    public WebElement downArrow;

    @FindBy(how=How.XPATH, using = "//div[@class='dcp-loading-spinner']")
    public WebElement loadingIcon;


    public homePage(WebDriver driver) {
        // TODO Auto-generated constructor stub

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public WebElement setAcceptCookies() {
        Utils.waitForElementVisbility(driver,acceptCookies,10);
        return acceptCookies;
    }

    public boolean isMessengerExists(){
        driver.switchTo().frame(iframeMessengerbtn);
        boolean Messenger = MessengerIcon.isDisplayed();
        return Messenger;
    }

    public void clickMessenger() {
        try {
            Utils.waitForElementVisbility(driver,acceptCookies,15);
            Utils.waitForElementVisbility(driver, iframeMessengerbtn, 10);
            driver.switchTo().frame(iframeMessengerbtn);
            MessengerIcon.click();
            driver.switchTo().frame(iframeMessenger);
            downArrow.click();
            log.info("Successfully handled Messenger");
            driver.switchTo().defaultContent();

        }catch (Exception e){
            log.error("Error message is:"+e);
                    }
    }

    public boolean selectBodyType(WebDriver driver,String bType) throws Exception {
       Boolean bool = false;
        WebElement bodyType = driver.findElement(By.xpath("//span[@class='dcp-vehicle-category-filter-row__label'][text()=' "+bType+" ']/parent::div/button"));
        try {
            Utils.waitForElementVisbility(driver, bodyType, 5);
            bodyType.click();
            bool=true;
        }
        catch (ElementClickInterceptedException e){
            log.error("Exception encountered during Body Type selection is:"+e);
            log.info("Handled click interception exception");
            Utils.waitForElementVisbility(driver, bodyType, 5);
            bodyType.click();
            bool=true;
        }
        return bool;

    }


    public boolean selectVehicle(WebDriver driver) throws Exception {
        Boolean bool = false;
        try {
            Utils.waitForElementToBeInvisible(driver, loadingIcon, 5);
            Utils.waitForElementToBeClickable(driver, results.get(0), 10);
            results.get(0).click();
            bool = true;
            log.info("Selected Vehicle from search results");
        }catch (Exception e){
            log.info("Exception during vehicle selection is:"+e);
        }
        return bool;

    }


}
