package one_dimensional_arrays.task_4;

import java.util.Arrays;

/*
 * You are given real numbers a_1, a_2, ..., a_n.
 * Swap the largest and smallest elements.
 */

public class Task4 {
    public static void main(String[] args) {
        double[] numbers = {3.14, 1.59, 2.65, 3.58, 9.79, 3.23};
        System.out.println(Arrays.toString(numbers));
        double[] numbersAfterSwap = swapMinAndMax(numbers);
        System.out.println(Arrays.toString(numbersAfterSwap));
    }

    public static double[] swapMinAndMax(double[] numbers) {
        int indexOfMaxValue = getIndexOfMaxValue(numbers);
        int indexOfMinValue = getIndexOfMinValue(numbers);
        double tempValue = numbers[indexOfMaxValue];
        numbers[indexOfMaxValue] = numbers[indexOfMinValue];
        numbers[indexOfMinValue] = tempValue;
        return numbers;
    }

    public static int getIndexOfMaxValue(double[] numbers) {
        int indexOfMaxValue = 0;
        for (int counter = 1; counter < numbers.length; counter++) {
            if (numbers[indexOfMaxValue] < numbers[counter]) {
                indexOfMaxValue = counter;
            }
        }
        return indexOfMaxValue;
    }

    public static int getIndexOfMinValue(double[] numbers) {
        int indexOfMinValue = 0;
        for (int counter = 1; counter < numbers.length; counter++) {
            if (numbers[indexOfMinValue] > numbers[counter]) {
                indexOfMinValue = counter;
            }
        }
        return indexOfMinValue;
    }
}