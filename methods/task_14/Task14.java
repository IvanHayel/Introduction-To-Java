package methods.task_14;

/*
 * Натуральное число, в записи которого n цифр, называется числом Армстронга,
 * если сумма его цифр. возведённых в степень n, равна самому числу. Найти все
 * числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.
 */

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Task14 {
    public static void main(String[] args) {
        int rangeValue = 10000;
        showArmstrongNumbers(rangeValue);
    }

    private static void showArmstrongNumbers(int rangeValue) {
        List<Integer> numbers = getArmstrongNumbers(rangeValue);
        System.out.println("Armstrong numbers ranging from 1 to " + rangeValue + " :");
        System.out.println(numbers);
    }

    private static List<Integer> getArmstrongNumbers(int rangeValue) {
        List<Integer> numbers = new ArrayList<>();
        for (int counter = 1; counter <= rangeValue; counter++)
            if (isArmstrongNumber(counter))
                numbers.add(counter);
        return numbers;
    }

    private static boolean isArmstrongNumber(int number) {
        return number == getSumOfPoweredDigits(number);
    }

    private static int getSumOfPoweredDigits(int number) {
        int sumOfDigits = 0;
        int countOfDigits = getCountOfDigits(number);
        while (number != 0) {
            sumOfDigits += pow(number % 10, countOfDigits);
            number /= 10;
        }
        return sumOfDigits;
    }

    private static int getCountOfDigits(int number) {
        return number == 0 ? 1 : (int) ceil(log10(abs(number) + 0.5));
    }
}
