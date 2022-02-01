package com.epam.introduction.sorting.task_8;

public class Fraction {
    private int numerator;
    private int denominator;
    private final double value;

    public Fraction(int numerator, int denominator) {
        this.numerator = denominator < 0 ? -1 * numerator : numerator;
        this.denominator = denominator < 0 ? -1 * denominator : denominator;
        this.value = (double) numerator / (double) denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
