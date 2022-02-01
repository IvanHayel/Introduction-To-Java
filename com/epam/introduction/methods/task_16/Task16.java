package com.epam.introduction.methods.task_16;

import static java.lang.Math.pow;

/*
 * Write a program that determines the sum of n-digit numbers containing only odd digits.
 * Also determine how many even digits are in the found amount.
 * To solve the problem, use decomposition.
 */

public class Task16 {
    public static void main(String[] args) {
        int digitsQuantity = 4;
        int sumOfNumbersWithOddDigits = getSumOfNumbersWithOddDigits(digitsQuantity);
        System.out.println("Sum of " + digitsQuantity
                + "-digit numbers containing only odd digits is " + sumOfNumbersWithOddDigits);
        int evenDigitsQuantity = getEvenDigitsQuantity(sumOfNumbersWithOddDigits);
        System.out.println("Quantity of even digits in this sum: " + evenDigitsQuantity);
    }

    private static int getSumOfNumbersWithOddDigits(int digitsQuantity) {
        int sumOfNumbers = 0;
        int fromNumber = (int) pow(10, digitsQuantity - 1);
        int toNumber = (int) pow(10, digitsQuantity);
        for (int counter = fromNumber; counter < toNumber; counter++) {
            if (isDigitsOdd(counter)) {
                sumOfNumbers += counter;
            }
        }
        return sumOfNumbers;
    }

    private static boolean isDigitsOdd(int number) {
        int digit;
        while (number != 0) {
            digit = number % 10;
            if (digit % 2 == 0) {
                return false;
            }
            number /= 10;
        }
        return true;
    }

    private static int getEvenDigitsQuantity(int number) {
        int quantity = 0;
        int digit;
        while (number != 0) {
            digit = number % 10;
            if (digit % 2 == 0) {
                quantity++;
            }
            number /= 10;
        }
        return quantity;
    }
}