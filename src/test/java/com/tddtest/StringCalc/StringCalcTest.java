package com.tddtest.StringCalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalcTest {
    StringCalc calc;
    @BeforeEach
    void setUp() {
        calc = new StringCalc();
    }

    @Test
    void emptyString() throws NegativeException {
        assertEquals(0,calc.add(""));
    }

    @Test
    void singleString() throws NegativeException {
        assertEquals(1,calc.add("1"));
        assertEquals(2,calc.add("2"));
        assertEquals(0,calc.add("0"));
    }

    @Test
    void twoString() throws NegativeException {
        assertEquals(3,calc.add("1,2"));
        assertEquals(30,calc.add("10,20"));
    }

    @Test
    void moreThanTwoString() throws NegativeException{
        assertEquals(20,calc.add("2,3,4,5,6"));
        assertEquals(10,calc.add("2,3,5"));
    }

    @Test
    void newLineCharacter() throws NegativeException{
        assertEquals(3,calc.add("1\n2"));
        assertEquals(7,calc.add("1\n2,4"));

    }

    @Test
    void customDelimeter() throws NegativeException{
        assertEquals(6,calc.add("//;\n1;2;3"));
        assertEquals(70,calc.add("//#\n10#20#40"));

    }

    @Test
    void negativeException(){
        NegativeException negativeException = assertThrows(NegativeException.class, ()->calc.add("-1,-2,3"));
        assertTrue(negativeException.getMessage().contains("negatives not allowed"));
    }

    @Test
    void greaterThanThousand() throws NegativeException{
        assertEquals(1,calc.add("1,10001"));
        assertEquals(1,calc.add("1,10001,200000,300000"));
    }




}