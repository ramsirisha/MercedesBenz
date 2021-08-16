package org.mercedes.pages;

import org.mercedes.resources.Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class fillContactsPage {

    public WebDriver driver;


    @FindBy(how = How.XPATH, using = "//h2[text()=' Contact details ']")
    public WebElement popupContactDetails;

    @FindBy(how = How.XPATH, using = "//label[text()=' First name ']")
    public WebElement lblFirstName;

    @FindBy(how = How.XPATH, using = "//label[text()=' First name ']/following-sibling::input")
    public WebElement txtFirstName;


    @FindBy(how = How.XPATH, using = " //label[text()=' Last Name ']")
    public WebElement lblLastName;

    @FindBy(how = How.XPATH, using = " //label[text()=' Last Name ']/following-sibling::input")
    public WebElement txtLastName;


    @FindBy(how = How.XPATH, using = "//label[text()=' E-mail Address ']")
    public WebElement lblEmailAddress;

    @FindBy(how = How.XPATH, using = "//label[text()=' E-mail Address ']/following-sibling::input")
    public WebElement txtEmailAddress;

    @FindBy(how = How.XPATH, using = "//label[text()=' Mobile Phone ']")
    public WebElement lblMobilePhone;

    @FindBy(how = How.XPATH, using = "//label[text()=' Mobile Phone ']/following-sibling::input")
    public WebElement txtMobilePhone;

    @FindBy(how = How.XPATH, using = "//span[text()='I have read and understood the ']/parent::label/input")
    public WebElement chkPrivacyPolicy;

    @FindBy(how = How.XPATH, using = "//button[text()= ' Proceed ']")
    public WebElement btnProceed;

    @FindBy(how = How.XPATH, using = "//iframe[@title='Messenger']")
    public WebElement iframeMessenger;

    @FindBy(how = How.XPATH, using = "//button[@class='e1jpo3mb1 frame-1eq3b13 e1pp1tri8']")
    public WebElement downArrow;

    public fillContactsPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getTextOfPopupContactDetails(WebDriver driver) throws Exception {
        String ContactDetailsDialog;
        ContactDetailsDialog = popupContactDetails.getText();
        return ContactDetailsDialog;
    }

    public String enterFirstName(WebDriver driver, String text) throws Exception {
        Utils.javascriptClick(lblFirstName, driver, "Entering first name");
        Utils.javascriptType(txtFirstName, text, driver, "entering first name in contact details page");
        String enteredText;
        enteredText = txtFirstName.getAttribute("value");
        return enteredText;
    }

    public String enterLastName(WebDriver driver, String text) throws Exception {
        Utils.javascriptClick(lblLastName, driver, "Entering first name");
        Utils.javascriptType(txtLastName, text, driver, "entering first name in contact details page");
        String enteredText;
        enteredText = txtLastName.getAttribute("value");
        return enteredText;
    }

    public String enterMobileNumber(WebDriver driver, String text) throws Exception {
        String enteredText;
        Utils.javascriptClick(lblMobilePhone, driver, "Entering first name");
        Utils.javascriptType(txtMobilePhone, text, driver, "entering first name in contact details page");
        enteredText = txtMobilePhone.getAttribute("value");
        return enteredText;
    }

    public String enterEmailAddress(WebDriver driver, String text) throws Exception {
        Utils.javascriptClick(lblEmailAddress, driver, "Entering first name");
        Utils.javascriptType(txtEmailAddress, text, driver, "entering first name in contact details page");
        String enteredText;
        enteredText = txtEmailAddress.getAttribute("value");
        return enteredText;
    }

    public boolean acceptPrivacyPolicy(WebDriver driver) throws Exception {
        boolean bool = false;
        Utils.javascriptClick(chkPrivacyPolicy, driver, "Entering first name");
        if (chkPrivacyPolicy.isSelected()) {
            bool = true;
        }
        return bool;
    }

    public WebElement Proceed(WebDriver driver) throws Exception {
        return btnProceed;
    }


}
