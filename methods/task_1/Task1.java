package methods.task_1;

/*
 * Написать метод для нахождения НОД и НОК двух натуральных чисел.
 */

public class Task1 {
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
