package cycles.task_4;

/*
 * Составить программу нахождения произведения квадратов первых 200 чисел.
 */

import java.math.BigInteger;

public class Task_4 {
    public static void main(String[] args) {
        BigInteger product_squares_200 = getProductOfSquaresFor(200);
        System.out.print("Product of the squares of the first two hundred numbers = ");
        System.out.println(product_squares_200);
    }

    public static BigInteger getProductOfSquaresFor(int number) {
        BigInteger product = BigInteger.ONE;
        BigInteger square;
        for (int i = 1; i <= number; i++) {
            square = BigInteger.valueOf((long) i * i);
            product = product.multiply(square);
        }
        return product;
    }
}
