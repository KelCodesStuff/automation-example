package com.endToEnd;

import com.framework.BaseFramework;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Main extends BaseFramework {

    static String username = " ";
    static Integer password = 123;

    @Test
    public void login() throws InterruptedException {

        // The HOMEPAGE is set in the automation.properties file
        driver.get(getConfiguration("HOMEPAGE"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ac-gn-bag"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ac-gn-bagview-content\"]/nav/ul/li[5]/a"))).click();

        Thread.sleep(3000);
        driver.findElement(By.id("recon-0-0")).sendKeys(username);
        driver.findElement(By.id("recon-0-1")).sendKeys();
        driver.findElement(By.id("signInButtonId")).click();

    }
}
