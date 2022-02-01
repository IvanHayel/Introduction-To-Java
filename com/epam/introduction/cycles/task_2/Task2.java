package com.epam.introduction.cycles.task_2;

/*
 * Calculate the values of the function on the segment [a, b] with step h y(x)
 * = x, x > 2
 * = -x, x <= 2
 */

public class Task2 {
    public static void main(String[] args) {
        Function y = new Function(1, 3, 0.15f);
        System.out.println(y);
    }
}