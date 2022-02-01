package com.epam.introduction.branching.task_1;

/*
 * The two angles of the triangle are given (in degrees).
 * Determine if such a triangle exists, and if so, whether it will be rectangular.
 */

public class Task1 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(90, 10);
        System.out.println(triangle);
    }
}