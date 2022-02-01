package com.epam.introduction.one_dimensional_arrays.task_2;

/*
 * You are given a sequence of real numbers a_1, a_2, ..., a_n
 * Replace all its members larger than the given Z with this number.
 * Count the number of replacements.
 */

public class Task2 {
    public static void main(String[] args) {
        double[] numbers = {3.14, 1.59, 2.65, 3.58, 9.79, 3.23};
        RealNumbers realNumbers = new RealNumbers(numbers);
        System.out.println(realNumbers);
        realNumbers.replaceLargerThan(3.14);
        System.out.println(realNumbers);
        realNumbers.showReplacementQuantity();
    }
}