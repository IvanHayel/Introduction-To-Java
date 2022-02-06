package com.epam.introduction.cycles.task_7;

import com.epam.introduction.cycles.task_7.model.natural_numbers.NaturalNumbers;

/**
 * For each natural number in the range from m to n, output all the divisors,
 * except for 1 and the number itself. m and n are entered from the keyboard.
 */


public class Runner {
    public static void main(String[] args) {
        NaturalNumbers numbers = new NaturalNumbers();
        System.out.println(numbers);
        numbers.showDivisors();
    }
}