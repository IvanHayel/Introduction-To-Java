package com.epam.introduction.one_dimensional_arrays.task_3.model.real_numbers;

import java.util.Arrays;

public class RealNumbers {
    private double[] numbers;
    private int positive_quantity = 0;
    private int negative_quantity = 0;
    private int null_quantity = 0;

    public RealNumbers(double[] numbers) {
        this.numbers = numbers;
        identifySignsOfNumbers();
    }

    private void identifySignsOfNumbers() {
        for (double number : numbers) {
            if (number == 0) {
                null_quantity++;
            } else if (number > 0) {
                positive_quantity++;
            } else {
                negative_quantity++;
            }
        }
    }

    public void showQuantityOfPositive() {
        System.out.println("Quantity of positive numbers: " + positive_quantity);
    }

    public void showQuantityOfNegative() {
        System.out.println("Quantity of negative numbers: " + negative_quantity);
    }

    public void showQuantityOfNulls() {
        System.out.println("Quantity of nulls: " + null_quantity);
    }

    @Override
    public String toString() {
        return "RealNumbers{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}