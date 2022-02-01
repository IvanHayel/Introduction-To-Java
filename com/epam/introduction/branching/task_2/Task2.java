package com.epam.introduction.branching.task_2;

import static java.lang.Math.max;
import static java.lang.Math.min;

/*
 * Find max {min (a, b), min (c, d)}.
 */

public class Task2 {
    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        int c = 4;
        int d = 1;

        int result = max(min(a, b), min(c, d));
        System.out.println("Result value: " + result);
    }
}