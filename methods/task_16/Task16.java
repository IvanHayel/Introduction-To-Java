package methods.task_16;

/*
 * Написать программу, определяющую сумму n-значных чисел, содержащих только
 * нечётные цифры. Определить также, сколько чётных цифр в найденной сумме.
 * Для решения задачи использовать декомпозицию.
 */

import static java.lang.Math.pow;

public class Task16 {
    public static void main(String[] args) {
        int digitsQuantity = 5;
        int sumOfNumbersWithOddDigits = getSumOfNumbersWithOddDigits(digitsQuantity);
        System.out.println("Sum of " + digitsQuantity
                + "-digit numbers containing only odd digits is " + sumOfNumbersWithOddDigits);
        int evenDigitsQuantity = getEvenDigitsQuantity(sumOfNumbersWithOddDigits);
        System.out.println("Quantity of even digits in sum: " + evenDigitsQuantity);
    }

    private static int getSumOfNumbersWithOddDigits(int digitsQuantity) {
        int sumOfNumbers = 0;
        int fromNumber = (int) pow(10, digitsQuantity - 1);
        int toNumber = (int) pow(10, digitsQuantity);
        for (int counter = fromNumber; counter < toNumber; counter++)
            if (isDigitsOdd(counter))
                sumOfNumbers += counter;
        return sumOfNumbers;
    }

    private static boolean isDigitsOdd(int number) {
        int digit;
        while (number != 0) {
            digit = number % 10;
            if (digit % 2 == 0)
                return false;
            number /= 10;
        }
        return true;
    }

    private static int getEvenDigitsQuantity(int number) {
        int quantity = 0;
        int digit;
        while (number != 0) {
            digit = number % 10;
            if (digit % 2 == 0)
                quantity++;
            number /= 10;
        }
        return quantity;
    }
}