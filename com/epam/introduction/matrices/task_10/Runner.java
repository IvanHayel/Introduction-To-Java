package com.epam.introduction.matrices.task_10;

import java.util.Arrays;

/**
 * Find the positive elements of the main diagonal of a square matrix.
 */

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = {
                {50, -60, 70},
                {33, -44, 55},
                {51, -21, 12}
        };

        int[] elements = getPositiveElementsOfMainDiagonal(matrix);
        System.out.println(Arrays.toString(elements));
    }

    private static int[] getPositiveElementsOfMainDiagonal(int[][] matrix) {
        int[] elements = new int[matrix[0].length];
        for (int counter = 0; counter < matrix.length; counter++) {
            elements[counter] = matrix[counter][counter];
        }
        return Arrays.stream(elements)
                .filter(element -> element > 0)
                .toArray();
    }
}