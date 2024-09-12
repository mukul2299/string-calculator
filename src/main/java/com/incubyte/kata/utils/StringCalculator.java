package com.incubyte.kata.utils;

import com.incubyte.kata.exceptions.InvalidCharacterException;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static Integer add(String inputString) {
        inputString = inputString.trim();
        if (inputString.isEmpty()) {
            return 0;
        }
        String delimiter = "[,\\n]";
        // Check for custom delimiter
        if (inputString.startsWith("//")) {
            int delimiterEndIndex = inputString.indexOf("\n");
            delimiter = inputString.substring(2, delimiterEndIndex);
            inputString = inputString.substring(delimiterEndIndex + 1);
        }
        String[] delimiterSeperatedStrings = inputString.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String string : delimiterSeperatedStrings) {
            string = string.trim();
            if (!string.isEmpty()) {
                int number;
                try {
                    number = Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new InvalidCharacterException(e.getMessage());
                }
                if (number < 0) {
                    negatives.add(number);
                } else {
                    sum += number;
                }
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }
        return sum;
    }
}
