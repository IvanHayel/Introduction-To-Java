package com.epam.introduction.methods.task_17;

/**
 * The sum of its digits was subtracted from the given number.
 * The sum of its digits was again subtracted from the result, etc.
 * How many such actions must be performed to get zero?
 * To solve the problem, use decomposition.
 */

public class Runner {
    public static void main(String[] args) {
        int number = 12;
        int actionsQuantity = getActionsQuantity(number);
        System.out.println("Given number: " + number);
        System.out.println("Actions quantity to reach zero: " + actionsQuantity);
    }

    private static int getActionsQuantity(int number) {
        int actionsQuantity = 0;
        int sumOfDigits;
        while (number > 0) {
            sumOfDigits = getSumOfDigits(number);
            number -= sumOfDigits;
            actionsQuantity++;
        }
        return actionsQuantity;
    }

    private static int getSumOfDigits(int number) {
        int sumOfDigits = 0;
        while (number != 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }
        return sumOfDigits;
    }
}