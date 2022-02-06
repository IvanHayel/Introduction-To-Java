package com.epam.introduction.one_dimensional_arrays.task_8;

import java.util.ArrayList;

/**
 * You are given a sequence of integers a_1, a_2, ..., a_n.
 * Form a new sequence, discarding from the original those terms that are equal
 * to min (a_1, a_2, ..., a_n).
 */

public class Runner {
    public static void main(String[] args) {
        int[] sequence = {1, 1, 3, 4, 11, 23, 43, 1, 1, 55, 1, 23, 1, 1, 1};
        ArrayList<Integer> numbers = getArrayListFilledWith(sequence);
        removeMinNumbers(numbers);
        System.out.println(numbers);
    }

    public static void removeMinNumbers(ArrayList<Integer> numbers) {
        if (numbers.isEmpty()) return;
        Integer minValue = getMinValue(numbers);
        while (numbers.contains(minValue)) {
            numbers.remove(minValue);
        }
    }

    public static Integer getMinValue(ArrayList<Integer> numbers) {
        Integer min = numbers.get(0);
        for (Integer number : numbers) {
            if (min > number) {
                min = number;
            }
        }
        return min;
    }

    public static ArrayList<Integer> getArrayListFilledWith(int[] sequence) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int number : sequence) {
            numbers.add(number);
        }
        return numbers;
    }
}
