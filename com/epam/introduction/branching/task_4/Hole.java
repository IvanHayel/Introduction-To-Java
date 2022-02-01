package com.epam.introduction.branching.task_4;

public class Hole {
    private double a;
    private double b;
    private double area;

    public Hole(double a, double b) {
        this.a = a;
        this.b = b;
        area = a * b;
    }

    public double getArea() {
        return area;
    }
}