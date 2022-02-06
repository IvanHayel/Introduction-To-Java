package com.epam.introduction.matrices.task_8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * In a numerical matrix, swap any two columns, that is,
 * put all the elements of one column in the corresponding positions of the other,
 * and move its elements of the second to the first.
 * Column numbers are entered by the user from the keyboard.
 */

public class Runner {
    static int wrongValueCounter = 0;

    public static void main(String[] args) {
        int[][] matrix = {
                {50, 60, 70, 80, 70, 80, 70, 80, 70, 80, 90, 19},
                {33, 44, 55, 66, 77, 66, 77, 66, 77, 66, 77, 29},
                {51, 21, 12, 29, 66, 77, 66, 77, 66, 77, 21, 34}
        };

        show(matrix);
        System.out.println("Swap two columns from the matrix above.");
        try {
            swapColumns(matrix);
            show(matrix);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void show(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void swapColumns(int[][] matrix) throws Exception {
        int columnLength = matrix[0].length;
        int firstColumnToSwap = enterColumnToSwap(columnLength) - 1;
        int secondColumnToSwap = enterColumnToSwap(columnLength) - 1;
        int tempColumn;

        for (int[] row : matrix) {
            tempColumn = row[firstColumnToSwap];
            row[firstColumnToSwap] = row[secondColumnToSwap];
            row[secondColumnToSwap] = tempColumn;
        }

    }

    public static int enterColumnToSwap(int columnLength) throws Exception {
        if (wrongValueCounter > 2) {
            throw new Exception("Value entered incorrectly too many times!");
        }
        System.out.print("Enter column number to swap from 1 to " + columnLength + ": ");
        int column = enterNumberFromKeyboard();
        if (column < 1 || column > columnLength) {
            System.out.println("Wrong value entered, please try again...");
            wrongValueCounter++;
            return enterColumnToSwap(columnLength);
        }
        return column;
    }

    public static int enterNumberFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
