package com.tddtest.StringCalc;

import java.util.ArrayList;

public class StringCalc {
    final String NEGATIVE_EXCEPTION_MESSAGE = " negatives not allowed ";
    final int MAX_NUMBER = 1000;

    //Calculates the sum of numbers entered
    int add(String numbers) throws NegativeException {

        if (numbers.length() == 0) {
            return 0;
        }
        String delimiter = "\\n|,";  //Delimiters are \n and ,

        if (numbers.length() > 2 && numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {
            delimiter += "|";       //To add new Custom delimiter
            delimiter += numbers.charAt(2);
        }
        String[] numberArray = numbers.split(delimiter);
        return getSum(numberArray);

    }

    //Throws negative number exception
    void raiseNegativeException(ArrayList negativeNumbers) throws NegativeException {
        String negativeExceptionMessage = "";
        for (int i = 0; i < negativeNumbers.size(); i++) {
            negativeExceptionMessage += negativeNumbers.get(i);
            negativeExceptionMessage += " ";
        }
        negativeExceptionMessage = NEGATIVE_EXCEPTION_MESSAGE + negativeExceptionMessage;

        throw new NegativeException(negativeExceptionMessage);
    }

    //Returns the sum of elements in the numberArray
    int getSum(String[] numberArray) throws NegativeException {

        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < numberArray.length; i++) {

            try {
                    int number = Integer.parseInt(numberArray[i]);
                    if (number < 0) {
                        negativeNumbers.add(number);
                    }

                    if (number <= MAX_NUMBER) {
                        sum += number;
                    }
            }
            catch (NumberFormatException e) {
                    System.out.println("NumberFormatException occurred");
            }
        }
        if (negativeNumbers.size() > 0) {
            raiseNegativeException(negativeNumbers);
        }
        return sum;
    }

}
