package com.endToEnd;

import com.framework.BaseFramework;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import static org.junit.jupiter.api.Assertions.*;

public class Login extends BaseFramework {

    /**
     * This is a basic login file for creating tests
     */

    static String username = "";
    static String password = "";
    String url = "https://www.amazon.com/";

    @Test
    public void login() throws InterruptedException {

        driver.get(url);

        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.className("nav-action-inner")).click();

        driver.findElement(By.id("identifierId")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();

        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();

        assertEquals("https://www.amazon.com/", url);

    }
}
