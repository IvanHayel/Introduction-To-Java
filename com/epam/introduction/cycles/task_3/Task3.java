package com.epam.introduction.cycles.task_3;

/*
 * Find the sum of the squares of the first hundred numbers.
 */

public class Task3 {
    public static void main(String[] args) {
        int sumOfSquares = getSumOfSquaresFor(100);
        System.out.print("Sum of the squares of the first hundred numbers = ");
        System.out.println(sumOfSquares);
    }

    public static int getSumOfSquaresFor(int number) {
        int sum = 0;
        for (int counter = 1; counter <= number; counter++) {
            sum += counter * counter;
        }
        return sum;
    }
}
