package com.endToEnd;

import com.framework.BaseFramework;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Example extends BaseFramework {
    Login method = new Login();

    @Test
    public void test1() throws InterruptedException {

        method.login();
        System.out.println(Login.username);
        System.out.println(Login.password);

    }

    @Test
    public void test2() throws InterruptedException {
        method.login();

    }

    @Test
    public void test3() throws InterruptedException {
        method.login();

    }

}
