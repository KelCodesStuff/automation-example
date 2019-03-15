package com.samples;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;

public class AssertionsDemo {

    @Test
    public void standardAssertions() {
        Integer rate = 50;
        assertEquals(52 * (rate * 8 * 5), 104000);
        assertSame(25, 25, "The optional assertion message is now the last parameter.");
        assertTrue(50 < 100, () -> "Assertion messages can be lazily evaluated to avoid constructing complex messages unnecessarily.");
    }

    @Test
    public void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and any
        // failures will be reported together.
        assertAll(
                () -> assertSame(12, 12),
                () -> assertSame(100, 100),
                () -> assertEquals("A","A"),
                () -> assertEquals("Yes","No")
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

    @Test
    public void timeoutExceeded() {
        // The following assertion fails with an error message similar to: execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(9);
        });
    }

    @Test
    public void timeoutExceededWithPreemptiveTermination() {
        // The following assertion fails with an error message similar to: execution timed out after 10 ms
        assertTimeoutPreemptively(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(9);
        });
    }

    private static String greeting() {
        return "Hello, World!";
    }

}
