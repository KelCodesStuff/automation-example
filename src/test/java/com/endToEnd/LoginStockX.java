package com.endToEnd;

import com.framework.BaseFramework;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStockX extends BaseFramework {
    /**
     * * This is a basic login file for creating tests
     * */

    String url = "https://www.stockx.com/";
    String email = " ";
    String password = " ";

    @Test
    public void login() throws InterruptedException {
        driver.get(url);

        //clicks login button
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-login"))).click();

        Thread.sleep(3000);
        driver.findElement(By.id("email-login")).sendKeys(email);
        driver.findElement(By.id("password-login")).sendKeys(password);
        driver.findElement(By.id("login-button-text")).click();

        //clicks my account button
        driver.findElement(By.className("dropdown")).click();

        // verifies on account page
        assertEquals("https://stockx.com/account", url);

    }
}