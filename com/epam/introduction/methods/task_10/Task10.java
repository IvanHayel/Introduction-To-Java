package com.epam.introduction.methods.task_10;

import java.util.Arrays;

/*
 * A natural number N is given. Write a method (methods) for forming an array,
 * the elements of which are the digits of the number N.
 */

public class Task10 {
    public static void main(String[] args) {
        int naturalNumber = 10;
        int length = 5;
        int[] array = getArrayFilledWith(naturalNumber, length);
        show(array);
    }

    private static int[] getArrayFilledWith(int value, int length) {
        return Arrays.stream(new int[length])
                .map(el -> el = value)
                .toArray();
    }

    private static void show(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}