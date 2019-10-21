package com.endToEnd;

import com.framework.BaseFramework;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test2 extends BaseFramework {
    Login method = new Login();

    @Test
    public void verifyTabs() throws InterruptedException {
        method.login();

        System.out.println(Login.username);
        System.out.println(Login.password);

        String url1 = driver.getCurrentUrl();

        driver.findElement(By.xpath("/html/body/perfect-root/div/div/navbarwrapper/div/div/div/div/perf-navbar/header/div[2]/div/nav/ul/li[2]/a")).click();
        Thread.sleep(3000);
        String url2 = driver.getCurrentUrl();

        driver.findElement(By.xpath("/html/body/perfect-root/div/div/navbarwrapper/div/div/div/div/perf-navbar/header/div[2]/div/nav/ul/li[3]/a")).click();
        Thread.sleep(3000);
        String url3 = driver.getCurrentUrl();

        driver.findElement(By.xpath("/html/body/perfect-root/div/div/navbarwrapper/div/div/div/div/perf-navbar/header/div[2]/div/nav/ul/li[4]/a")).click();
        Thread.sleep(3000);
        String url4 = driver.getCurrentUrl();

        driver.findElement(By.xpath("/html/body/perfect-root/div/div/navbarwrapper/div/div/div/div/perf-navbar/header/div[2]/div/nav/ul/li[5]/a")).click();
        Thread.sleep(3000);
        String url5 = driver.getCurrentUrl();

        driver.findElement(By.xpath("/html/body/perfect-root/div/div/navbarwrapper/div/div/div/div/perf-navbar/header/div[2]/div/nav/ul/li[6]/a")).click();
        Thread.sleep(3000);
        String url6 = driver.getCurrentUrl();

        assertAll(
                () -> assertEquals("https://secureqc.perfect.com/members/Overview.act#/", url1),
                () -> assertEquals("https://secureqc.perfect.com/members/Overview.act#/Req", url2),
                () -> assertEquals("https://secureqc.perfect.com/members/Overview.act#/Orders", url3),
                () -> assertEquals("https://secureqc.perfect.com/members/Overview.act#/Invoices", url4),
                () -> assertEquals("https://secureqc.perfect.com/poflip/find.act?view=search", url5),
                () -> assertEquals("https://secureqc.perfect.com/webreports/login.act", url6)
        );
    }
}
