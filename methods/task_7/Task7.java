package methods.task_7;

import java.math.BigInteger;

/*
 * Write a method(s) for calculating the sum of the factorials of all odd numbers from 1 to 9.
 */

public class Task7 {
    public static void main(String[] args) {
        int fromNumber = 1;
        int toNumber = 9;
        BigInteger sumOfFactorials = getSumOfOddFactorials(fromNumber, toNumber);
        System.out.println("Sum of odd factorials from " + fromNumber
                + " to " + toNumber + ": " + sumOfFactorials);
    }

    private static BigInteger getSumOfOddFactorials(int fromNumber, int toNumber) {
        BigInteger sumOfFactorials = BigInteger.ZERO;
        BigInteger factorial;
        for (int i = fromNumber; i <= toNumber; i++) {
            if (i % 2 != 0) {
                try {
                    factorial = getFactorial(i);
                    sumOfFactorials = sumOfFactorials.add(factorial);
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }
        return sumOfFactorials;
    }

    private static BigInteger getFactorial(int value) throws Exception {
        if (value < 0) {
            throw new Exception(value + " is wrong value.");
        }
        if (value == 0) {
            return BigInteger.ONE;
        }
        BigInteger factorial = BigInteger.ONE;
        for (int counter = 1; counter <= value; counter++) {
            factorial = factorial.multiply(BigInteger.valueOf(counter));
        }
        return factorial;
    }
}
