package org.benz.testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mercedes.pages.fillContactsPage;
import org.mercedes.pages.homePage;
import org.mercedes.pages.moreDetailsPage;
import org.mercedes.resources.Utilities.excelReader;
import org.mercedes.resources.base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.mercedes.resources.Listener;
import org.testng.annotations.Listeners;


import java.io.IOException;

@Listeners(Listener.class)
public class benzTest extends base {

    public static final Logger log = LogManager.getLogger(benzTest.class);
    public WebDriver driver;
    public excelReader testdata = new excelReader();

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is launched");
    }

    @Test
    public void mercedesBenzPageNavigation() throws Exception {

        //Launching Mercedes Benz URL
        driver.get(prop.getProperty("url"));
        log.info("Launching Mercedes Benz URL:" + prop.getProperty("url"));
        homePage hp = new homePage(driver);

        // To handle Messenger when it appears
        hp.clickMessenger();

        //To check whether cookies dialog appears
        String expectedDialog = "Mercedes-Benz (Thailand) Ltd. uses cookies for various purposes.";
        boolean CookiesDialog = hp.acceptCookiesDialog.isDisplayed();
        if (CookiesDialog) {
            Assert.assertEquals(hp.acceptCookiesDialog.getText(), expectedDialog);
            log.info("Cookies dialog appears");
        } else {
            log.info("Cookies dialog is not visible");
        }

        //To check whether accept cookies button appears and accept it
        boolean b = hp.setAcceptCookies().isDisplayed();
        if (b) {
            Assert.assertTrue(b, "Accept cookies button is visible");
            log.info("Accept cookies button is visible");
            hp.setAcceptCookies().click();
            log.info("Clicked on Accept cookies button");
        } else {
            log.info("Accept cookies button is not visible");
        }

        //To Select Body Type based on value provided in test data sheet
        String Type = testdata.getData("BodyType");
        log.info("Body type provided in test data file is:" + Type);
        Assert.assertTrue(hp.selectBodyType(driver, Type), "Selected the body type");
        log.info("Body Type" + " " + Type + " " + "selected");

        //To Select Vehicle from results appear after selecting Body type
        Assert.assertTrue(hp.selectVehicle(driver), "Selected the vehicle from results and clicked on More details");
        log.info("Clicked on More details button");

        //To click on Contact Me button
        moreDetailsPage dp = new moreDetailsPage(driver);
        Assert.assertTrue(dp.clickContactMe(driver), "Clicked on Contact Me button successfully");
        log.info("Clicked on Contact Me button");

        //To fill required details in Contact Details page
        fillContactsPage cp = new fillContactsPage(driver);
        if (cp.popupContactDetails.isDisplayed()) ;
        {
            Assert.assertEquals(cp.getTextOfPopupContactDetails(driver),"Contact details");
            log.info("Contact Details Popup appears");
        }

        Assert.assertEquals(cp.enterFirstName(driver, testdata.getData("FirstName")), testdata.getData("FirstName"), "Entered First Name");
        log.info("Entered First Name");
        Assert.assertEquals(cp.enterLastName(driver, testdata.getData("LastName")), testdata.getData("LastName"), "Entered Last Name");
        log.info("Entered Last Name");
        Assert.assertEquals(cp.enterEmailAddress(driver, testdata.getData("EmailAddress")), testdata.getData("EmailAddress"), "Entered Email Address");
        log.info("Entered Email Address");
        Assert.assertEquals(cp.enterMobileNumber(driver, testdata.getData("MobileNo")), testdata.getData("MobileNo"), "Entered MobileNo");
        log.info("Entered Mobile Number");
        Assert.assertTrue(cp.acceptPrivacyPolicy(driver), "Selected Accept Privacy Policy Checkbox");
        log.info("Selected accept privacy policy checkbox");

        //To check if Proceed button is enabled
        if (cp.Proceed(driver).isEnabled()) {
            Assert.assertFalse(cp.Proceed(driver).isEnabled(), "Proceed button is enabled");
            log.info("Proceed button is enabled");

        } else {
            cp.Proceed(driver).isEnabled();
            Assert.assertFalse(cp.Proceed(driver).isEnabled(), "Proceed button is not enabled");
            log.info("Proceed button is not enabled");
        }

    }

    @AfterTest
    public void teardown() {

        driver.quit();


    }


}

