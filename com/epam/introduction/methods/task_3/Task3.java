package com.epam.introduction.methods.task_3;

import static java.lang.Math.*;

/*
 * Calculate the area of a regular hexagon with side a using the triangle area method.
 */

public class Task3 {
    public static void main(String[] args) {
        int regularHexagonSideValue = 3;
        double regularHexagonArea = 6 * getAreaOfEquilateralTriangle(regularHexagonSideValue);
        System.out.println("The area of a regular hexagon is equal to " + regularHexagonArea);
    }

    private static double getAreaOfEquilateralTriangle(int sideValue) {
        return sqrt(3) / 4 * pow(sideValue, 2);
    }
}