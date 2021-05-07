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
        assertEquals(20,calc.add("2,3,4,5,6"));
        assertEquals(10,calc.add("2,3,5"));
    }

    @Test
    void newLineCharacter(){
        assertEquals(3,calc.add("1\n2"));
        assertEquals(7,calc.add("1\n2,4"));

    }
    @Test
    void customDelimeter(){
        assertEquals(6,calc.add("//;\n1;2;3"));
        assertEquals(70,calc.add("//#\n10#20#40"));

    }
}