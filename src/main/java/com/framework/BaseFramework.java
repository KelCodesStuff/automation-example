package com.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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


    @BeforeAll
    public static void beforeClass() throws IOException {
        configuration = new Properties();
        FileInputStream input;

        LOG.info("Loading in configuration file.");
        input = new FileInputStream(new File(CONFIG_FILE));
        configuration.loadFromXML(input);
        input.close();

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUpBefore() {
        DesiredCapabilities capabilities;
        // Which driver to use?
        if (DRIVER_CHROME.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
            capabilities = DesiredCapabilities.chrome();
            driver = new ChromeDriver(capabilities);
        }
        else if (DRIVER_FIREFOX.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
            capabilities = DesiredCapabilities.firefox();
            driver = new FirefoxDriver(capabilities);
        }

        // Define fluent wait
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Quitting the driver");
//        driver.quit();
    }

    protected static String getConfiguration(String config) {
        return configuration.getProperty(config);
    }
}

