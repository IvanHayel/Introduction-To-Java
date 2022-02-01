package com.epam.introduction.sorting.task_1;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * Two one-dimensional arrays with different number of elements and a natural number k are given.
 * Combine them into one array, including the second array between the k-th and (k + 1)-th elements
 * of the first, without using an additional array.
 */

public class Task1 {
    public static void main(String[] args) {
        int[] firstArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] secondArray = {22, 22, 22, 22, 22};
        int naturalNumber = 7;
        IntStream firstPart = IntStream.of(firstArray).limit(naturalNumber);
        IntStream secondPart = IntStream.of(secondArray);
        IntStream thirdPart = IntStream.of(firstArray).skip(naturalNumber);
        firstArray = concat(firstPart, secondPart, thirdPart).toArray();
        showArray(firstArray);
    }

    public static void showArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static IntStream concat(IntStream first, IntStream second, IntStream third) {
        return IntStream.concat(IntStream.concat(first, second), third);
    }
}