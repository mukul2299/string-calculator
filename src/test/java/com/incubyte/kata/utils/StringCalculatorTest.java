package com.incubyte.kata.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    public void testAddEmptyString() {
        assertEquals(0, StringCalculator.add("")); // Passing
    }

    @Test
    public void testAddEmptySpacesString() {
        assertEquals(0, StringCalculator.add("  ")); // Passing
    }

    @Test
    public void testAddSingleNumber() {
        assertEquals(1, StringCalculator.add("1")); // Passing
    }

    @Test
    public void testAddTwoNumbers() {
        assertEquals(3, StringCalculator.add("1,2")); // Failing-> Number Format Exception
    }
}