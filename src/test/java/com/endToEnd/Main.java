package com.endToEnd;

import com.framework.BaseFramework;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Main extends BaseFramework {

    static String username = "username";
    static String password = "password";

    @Test
    public void login() throws InterruptedException {

        // The HOMEPAGE is set in the automation.properties file
        driver.get(getConfiguration("HOMEPAGE"));

        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.className("nav-action-inner")).click();

        driver.findElement(By.id("identifierId")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();

        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();

    }
}
