package com.epam.introduction.one_dimensional_arrays.task_7;

/*
 * You are given real numbers a_1, a_2, ..., a_n.
 * Find max (a_1 + a_2n, a_2 + a_2n-1, ..., a_n + a_n + 1).
 */

public class Task7 {
    public static void main(String[] args) {
        double[] numbers = {3.14, 1.59, 2.65, 12.56, 3.58, 9.79, 3.23};
        double[] sums = getSums(numbers);
        double maxSum = getMax(sums);
        System.out.println("Maximum sum: " + maxSum);
    }

    public static double getMax(double[] values) {
        double max = values[0];
        for (double value : values) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    public static double[] getSums(double[] numbers) {
        int length = getHalfLength(numbers.length);
        double[] sums = new double[length];
        int secondTerm = numbers.length - 1;
        for (int counter = 0; counter < length; counter++, secondTerm--) {
            if (secondTerm == counter) {
                sums[counter] = numbers[counter];
            } else {
                sums[counter] = numbers[counter] + numbers[secondTerm];
            }
        }
        return sums;
    }

    public static int getHalfLength(int length) {
        if (length % 2 == 0) {
            return length / 2;
        } else {
            return length / 2 + 1;
        }
    }
}