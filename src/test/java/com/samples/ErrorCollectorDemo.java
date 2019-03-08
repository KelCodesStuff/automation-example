package com.samples;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorCollectorDemo {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void test1() {
        collector.addError(new Throwable("There is an error in test 1"));
    }

    @Test
    public void test2() {

        try {
            assertSame("A", "A");
        } catch (Throwable t) {
            collector.addError(t);
        }
    }

    @Test
    public void test3() {

        try {
            assertTrue('a' < 'b');
        } catch (Throwable t) {
            collector.addError(t);
        }
    }

    @Test
    public void test4() {

        try {
            assertEquals(8, 18);
        } catch (Throwable t) {
            collector.addError(t);
        }
    }

    @Test
    public void test5() {

        try {
            assertEquals(25, 25);
        } catch (Throwable t) {
            collector.addError(t);
        }
    }
}
