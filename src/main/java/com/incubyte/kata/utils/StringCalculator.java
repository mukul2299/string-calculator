package com.incubyte.kata.utils;

import com.incubyte.kata.exceptions.InvalidCharacterException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = "[,\\n]";
    private static final String INVALID_CHAR_REGEX = "[^0-9%s\\s-]|-(?![0-9])";

    public static Integer add(String inputString) {
        inputString = inputString.trim();
        if (inputString.isEmpty()) {
            return 0;
        }
        String delimiter = DEFAULT_DELIMITER;
        // Check for custom delimiter
        if (inputString.startsWith("//")) {
            delimiter = extractCustomDelimiter(inputString);
            inputString = inputString.substring(inputString.indexOf("\n") + 1);
        }
        // Identifying invalid characters using regex
        validateInput(inputString, delimiter);
        return calculateSum(inputString, delimiter);
    }

    private static String extractCustomDelimiter(String inputString) {
        int delimiterEndIndex = inputString.indexOf("\n");
        String customDelimiter = inputString.substring(2, delimiterEndIndex);
        return Pattern.quote(customDelimiter);
    }

    private static void validateInput(String inputString, String delimiter) {
        String inValidCharacterRegEx = String.format(INVALID_CHAR_REGEX, delimiter);
        Pattern invalidCharacterPattern = Pattern.compile(inValidCharacterRegEx);
        Matcher invalidCharacterMatcher = invalidCharacterPattern.matcher(inputString);
        if (invalidCharacterMatcher.find()) {
            throw new InvalidCharacterException();
        }
    }

    private static int calculateSum(String inputString, String delimiter) {
        String[] delimiterSeperatedStrings = inputString.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for (String string : delimiterSeperatedStrings) {
            string = string.trim();
            if (!string.isEmpty()) {
                int number = Integer.parseInt(string);
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
