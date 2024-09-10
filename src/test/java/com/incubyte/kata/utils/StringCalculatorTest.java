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
        assertEquals(3, StringCalculator.add("1,2")); // Passing
    }

    @Test
    public void testAddMultipleNumbers() {
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }

    @Test
    public void testAddWithMultipleNumbersWithSpaces() {
        assertEquals(6, StringCalculator.add("1, 2, 3"));
    }

    @Test
    public void testAddWithNewLines() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testAddWithNewLinesAndCommasAndSpaces() {
        assertEquals(10, StringCalculator.add("1 \n2, 3 ,4"));
    }

    @Test
    public void testAddWithNewLinesAndCommasAndSpacesWithEmptyString() {
        assertEquals(10, StringCalculator.add("1 \n2,  , 3 ,4"));
    }

}