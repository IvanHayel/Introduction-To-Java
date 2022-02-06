package com.epam.introduction.methods.task_2;

import java.util.Arrays;

/**
 * Write a method (methods) for finding the GCD of four natural numbers.
 */

public class Runner {
    public static void main(String[] args) {
        int[] naturalNumbers = {753, 252, 207, 1953, 51, 261};
        int numbersGCD = getGreatestCommonDivisor(naturalNumbers);
        System.out.println("Natural numbers: " + Arrays.toString(naturalNumbers));
        System.out.println("Greatest common divisor for natural numbers = " + numbersGCD);
    }

    public static int getGreatestCommonDivisor(int... numbers) {
        int greatestCommonDivisor = numbers[0];
        for (int number : numbers) {
            greatestCommonDivisor = getGreatestCommonDivisor(greatestCommonDivisor, number);
        }
        return greatestCommonDivisor;
    }

    public static int getGreatestCommonDivisor(int firstValue, int secondValue) {
        while (firstValue != secondValue) {
            if (firstValue > secondValue) {
                int tempValue = firstValue;
                firstValue = secondValue;
                secondValue = tempValue;
            }
            secondValue = secondValue - firstValue;
        }
        return firstValue;
    }
}