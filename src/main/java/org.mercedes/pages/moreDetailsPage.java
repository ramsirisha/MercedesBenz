package org.mercedes.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mercedes.resources.Utilities.Utils;
import org.mercedes.resources.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class moreDetailsPage {

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @FindBy(how = How.XPATH, using = "//span[text()='Contact Me']/parent::button")
    public WebElement btnContactMe;


    public moreDetailsPage(WebDriver driver) {
        // TODO Auto-generated constructor stub

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean clickContactMe(WebDriver driver) throws Exception {
        boolean bool = false;
        try {
            Utils.waitForElementToBeClickable(driver, btnContactMe, 5);
            Utils.javascriptClick(btnContactMe, driver, "clicking Contact Me button");
            bool = true;
        } catch (Exception e) {
            log.info("Exception during Contact Me button is:" + e);
        }
        return bool;

    }


}
