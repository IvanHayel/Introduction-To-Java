package com.epam.introduction.one_dimensional_arrays.task_2.model.real_numbers;

import java.util.Arrays;

public class RealNumbers {
    private double[] numbers;
    private int replacementQuantity;

    public RealNumbers(double[] numbers) {
        this.numbers = numbers;
        replacementQuantity = 0;
    }

    public void showReplacementQuantity() {
        System.out.println("Replacement quantity: " + replacementQuantity);
    }

    public void replaceLargerThan(double z) {
        for (int counter = 0; counter < numbers.length; counter++) {
            if (numbers[counter] > z) {
                numbers[counter] = z;
                replacementQuantity++;
            }
        }
    }

    @Override
    public String toString() {
        return "RealNumbers{" +
                "numbers=" + Arrays.toString(numbers) +
                ", replacement quantity=" + replacementQuantity +
                '}';
    }
}
