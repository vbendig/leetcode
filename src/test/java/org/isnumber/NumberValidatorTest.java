package org.isnumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberValidatorTest {
    NumberValidator numberValidator = new NumberValidator();

    String [] validNumbers = {"2", "0089", "-0.1", "+3.14", "4.", "-.9","-9.", ".3", "+123.3e-342",
            "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
    String [] invalidNumbers = {"+.E3","+.", "4e+" , "4e", ".e1","++", "..", "ee", "6--", "+e4", ".e4" , "abc", "1a",
            "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};


    @Test
    void testNumberWith1Digit() {
        assertTrue(numberValidator.isNumber("1"));
        assertTrue(numberValidator.isNumber("9"));
        assertTrue(numberValidator.isNumber("2"));
        assertTrue(numberValidator.isNumber("5"));
    }

    @Test
    void testNumberWithMultipleDigit() {
        assertTrue(numberValidator.isNumber("34321"));
        assertTrue(numberValidator.isNumber("954"));
        assertTrue(numberValidator.isNumber("2345345345"));
        assertTrue(numberValidator.isNumber("534534234234353534"));
    }


    @Test
    void testValidNumbers() {

        for (String validNumber: validNumbers) {
            boolean result = numberValidator.isNumber(validNumber);
            if (!result) System.out.println(validNumber);
            assertTrue(result);
        }

        for (String validNumber: invalidNumbers) {
            boolean result = numberValidator.isNumber(validNumber);
            if (result) System.out.println(validNumber);
            assertFalse(result);
        }
    }
}