package com.examples;

import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemo {

    @Test
    public void standardAssertions() {
        int rate = 50;
        int hours = 10;
        int days = 5;
        assertEquals(52 * (rate * hours * days), 130000);
        assertSame(25, 25, "The optional assertion message is now the last parameter.");
        assertTrue(50 == 50, () -> "Assertion messages can be lazily evaluated to avoid constructing complex messages unnecessarily.");
    }

    @Test
    public void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and any
        // failures will be reported together.
        assertAll(
                () -> assertSame(12, 12),
                () -> assertSame("Code", "Code"),
                () -> assertNotSame(12, 123),
                () -> assertNotSame("A", "Aa"),

                () -> assertEquals(18,18),
                () -> assertEquals("This is a test","This is a test"),
                () -> assertNotEquals(35,25),
                () -> assertNotEquals("Automation is cool","Automation cool")
        );
    }

    @Test
    public void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }

    @Test
    public void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
            Thread.sleep(60000);
        });
    }

    @Test
    public void timeoutNotExceededWithResult() {
        // The following assertion succeeds, and returns the supplied object.
        String actualResult = assertTimeout(ofMinutes(2), () -> {
            String name = "Kelvin Reid";

            return name;
        });
        assertEquals("Kelvin Reid", actualResult);
    }

    @Test
    public void timeoutNotExceededWithMethod() {
        // The following assertion invokes a method reference and returns an object.
        String actualGreeting = assertTimeout(ofMinutes(2), AssertionsDemo::greeting);
        assertEquals("Hello, World!", actualGreeting);
    }

    private static String greeting() {
        return "Hello, World!";
    }

}
