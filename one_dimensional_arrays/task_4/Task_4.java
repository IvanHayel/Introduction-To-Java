package one_dimensional_arrays.task_4;

/*
 * Даны действительные числа a_1, a_2, ..., a_n.
 * Поменять местами наибольший и наименьший элементы.
 */

import java.util.Arrays;

public class Task_4 {
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
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[indexOfMaxValue] < numbers[i])
                indexOfMaxValue = i;
        }
        return indexOfMaxValue;
    }

    public static int getIndexOfMinValue(double[] numbers) {
        int indexOfMinValue = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[indexOfMinValue] > numbers[i])
                indexOfMinValue = i;
        }
        return indexOfMinValue;
    }
}