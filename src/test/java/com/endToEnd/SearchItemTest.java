package com.endToEnd;

import com.framework.BaseFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class SearchItemTest extends BaseFramework {

    /**
     * Searches for item
     */
    @Test
    public void search() {

//        driver.get(getConfiguration("HOMEPAGE"));

        driver.findElement(By.id("twotabsearchtextbox")).click();
        driver.findElement(By.id("twotabsearchtextbox")).submit();

        driver.findElement(By.className("a-size-medium a-color-base a-text-normal")).click();
    }

    @Test
    public void addToCart() {

        assertSame("Good", "Good");
    }

    @Test
    public void checkOut() {

        assertTrue(1 < 2);
    }

    @Test
    public void addToList() {

        assertEquals(8, 8);
    }

}
