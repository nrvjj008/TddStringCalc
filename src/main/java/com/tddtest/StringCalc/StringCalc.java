package com.tddtest.StringCalc;

public class StringCalc {
    int add(String numbers){
        String[] numberArray = numbers.split("\\n|,");
        int sum=0;
        if (numbers.length() == 0) {
            return 0;
        }

        for (int i=0;i<numberArray.length;i++) {

            try {
                sum += Integer.parseInt(numberArray[i]);
            }
            catch (NumberFormatException e){
                System.out.println("NumberFormatException occured");
            }

        }

        return sum;

    }
}
