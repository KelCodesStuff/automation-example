package com.endToEnd;

import com.framework.BaseFramework;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Main extends BaseFramework {

    String url = "https://www.google.com/";
    static String username = "Kelvin Reid";
    static Integer password = 123;

    @Test
    public void login() throws InterruptedException {
        driver.navigate().to(url);

        // The HOMEPAGE is set in the automation.properties file
//        driver.get(getConfiguration("HOMEPAGE"));

    }
}
