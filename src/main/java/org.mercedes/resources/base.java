package org.mercedes.resources;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;
    public Properties prop;
    private static final Logger log = LogManager.getLogger(base.class);

    public base() {
        this.driver = driver;

    }

    public base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/org.mercedes/resources/data.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/java/org.mercedes/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            log.info("Launching" + " " + browserName + " " + "browser");
            //To execute in chrome browser

        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/java/org.mercedes/resources/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
            log.info("Launching" + " " + browserName + " " + "browser");
            //To execute in edge browser
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String filename = new SimpleDateFormat("yyyymmddhhMMss").format(new Date());
        String destinationFile = System.getProperty("user.dir") + "\\reports\\Screenshots\\" + testCaseName + "_" + filename + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;

    }

}
