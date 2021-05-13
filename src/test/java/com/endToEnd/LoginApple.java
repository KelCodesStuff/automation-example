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

    String url = "https://www.apple.com/";
    String username = "User01";
    String password = "Test1234";

    @Test
    public void login() throws InterruptedException {
        driver.navigate().to(url);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ac-gn-bag"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//*[@id=\"ac-gn-bagview-content\"]/nav/ul/li[5]/a"))).click();

        Thread.sleep(3000);
        driver.findElement(By.id("signIn.customerLogin.appleId")).sendKeys(username);
        driver.findElement(By.id("signIn.customerLogin.password")).sendKeys(password);
        driver.findElement(By.id("signin-submit-button")).click();

        String strUrl = driver.getCurrentUrl();
        System.out.println("Current Url is:"+ strUrl);

        assertNotEquals("https://www.apple.com/", strUrl);

    }
}
