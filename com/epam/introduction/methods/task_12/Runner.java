package com.epam.introduction.methods.task_12;

import java.util.Arrays;

/**
 * Given natural numbers K and N. Write a method (methods) for forming an array A,
 * whose elements are numbers, the sum of the digits of which
 * is equal to K and which are not greater than N.
 */

public class Runner {
    private static final int SUM_OF_DIGITS = 12;
    private static final int MAX_VALUE = 100;

    private static int currentValue = 0;

    public static void main(String[] args) {
        int length = 12;
        int[] array = getFilledArray(length);
        show(array);
    }

    private static int[] getFilledArray(int length) {
        int[] array = new int[length];
        for (int counter = 0; counter < length; counter++) {
            array[counter] = nextValue();
        }
        return array;
    }

    private static int nextValue() {
        for (currentValue++; currentValue < MAX_VALUE; currentValue++) {
            if (isCorrectSumOfDigits(currentValue)) {
                return currentValue;
            }
        }
        currentValue = 0;
        return nextValue();
    }

    private static boolean isCorrectSumOfDigits(int number) {
        return getSumOfDigits(number) == SUM_OF_DIGITS;
    }

    private static int getSumOfDigits(int number) {
        int sumOfDigits = 0;
        while (number != 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }
        return sumOfDigits;
    }

    private static void show(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}