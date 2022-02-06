package com.epam.introduction.branching.task_5;

/*
 * Calculate the values of the function F (x):
 * = x ^ 2 - 3x + 9 if x <= 3;
 * = 1 / (x ^ 3 + 6) if x > 3;
 */

import com.epam.introduction.branching.task_5.model.custom_function.MyFunction;

public class Runner {
    public static void main(String[] args) {
        MyFunction myFunction = new MyFunction(3.1415926535);
        System.out.println(myFunction);
    }
}