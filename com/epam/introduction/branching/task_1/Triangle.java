package com.epam.introduction.branching.task_1;

public class Triangle {
    private double[] anglesInDegrees;
    private double anglesSum;

    private final double SUM_OF_ANGELS_MAX_VALUE = 180.0;

    public Triangle(double firstAngelInDegrees, double secondAngelInDegrees) {
        anglesInDegrees = new double[2];
        anglesInDegrees[0] = firstAngelInDegrees;
        anglesInDegrees[1] = secondAngelInDegrees;

        for (double angle : anglesInDegrees) {
            anglesSum += angle;
        }
    }

    @Override
    public String toString() {
        if (!isExist()) {
            return "The triangle doesn't exist.";
        } else if (!isRight()) {
            return "The triangle exists.";
        } else {
            return "The right triangle exists.";
        }
    }

    public boolean isRight() {
        if (!isExist()) {
            return false;
        }
        if (anglesInDegrees[0] == 90 || anglesInDegrees[1] == 90) {
            return true;
        }
        return anglesSum == 90;
    }

    public boolean isExist() {
        return anglesSum < SUM_OF_ANGELS_MAX_VALUE;
    }
}