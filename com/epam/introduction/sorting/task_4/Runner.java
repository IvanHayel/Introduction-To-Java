package com.epam.introduction.sorting.task_4;

import java.util.Arrays;

/**
 * Sort by exchanges.
 * Given a sequence of numbers a_1, a_2, ..., a_n.
 * It is required to rearrange the numbers in ascending order.
 */

public class Runner {
    private static int swapCounter;

    public static void main(String[] args) {
        double[] sequence = {-3.14, 1.59, 2.65, 3.58, -9.79, 3.23};
        System.out.println("Sequence before sorting: ");
        show(sequence);
        bubbleSort(sequence);
        System.out.println("Sequence after sorting with " + swapCounter + " swaps: ");
        show(sequence);

    }

    private static void show(double[] array) {
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(double[] array) {
        swapCounter = 0;
        boolean alreadySorted;
        for (int pass = 1; pass < array.length - 1; pass++) {
            alreadySorted = true;
            for (int counter = 0; counter < array.length - pass; counter++) {
                if (array[counter] > array[counter + 1]) {
                    alreadySorted = false;
                    swap(array, counter, counter + 1);
                }
            }
            if (alreadySorted) {
                break;
            }
        }
    }

    private static void swap(double[] array, int firstIndex, int secondIndex) {
        double tempValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempValue;
        swapCounter++;
    }
}
