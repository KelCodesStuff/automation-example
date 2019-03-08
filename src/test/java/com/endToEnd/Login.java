package com.endToEnd;

import com.framework.BaseFramework;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class Login extends BaseFramework {

    @Test
    public void navigateToHomepage() {

        driver.get(getConfiguration("Homepage"));

        driver.findElement(By.xpath(" ")).sendKeys("Email");

        driver.findElement(By.xpath(" ")).sendKeys("Password");

        driver.findElement(By.xpath(" ")).click();

    }

    @Test
    public void test1() {

        driver.get(getConfiguration("Homepage"));

        assertSame("Abc", "Abc");

    }

    @Test
    public void test2() {

        driver.get(getConfiguration("Homepage"));

        assertTrue(8 < 18);

    }

    @Test
    public void test3() {

        driver.get(getConfiguration("Homepage"));

        assertEquals(80, 80);

    }

}
