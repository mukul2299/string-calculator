package com.incubyte.kata.utils;

import com.incubyte.kata.exceptions.InvalidCharacterException;
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

    @Test
    public void testAddWithCustomDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testAddWithCustomDelimiterAndSpaces() {
        assertEquals(10, StringCalculator.add("//_\n 1 _2_3_ 4 "));
    }

    @Test
    public void testAddWithNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("1,-2,3");
        });
        assertEquals("Negative numbers not allowed: [-2]", exception.getMessage());
    }

    @Test
    public void testAddWithMultipleNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("1,-2,-3");
        });
        assertEquals("Negative numbers not allowed: [-2, -3]", exception.getMessage());
    }

    @Test
    public void testAddWithInvalidCharacters() {
        Exception exception = assertThrows(InvalidCharacterException.class, () -> {
            StringCalculator.add("1,-2,-3,a , b");
        }); //Passing
    }

    @Test
    public void testAddWithInvalidCharactersAndCustomDelimiter() {
        assertThrows(InvalidCharacterException.class, () -> {
            StringCalculator.add("//_\na_1_2_3_4_b");
        }); // Passing
    }

    @Test
    public void testAddWithInvalidCharactersAndCustomDelimiterAndSpaces() {
        assertThrows(InvalidCharacterException.class, () -> {
            StringCalculator.add("//_\n a _1_ 2_3 _4_b ");
        }); // Passing
    }

}