package com.khalifa.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SmpleCalculatorTest {
    @Test
    void testAdd() {
        SimpleCalculator calculator = new SimpleCalculator();
        double result = calculator.add(1, 2);
        assertEquals(3, result);
        // assert result == 3;
    }

    @Test
    void testSimpleDivide() {
        SimpleCalculator calculator = new SimpleCalculator();
        double result = calculator.divide(1, 2);
        assertEquals(0.5, result);
    }

    @Test
    void testDivideByZero() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }
}