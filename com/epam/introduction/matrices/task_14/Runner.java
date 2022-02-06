package com.epam.introduction.matrices.task_14;

import java.util.*;

/**
 * Generate a random m x n matrix consisting of zeros and ones,
 * with the number of ones in each column equal to the column number.
 */

public class Runner {
    public static void main(String[] args) {
        int m = 5;
        int n = 10;
        int[][] matrix = generateRandomMatrix(m, n);
        show(matrix);
    }

    private static int[][] generateRandomMatrix(int numberOfRows, int numberOfColumns) {
        int[][] matrix = new int[numberOfColumns][numberOfRows];
        Queue<Integer> randomColumns = getRandomColumnNumbers(matrix[0].length);
        Collection<Integer> alreadyFilledColumns = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int counter = 0; counter <= row && counter < matrix[0].length; counter++) {
                if (randomColumns.isEmpty()) {
                    randomColumns = getRandomColumnNumbers(matrix[0].length);
                    randomColumns.removeAll(alreadyFilledColumns);
                }
                int column = randomColumns.remove();
                matrix[row][column] = 1;
                alreadyFilledColumns.add(column);
            }
            alreadyFilledColumns.clear();
        }
        matrix = transpose(matrix);
        return matrix;
    }

    private static LinkedList<Integer> getRandomColumnNumbers(int length) {
        List<Integer> columnNumbers = new ArrayList<>();
        for (int counter = 0; counter < length; counter++) {
            columnNumbers.add(counter);
        }
        Collections.shuffle(columnNumbers);
        return new LinkedList<>(columnNumbers);
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

    private static void show(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}