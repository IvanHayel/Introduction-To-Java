package cycles.task_1;

/*
 * Напишите программу, где пользователь вводит любое целое положительное число.
 * А программа суммирает все числа от 1 до введённого числа.
 */

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        int value = enterPositiveInteger();
        int[] array = createArrayOfIntegers(value);
        int resultSum = getSumOfIntegerArrayElements(array);

        System.out.println("Result: " + resultSum);
    }

    public static int getSumOfIntegerArrayElements(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    public static int[] createArrayOfIntegers(int maxValue) {
        int[] result_array = new int[maxValue];
        for (int counter = 0; counter < maxValue; counter++) {
            result_array[counter] = counter + 1;
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
