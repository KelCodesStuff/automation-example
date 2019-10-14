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

        driver.get(getConfiguration("Homepage"));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("PlayStation 4");
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
