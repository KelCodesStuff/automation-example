package com.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseFramework {
    protected static WebDriver driver;
    protected Wait<WebDriver> wait;
    private static final Logger LOG = LoggerFactory.getLogger(BaseFramework.class);
    private static final String CONFIG_FILE = "./config/automation.properties";
    private static final String DRIVER_CHROME = "chrome";
    private static final String DRIVER_FIREFOX = "firefox";
    private static Properties configuration;

    @BeforeClass
    public static void beforeClass() throws IOException {
        configuration = new Properties();
        FileInputStream input;

        LOG.info("Loading in configuration file.");
        input = new FileInputStream(new File(CONFIG_FILE));
        configuration.loadFromXML(input);
        input.close();
        
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUpBefore() {
        DesiredCapabilities capabilities;
        // Which driver to use?
        if (DRIVER_CHROME.equalsIgnoreCase(configuration.getProperty("Browser"))) {
            capabilities = DesiredCapabilities.chrome();
            driver = new ChromeDriver(capabilities);
        } else if (DRIVER_FIREFOX.equalsIgnoreCase(configuration.getProperty("Browser"))) {
            capabilities = DesiredCapabilities.firefox();
            driver = new FirefoxDriver(capabilities);
        }
        // Define fluent wait
        wait = new FluentWait<>(driver).withTimeout(15, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
    }

    protected static String getConfiguration(String config) {
        return configuration.getProperty(config);
    }

    public void signIn() throws InterruptedException {
        driver.get(getConfiguration("Homepage"));
        
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/header/div/div[1]/div[4]/div[8]/div[2]/a/span"))).click();

        String username = "";
        String password = "";

        // Locates the user id field
        driver.findElement(By.id("ap_email")).sendKeys(username);
        // Locates the password field
        driver.findElement(By.id("ap_password")).sendKeys(password);
        // Clicks the login button
        driver.findElement(By.id("signInSubmit")).click();
    }

    @After
    public void tearDown() {
        LOG.info("Quiting the driver");
        driver.quit();
    }
}

