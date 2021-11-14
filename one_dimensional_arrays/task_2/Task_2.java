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
        RealNumbers real_numbers = new RealNumbers(numbers);
        System.out.println(real_numbers);
        real_numbers.replaceLargerThan(3.14);
        System.out.println(real_numbers);
        real_numbers.showReplacementQuantity();
    }
}

final class RealNumbers {
    private double[] numbers;
    private int replacement_quantity;

    public RealNumbers(double[] numbers) {
        this.numbers = numbers;
        replacement_quantity = 0;
    }

    public void showReplacementQuantity() {
        System.out.println("Replacement quantity: " + replacement_quantity);
    }

    public void replaceLargerThan(double z) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > z) {
                numbers[i] = z;
                replacement_quantity++;
            }
        }
    }

    @Override
    public String toString() {
        return "RealNumbers{" +
                "numbers=" + Arrays.toString(numbers) +
                ", replacement quantity=" + replacement_quantity +
                '}';
    }
}
