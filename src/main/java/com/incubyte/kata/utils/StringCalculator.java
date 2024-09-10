package com.incubyte.kata.utils;

public class StringCalculator {
    public static Integer add(String inputString) {
        inputString=inputString.trim();
        if (inputString.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(inputString);
    }
}
