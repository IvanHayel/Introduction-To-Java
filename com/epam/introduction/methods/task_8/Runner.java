package com.epam.introduction.methods.task_8;

import java.util.Arrays;

/**
 * Array D is given. Determine the following sums:
 * D [1] + D [2] + D [3]; D [4] + D [5] + D [6]; D [7] + D [8] + D [9],
 * Explanation. Create a method (s) for calculating the sum of three
 * consecutive array elements with numbers from k to m.
 */

public class Runner {
    public static void main(String[] args) {
        int[] array = {
                9, 7, 11, 5,
                9, 7, 11, 0,
                9, 7, 11, 2,
                9, 7, 11, 5,
                9, 7, 11, 4
        };

        System.out.println(Arrays.toString(array));
        int fromElement = 2;
        int toElement = 5;
        int sumOfThreeElements = getSumOfElements(array, fromElement, toElement);
        System.out.println("Sum of elements from "
                + (fromElement + 1) + " to " + toElement + " = " + sumOfThreeElements);
    }

    private static int getSumOfElements(int[] array, int from, int to) {
        if (isArrayIndex(array, from) || isArrayIndex(array, to)) {
            return 0;
        }
        int sumOfElements = 0;
        for (int counter = from; counter < to; counter++) {
            sumOfElements += array[counter];
        }
        return sumOfElements;
    }

    private static boolean isArrayIndex(int[] array, int index) {
        return index < 0 || index >= array.length;
    }
}