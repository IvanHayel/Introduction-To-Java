package com.epam.introduction.cycles.task_4;

import java.math.BigInteger;

/**
 * Create a program for finding the product of the squares of the first 200 numbers.
 */

public class Runner {
    public static void main(String[] args) {
        BigInteger productOfSquares = getProductOfSquaresFor(200);
        System.out.print("Product of the squares of the first two hundred numbers = ");
        System.out.println(productOfSquares);
    }

    public static BigInteger getProductOfSquaresFor(int number) {
        BigInteger product = BigInteger.ONE;
        BigInteger square;
        for (int counter = 1; counter <= number; counter++) {
            square = BigInteger.valueOf((long) counter * counter);
            product = product.multiply(square);
        }
        return product;
    }
}
