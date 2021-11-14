package one_dimensional_arrays.task_1;

import java.util.Arrays;

public class Task_1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        NaturalNumbers numbers = new NaturalNumbers(array);
        int sum = numbers.sumElementsMultipleOf(2);
        System.out.println(sum);
    }
}

final class NaturalNumbers {
    private int[] numbers;

    public NaturalNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int sumElementsMultipleOf(int k) {
        int sum = 0;
        for (int element : numbers) {
            if (element % k == 0)
                sum += element;
        }
        return sum;
    }

    @Override
    public String toString() {
        return "NaturalNumber{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}