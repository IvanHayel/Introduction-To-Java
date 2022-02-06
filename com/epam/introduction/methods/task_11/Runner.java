package com.epam.introduction.methods.task_11;

import static java.lang.Math.*;

/**
 * Write the method(s) that determines which of the given two numbers has more digits.
 */

public class Runner {
    public static void main(String[] args) {
        int firstNumber = 222;
        int secondNumber = 3333;
        showNumberWithMoreDigits(firstNumber, secondNumber);
    }

    private static void showNumberWithMoreDigits(int firstNumber, int secondNumber) {
        System.out.println("Numbers to compare: " + firstNumber + ", " + secondNumber);
        int compareValue = compareByDigits(firstNumber, secondNumber);
        if (compareValue > 0) {
            System.out.println(firstNumber + " there are more digits.");
        } else if (compareValue < 0) {
            System.out.println(secondNumber + " there are more digits.");
        } else {
            System.out.println("These numbers have the same count of digits.");
        }
    }

    private static int compareByDigits(int firstNumber, int secondNumber) {
        return getCountOfDigits(firstNumber) - getCountOfDigits(secondNumber);
    }

    private static int getCountOfDigits(int number) {
        return number == 0 ? 1 : (int) ceil(log10(abs(number) + 0.5));
    }
}