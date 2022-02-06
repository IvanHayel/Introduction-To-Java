package com.epam.introduction.linear_programs.task_3.model.expression;

import static java.lang.Math.*;

public class Expression {
    private double x;
    private double y;

    public Expression(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void showValue() {
        System.out.println("Expression value is " +
                getExpressionValue());
    }

    @Override
    public String toString() {
        return Double.toString(getExpressionValue());
    }

    public double getExpressionValue() {
        return (sin(x) + cos(y)) / (cos(x) - sin(y)) *
                tan(x * y);
    }
}