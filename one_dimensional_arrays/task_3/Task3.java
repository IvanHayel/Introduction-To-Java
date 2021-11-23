package one_dimensional_arrays.task_3;

/*
 * Дан массив действительных чисел, размерность которого N.
 * Подсчитать, сколько в нём отрицательных, положительных и нулевых элементов.
 */

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        double[] numbers = {-3.14, 0, -1.59, 0, 2.65, -3.58, 9.79, -3.23};
        RealNumbers realNumbers = new RealNumbers(numbers);
        System.out.println(realNumbers);
        realNumbers.showQuantityOfPositive();
        realNumbers.showQuantityOfNegative();
        realNumbers.showQuantityOfNulls();
    }
}

final class RealNumbers {
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
            if (number == 0)
                null_quantity++;
            else if (number > 0)
                positive_quantity++;
            else
                negative_quantity++;
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