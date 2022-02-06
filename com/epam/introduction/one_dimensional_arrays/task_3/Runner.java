package com.epam.introduction.one_dimensional_arrays.task_3;

import com.epam.introduction.one_dimensional_arrays.task_3.model.real_numbers.RealNumbers;

/**
 * An array of real numbers is given, the dimension of which is N.
 * Calculate how many negative, positive and zero elements there are.
 */

public class Runner {
    public static void main(String[] args) {
        double[] numbers = {-3.14, 0, -1.59, 0, 2.65, -3.58, 9.79, -3.23};
        RealNumbers realNumbers = new RealNumbers(numbers);
        System.out.println(realNumbers);
        realNumbers.showQuantityOfPositive();
        realNumbers.showQuantityOfNegative();
        realNumbers.showQuantityOfNulls();
    }
}