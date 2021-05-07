package com.tddtest.StringCalc;

import java.util.ArrayList;

public class StringCalc {
    final String NEGATIVE_EXCEPTION_MESSAGE=" negatives not allowed ";

    int add(String numbers) throws NegativeException{

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
        ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();

        for (int i=0;i<numberArray.length;i++) {

            try {
                int number = Integer.parseInt(numberArray[i]);
                if (number < 0){
                    negativeNumbers.add(number);
                }
                sum += number;
            }
            catch (NumberFormatException e){
                System.out.println(NEGATIVE_EXCEPTION_MESSAGE);
            }
        }
        if(negativeNumbers.size() > 0){
            String negativeExceptionMessage = "" ;
            for (int i=0;i<negativeNumbers.size();i++){
                negativeExceptionMessage += negativeNumbers.get(i);
                negativeExceptionMessage += " ";
            }
            negativeExceptionMessage = NEGATIVE_EXCEPTION_MESSAGE + negativeExceptionMessage ;

            throw new NegativeException(negativeExceptionMessage);

        }


        return sum;

    }
}
