package com.epam.introduction.matrices.task_1;

/**
 * A matrix is given.
 * Display all odd columns with the first element greater than the last.
 */

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = {
                {50, 60, 70, 80, 90, 19},
                {33, 44, 55, 66, 77, 29},
                {51, 21, 12, 29, 21, 34}
        };

        showTaskOddColumns(matrix);
    }

    public static void showTaskOddColumns(int[][] matrix) {
        int rowLength = matrix.length;
        int first = 0;
        int last = rowLength - 1;

        System.out.println("Odd columns according task:");
        for (int[] rows : matrix) {
            for (int column = 0; column < rows.length; column++) {
                if (column % 2 == 0) {
                    if (matrix[first][column] > matrix[last][column]) {
                        System.out.print(rows[column] + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}