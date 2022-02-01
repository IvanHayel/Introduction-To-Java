package com.epam.introduction.linear_programs.task_4;

public class RealNumber {
    private double realNumber;

    public RealNumber(double realNumber) {
        this.realNumber = realNumber;
    }

    public void showRealNumber() {
        System.out.println(realNumber);
    }

    @Override
    public String toString() {
        return Double.toString(realNumber);
    }

    public void swapIntegerAndFractional() {
        realNumber = (realNumber * 1000) % 1000 + (int) realNumber / 1000.0;
    }
}
