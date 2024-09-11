package com.incubyte.kata.utils;

public class StringCalculator {
    public static Integer add(String inputString) {
        inputString=inputString.trim();
        if (inputString.isEmpty()) {
            return 0;
        }
        String delimiter="[,\\n]";
        // Check for custom delimiter
        if (inputString.startsWith("//")) {
            int delimiterEndIndex = inputString.indexOf("\n");
            delimiter = inputString.substring(2, delimiterEndIndex);
            inputString = inputString.substring(delimiterEndIndex + 1);
        }
        String[] commaSeperatedStrings = inputString.split(delimiter);
        Integer sum = 0;
        for(String string:commaSeperatedStrings){
            string = string.trim();
            if(!string.isEmpty()){
                sum += Integer.parseInt(string);
            }
        }
        return sum;
    }
}
