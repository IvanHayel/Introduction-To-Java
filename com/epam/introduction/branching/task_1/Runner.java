package com.epam.introduction.branching.task_1;

import com.epam.introduction.branching.task_1.model.triangle.Triangle;

/*
 * The two angles of the triangle are given (in degrees).
 * Determine if such a triangle exists, and if so, whether it will be rectangular.
 */

public class Runner {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(90, 10);
        System.out.println(triangle);
    }
}