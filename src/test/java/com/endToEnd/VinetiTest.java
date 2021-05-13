package com.endToEnd;

import com.framework.BaseFramework;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VinetiTest extends BaseFramework {

    /**
     * Navigate to https://www.demoblaze.com
     * Click signup and create new account
     * Login to your account
     * Add Samsung Galaxy s6 to your cart
     * Navigate to the cart and verify you have the correct type
     */

    String url = "https://www.demoblaze.com/";
    String username = "kreid0707765"; //change numbers in username
    String password = "1234!";

    @Test
    @Order(1)
    public void signup() throws InterruptedException {
        driver.get(url);

        //clicks signup button
        wait.until(ExpectedConditions.elementToBeClickable(By.id("signin2"))).click();

        //fill in modal
        Thread.sleep(3000);
        driver.findElement(By.id("sign-username")).sendKeys(username);
        driver.findElement(By.id("sign-password")).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"))).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }

    @Test
    @Order(2)
    public void login() throws InterruptedException {
        driver.get(url);

        //clicks login button
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();

        //fill in modal
        Thread.sleep(3000);
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"))).click();
    }

    @Test
    @Order(3)
    public void addToCart() throws InterruptedException {
        login();

        //select device
        Thread.sleep(3000);
        driver.findElement(By.linkText("Samsung galaxy s6")).click();

        //add to cart
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"))).click();

        //close alert
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        //navigate to cart
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();

        //verify item in cart
        String item = wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//*[@id=\"tbodyid\"]/tr/td[2]"))).getText();
        //driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")).getText();
        assertEquals("Samsung galaxy s6", item);
    }
}
