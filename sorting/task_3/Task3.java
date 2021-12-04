package sorting.task_3;

import java.util.Arrays;

/*
 * Sort by selection.
 * You are given a sequence of numbers a_1 <= a_2 <= ... <= a_n.
 * It is required to rearrange the elements so that they are in descending order.
 */

public class Task3 {
    public static void main(String[] args) {
        int[] sequence = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println("Sequence before sorting: ");
        show(sequence);
        selectionSort(sequence);
        System.out.println("Sequence after sorting: ");
        show(sequence);
    }

    private static void show(int[] array){
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        for (int maximumValue = 0; maximumValue < array.length - 1; maximumValue++) {
            for (int counter = maximumValue + 1; counter < array.length; counter++) {
                if (array[maximumValue] < array[counter]) {
                    swap(array, maximumValue, counter);
                }
            }
        }
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int tempValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempValue;
    }
}