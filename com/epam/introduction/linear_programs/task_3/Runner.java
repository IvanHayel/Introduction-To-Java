package com.epam.introduction.linear_programs.task_3;

import com.epam.introduction.linear_programs.task_3.model.expression.Expression;

/**
 * Linear programs.
 * Evaluate the expression using the formula (all variables are valid):
 * (sin (x) + cos (y)) / (cos (x) -sin (y)) * tg (xy)
 */

public class Runner {
    public static void main(String[] args) {
        Expression expression = new Expression(3.1, 4.1);
        expression.showValue();
        System.out.println(expression);
    }
}