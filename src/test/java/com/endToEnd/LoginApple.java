package com.endToEnd;

import com.framework.BaseFramework;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class LoginApple extends BaseFramework {

    /**
     * This is a basic login file for creating tests
     */

    String username = " ";
    String password = " ";
    String url = "https://www.stockx.com/";

    @Test
    public void login() throws InterruptedException {

        driver.get(url);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ac-gn-bag"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ac-gn-bagview-content\"]/nav/ul/li[5]/a"))).click();

        Thread.sleep(3000);
        driver.findElement(By.id("recon-0-0")).sendKeys(username);
        driver.findElement(By.id("recon-0-1")).sendKeys(password);
        driver.findElement(By.id("signInButtonId")).click();

        assertEquals("https://www.apple.com/", url);

    }
}
