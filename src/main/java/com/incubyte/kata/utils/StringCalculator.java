package com.incubyte.kata.utils;

public class StringCalculator {
    public static Integer add(String inputString) {
        inputString=inputString.trim();
        if (inputString.isEmpty()) {
            return 0;
        }
        String[] commaSeperatedStrings = inputString.split("[,\\n]");
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
