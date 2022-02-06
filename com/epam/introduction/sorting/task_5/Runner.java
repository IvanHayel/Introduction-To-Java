package com.epam.introduction.sorting.task_5;

import java.util.Arrays;

/**
 * Sort by inserts.
 * Given a sequence of numbers a_1, a_2, ..., a_n.
 * It is required to rearrange the numbers in ascending order.
 * Note: Place the next element in the sorted part using a binary search.
 * Binary search should be presented as a separate function.
 */

public class Runner {
    public static void main(String[] args) {
        int[] sequence = {
                3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5,
                8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2,
                6, 4, 3, 3, 8, 3, 2, 7, 9, 5, 0,
                2, 8, 8, 4, 1, 9, 7, 1, 6, 9, 3,
                9, 9, 3, 7, 5, 1, 0, 5, 8, 2, 0
        };
        System.out.println("Sequence before sorting: ");
        show(sequence);
        insertionSort(sequence);
        System.out.println("Sequence after sorting: ");
        show(sequence);
    }

    private static void show(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {
        for (int delimiter = 1; delimiter < array.length; delimiter++) {
            int saveValue = array[delimiter];
            int indexToInsert = binarySearchToInsert(array, 0, delimiter - 1, saveValue);
            if (delimiter - indexToInsert >= 0) {
                System.arraycopy(array, indexToInsert, array, indexToInsert + 1,
                        delimiter - indexToInsert);
            }
            array[indexToInsert] = saveValue;
        }
    }

    private static int binarySearchToInsert(int[] array, int fromIndex, int toIndex, int valueToPlace) {
        int lowIndex = fromIndex;
        int highIndex = toIndex;
        while (lowIndex <= highIndex) {
            int middleIndex = (lowIndex + highIndex) >> 1;
            int middleValue = array[middleIndex];
            if (middleValue < valueToPlace) {
                lowIndex = middleIndex + 1;
            } else if (middleValue > valueToPlace) {
                highIndex = middleIndex - 1;
            } else {
                return binarySearchToInsert(array, lowIndex + 1, highIndex, valueToPlace);
            }
        }
        return lowIndex;
    }
}