package one_dimensional_arrays.task_2;

/*
 * Дана последовательность действительных чисел a_1, a_2, ..., a_n/
 * Заменить все её члены, большие данного Z, этим числом.
 * Подсчитать количество замен.
 */

import java.util.Arrays;

public class Task_2 {
    public static void main(String[] args) {
        double[] numbers = {3.14, 1.59, 2.65, 3.58, 9.79, 3.23};
        RealNumbers realNumbers = new RealNumbers(numbers);
        System.out.println(realNumbers);
        realNumbers.replaceLargerThan(3.14);
        System.out.println(realNumbers);
        realNumbers.showReplacementQuantity();
    }
}

final class RealNumbers {
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
