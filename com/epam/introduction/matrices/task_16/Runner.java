package com.epam.introduction.matrices.task_16;

import com.epam.introduction.matrices.task_16.model.magic_square.MagicSquare;

import java.util.Scanner;

/**
 * A magic square of order n is a square matrix of size n x n, composed of numbers 1,2,3 ..., n ^ 2
 * so that the sums for each column, row and each of the two large diagonals are equal to each other.
 * Construct this square.
 */

public class Runner {
    public static void main(String[] args) {
        MagicSquare magicSquare = createMagicSquare();
        magicSquare.show();
    }

    private static MagicSquare createMagicSquare() {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMagicSquare;
        System.out.print("Please, enter size for magic square: ");
        sizeOfMagicSquare = scanner.nextInt();
        try {
            return new MagicSquare(sizeOfMagicSquare);
        } catch (Exception sizeException) {
            System.out.println(sizeException.getMessage());
            return createMagicSquare();
        }
    }
}