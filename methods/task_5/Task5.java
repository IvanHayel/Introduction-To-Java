package methods.task_5;

import java.util.*;

/*
 * Write a program that finds the second-largest number in the array A [N].
 */

public class Task5 {
    public static void main(String[] args) {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3};
        show(array);
        showSecondLargestNumber(array);
    }

    private static void show(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private static void showSecondLargestNumber(int[] array) {
        if (array.length >= 2) {
            Comparator<Integer> comparator = Integer::compare;
            Optional<Integer> secondLargestNumber = Arrays.stream(array)
                    .distinct()
                    .boxed()
                    .sorted(comparator.reversed())
                    .skip(1)
                    .max(comparator);
            secondLargestNumber.ifPresent(number -> System.out.println("Second largest number is " + number));
        }
    }
}