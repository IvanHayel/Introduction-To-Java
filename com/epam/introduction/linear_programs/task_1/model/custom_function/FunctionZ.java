package com.epam.introduction.linear_programs.task_1.model.custom_function;

public class FunctionZ {
    private double a;
    private double b;
    private double c;

    public FunctionZ(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void showFunctionValue() {
        System.out.println("z = " + getFunctionValue());
    }

    @Override
    public String toString() {
        return "((" + a + " - 3) * " +
                b + " / 2) + " + c +
                " = " + getFunctionValue();
    }

    public double getFunctionValue() {
        return ((a - 3) * b / 2) + c;
    }
}
