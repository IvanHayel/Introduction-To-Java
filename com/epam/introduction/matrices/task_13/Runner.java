package com.epam.introduction.matrices.task_13;

import java.util.Arrays;
import java.util.Collections;

/**
 * Sort matrix columns in ascending and descending order of element values.
 */

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = {
                {50, -60, 70},
                {33, -44, 55},
                {51, -21, 12}
        };

        System.out.println("Matrix:");
        show(matrix);
        matrix = transpose(matrix);
        sortRowsAsc(matrix);
        matrix = transpose(matrix);
        System.out.println("Ascending order:");
        show(matrix);
        matrix = transpose(matrix);
        sortRowsDesc(matrix);
        matrix = transpose(matrix);
        System.out.println("Descending order:");
        show(matrix);
    }

    private static void show(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void sortRowsAsc(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(matrix[row])
                    .sorted()
                    .toArray();
        }
    }

    private static void sortRowsDesc(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(matrix[row])
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }

    private static int[][] transpose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                transposedMatrix[column][row] = matrix[row][column];
            }
        }
        return transposedMatrix;
    }
}
