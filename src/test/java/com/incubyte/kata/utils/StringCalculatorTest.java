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
        assertEquals(0, StringCalculator.add("  ")); // Failing-> Expected:0 Actual:null
    }
}