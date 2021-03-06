package com.epam.introduction.linear_programs.task_2;

/*
 * Linear programs.
 * Evaluate the expression using the formula (all variables are valid):
 * (b + sqrt (b ^ 2 + 4ac)) / 2a - a ^ 3 * c + b ^ -2
 */

import com.epam.introduction.linear_programs.task_2.model.expression.Expression;

public class Runner {
    public static void main(String[] args) {
        Expression expression = new Expression(3.14, 1.59, 2.65);
        System.out.println(expression);
    }
}