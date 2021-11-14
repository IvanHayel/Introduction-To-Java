package cycles.task_1;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        int value = enterPositiveInteger();
        int[] array = createArrayOfIntegers(value);
        int result_sum = getSumOfIntegerArrayElements(array);

        System.out.println("Result: " + result_sum);
    }

    public static int getSumOfIntegerArrayElements(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    public static int[] createArrayOfIntegers(int max_value) {
        int[] result_array = new int[max_value];
        for (int i = 0; i < max_value; i++) {
            result_array[i] = i + 1;
        }
        return result_array;
    }

    public static int enterPositiveInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a positive integer: ");
        int positive_integer = scanner.nextInt();
        if (positive_integer <= 0)
            positive_integer = enterPositiveInteger();
        scanner.close();
        return positive_integer;
    }
}
