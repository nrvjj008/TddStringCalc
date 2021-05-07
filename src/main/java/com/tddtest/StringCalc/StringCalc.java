package com.tddtest.StringCalc;

public class StringCalc {
    int add(String numbers){
        String[] numberArray = numbers.split(",");
        if (numbers.length() == 0) {
            return 0;
        }

        if (numberArray.length > 1) {
            return Integer.parseInt(numberArray[0]) + Integer.parseInt(numberArray[1]);
        }
        return Integer.parseInt(numberArray[0]);

    }
}
