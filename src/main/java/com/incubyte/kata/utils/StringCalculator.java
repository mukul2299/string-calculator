package com.incubyte.kata.utils;

import com.incubyte.kata.exceptions.InvalidCharacterException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        // Identifying invalid characters using regex
        String inValidCharacterRegEx = "[^0-9"+delimiter+"\\s-]|-(?![0-9])";
        Pattern invalidCharacterPattern= Pattern.compile(inValidCharacterRegEx);
        Matcher invalidCharacterMatcher = invalidCharacterPattern.matcher(inputString);
        if(invalidCharacterMatcher.find()){
            throw new InvalidCharacterException();
        }
        String[] delimiterSeperatedStrings = inputString.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
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
