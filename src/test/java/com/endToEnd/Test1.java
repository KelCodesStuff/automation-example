package com.endToEnd;

import com.framework.BaseFramework;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test1 extends BaseFramework {
    Main method = new Main();

    @Test
    public void testA() throws InterruptedException {

        method.login();
        System.out.println(Main.username);
        System.out.println(Main.password);

    }

    @Test
    public void testB() throws InterruptedException {
        method.login();

    }

    @Test
    public void testC() throws InterruptedException {
        method.login();

    }

}
