package com.khalifa.tdd;

public class SimpleCalculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double divide(double a, double b) {
        if(b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }
}