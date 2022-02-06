package com.epam.introduction.sorting.task_2;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.concat;

/**
 * Two sequences are given a_1 <= a_2 <= ... <= a_n and b_1 <= b_2 <= ... <= b_n.
 * Form a new sequence of numbers from them so that it is also ascending.
 * Note: Do not use the additional array.
 */

public class Runner {
    public static void main(String[] args) {
        int[] firstSequence = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] secondSequence = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        IntStream firstPart = IntStream.of(firstSequence);
        IntStream secondPart = IntStream.of(secondSequence);
        firstSequence = concat(firstPart, secondPart).sorted().toArray();
        showSequence(firstSequence);
    }

    public static void showSequence(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
