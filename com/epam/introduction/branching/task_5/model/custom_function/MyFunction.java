package com.epam.introduction.branching.task_5.model.custom_function;

import static java.lang.Math.pow;

public class MyFunction {
    private double x;
    private double functionValue;

    public MyFunction(double x) {
        this.x = x;
        functionValue = calculateFunctionValue();
    }

    private double calculateFunctionValue() {
        if (x <= 3) {
            return pow(x, 2) - 3 * x + 9;
        }
        return 1 / (pow(x, 3) + 6);
    }

    @Override
    public String toString() {
        return "Function{" + "x=" + x + ", result=" + functionValue + '}';
    }
}