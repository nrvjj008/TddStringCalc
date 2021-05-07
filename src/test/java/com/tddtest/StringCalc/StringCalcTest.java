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
    void emptyString(){
        assertEquals(0,calc.add(""));
    }

    @Test
    void singleString(){
        assertEquals(1,calc.add("1"));
        assertEquals(2,calc.add("2"));
        assertEquals(0,calc.add("0"));
    }

    @Test
    void twoString(){
        assertEquals(3,calc.add("1,2"));
        assertEquals(30,calc.add("10,20"));
    }

    @Test
    void moreThanTwoString(){
        assertEquals(5,calc.add("2,3,4,5,6"));
    }
}