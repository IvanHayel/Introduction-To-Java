package methods.task_11;

/*
 * Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 */

import static java.lang.Math.*;

public class Task11 {
    public static void main(String[] args) {
        int firstNumber = 222;
        int secondNumber = 3333;
        showNumberWithMoreDigits(firstNumber, secondNumber);
    }

    private static void showNumberWithMoreDigits(int firstNumber, int secondNumber) {
        System.out.println("Numbers to compare: " + firstNumber + ", " + secondNumber);
        int compareValue = compareByDigits(firstNumber, secondNumber);
        if (compareValue > 0)
            System.out.println(firstNumber + " there are more digits.");
        else if (compareValue < 0)
            System.out.println(secondNumber + " there are more digits.");
        else
            System.out.println("These numbers have the same count of digits.");
    }

    private static int compareByDigits(int firstNumber, int secondNumber) {
        return getCountOfDigits(firstNumber) - getCountOfDigits(secondNumber);
    }

    private static int getCountOfDigits(int number) {
        return number == 0 ? 1 : (int) ceil(log10(abs(number) + 0.5));
    }
}