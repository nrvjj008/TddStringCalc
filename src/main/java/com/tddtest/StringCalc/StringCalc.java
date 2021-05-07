package com.tddtest.StringCalc;

public class StringCalc {
    int add(String numbers){

        if (numbers.length() == 0) {
            return 0;
        }

        String delimiter="\\n|,";

        if (numbers.length() > 2 && numbers.charAt(0) == '/' && numbers.charAt(1) == '/' ) {
            delimiter +="|";
            delimiter +=numbers.charAt(2);
        }

        String[] numberArray = numbers.split(delimiter);
        int sum=0;

        for (int i=0;i<numberArray.length;i++) {

            try {
                sum += Integer.parseInt(numberArray[i]);
            }
            catch (NumberFormatException e){
                System.out.println("NumberFormatException occurred");
            }
        }

        return sum;

    }
}
