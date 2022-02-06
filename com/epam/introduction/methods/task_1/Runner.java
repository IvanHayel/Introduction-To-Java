package com.epam.introduction.methods.task_1;

/**
 * Write a method for finding the GCD and LCM of two natural numbers.
 */

public class Runner {
    public static void main(String[] args) {
        int firstNumber = 126;
        int secondNumber = 70;
        int numbersGSD = getGreatestCommonDivisor(firstNumber, secondNumber);
        int numbersLCM = getLeastCommonMultiple(firstNumber, secondNumber);
        System.out.println("GSD(" + firstNumber + "," + secondNumber + ") = " + numbersGSD);
        System.out.println("LCM(" + firstNumber + "," + secondNumber + ") = " + numbersLCM);
    }

    public static int getLeastCommonMultiple(int firstValue, int secondValue) {
        int leastCommonMultiple = firstValue * secondValue;
        int greatestCommonDivisor = getGreatestCommonDivisor(firstValue, secondValue);
        return leastCommonMultiple / greatestCommonDivisor;
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
