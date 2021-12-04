package one_dimensional_arrays.task_10;

import java.util.Arrays;

/*
 * An integer array with n elements is given.
 * Shrink the array, discarding every second element from it (fill the vacated elements with zeros).
 * Note. Do not use an additional array.
 */

public class Task10 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        System.out.println(Arrays.toString(array));
        compress(array);
        System.out.println(Arrays.toString(array));
    }

    public static void compress(int[] array) {
        int halfLength = getHalfLength(array.length);
        for (int counter = 1; counter < array.length; counter++) {
            if (counter < halfLength) {
                array[counter] = array[2 * counter];
            } else {
                array[counter] = 0;
            }
        }
    }

    public static int getHalfLength(int length) {
        if (length % 2 == 0) {
            return length >> 1;
        }
        return (length >> 1) + 1;
    }
}