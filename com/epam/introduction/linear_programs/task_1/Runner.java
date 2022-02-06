package com.epam.introduction.linear_programs.task_1;

import com.epam.introduction.linear_programs.task_1.model.custom_function.FunctionZ;

/**
 * Linear programs.
 * Find the value of the function: z = ((a-3) * b / 2) + c.
 */

public class Runner {
    public static void main(String... args) {
        FunctionZ z = new FunctionZ(3.1, 4.1, 5.9);
        z.showFunctionValue();
        System.out.println(z);
    }
}