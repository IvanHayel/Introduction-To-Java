package sorting.task_6;

/*
 * Сортировка Шелла.
 * Дан массив n действительных чисел.
 * Требуется упорядочить его по возрастанию.
 */

import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
        double[] array = {
                3.1, 4.1, 5.9, 2.6, 5.3,
                8.9, 7.9, 3.2, 3.8, 4.6,
                6.4, 3.3, 8.3, 2.7, 9.5,
                2.8, 8.4, 1.9, 7.1, 6.9,
                9.9, 3.7, 5.1, 0.5, 8.2
        };

        show(array);
        shellSort(array);
        show(array);
    }

    private static void show(double[] array) {
        System.out.println(Arrays.toString(array));
    }

    private static void shellSort(double[] array) {
        for (int pointer = 1; pointer < array.length; pointer++)
            for (int offset = pointer - 1; offset >= 0; offset--)
                if (array[offset] > array[offset + 1])
                    swap(array, offset, offset + 1);
    }

    private static void swap(double[] array, int firstIndex, int secondIndex) {
        double tempValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempValue;
    }
}