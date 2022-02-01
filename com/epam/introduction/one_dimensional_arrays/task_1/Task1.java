package com.epam.introduction.one_dimensional_arrays.task_1;

/*
 * The array A [N] contains natural numbers.
 * Find the sum of those elements that are multiples of a given K.
 */

public class Task1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        NaturalNumbers numbers = new NaturalNumbers(array);
        int sum = numbers.sumElementsMultipleOf(2);
        System.out.println(sum);
    }
}