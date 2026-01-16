package org.example.Calculator;

public class Calculator {
    public Double add(double a, double b) {
        return a + b;
    }

    public Double subtract(double a, double b) {
        return a - b;
    }

    public Double multiply(double a, double b) {
        return a * b;
    }

    public Double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor can't be zero");
        }
        return a / b;
    }
}
