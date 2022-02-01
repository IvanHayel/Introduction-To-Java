package com.epam.introduction.methods.task_6;

/*
 * Write a method(s) that checks if the given 3 numbers are coprime.
 */

public class Task6 {
    public static void main(String[] args) {
        int firstNumber = 6;
        int secondNumber = 8;
        int thirdNumber = 9;
        if (isCoprime(firstNumber, secondNumber, thirdNumber))
            System.out.println("These are coprime numbers.");
        else
            System.out.println("These are not coprime numbers.");
    }

    public static boolean isCoprime(int... numbers) {
        return getGreatestCommonDivisor(numbers) == 1;
    }

    public static int getGreatestCommonDivisor(int... numbers) {
        int greatestCommonDivisor = numbers[0];
        for (int number : numbers) {
            greatestCommonDivisor = getGreatestCommonDivisor(greatestCommonDivisor, number);
        }
        return greatestCommonDivisor;
    }

    public static int getGreatestCommonDivisor(int firstValue, int secondValue) {
        while (firstValue != secondValue) {
            if (firstValue > secondValue) {
                int tempValue = firstValue;
                firstValue = secondValue;
                secondValue = tempValue;
            }
            secondValue = secondValue - firstValue;
        }
        return firstValue;
    }
}
