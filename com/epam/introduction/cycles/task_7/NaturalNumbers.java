package com.epam.introduction.cycles.task_7;

import java.util.ArrayList;
import java.util.Scanner;

public class NaturalNumbers {
    private int m;
    private int n;
    ArrayList<Integer> numbers;

    public NaturalNumbers() {
        enterRangeOfNaturalNumbers();
        fillNumbers();
    }

    private void enterRangeOfNaturalNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter range of natural numbers");
        System.out.print("from: ");
        m = scanner.nextInt();
        System.out.print("to: ");
        n = scanner.nextInt();
    }

    private void fillNumbers() {
        numbers = new ArrayList<>();
        for (int number = m; number <= n; number++) {
            numbers.add(number);
        }
    }

    public void showDivisors() {
        for (Integer number : numbers) {
            System.out.print("Divisors for " + number + ": ");
            for (int divisor = 2; divisor < number; divisor++) {
                if (number % divisor == 0) {
                    System.out.print(divisor + " ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "NaturalNumbers{" +
                "m=" + m +
                ", n=" + n +
                ", numbers=" + numbers +
                '}';
    }
}