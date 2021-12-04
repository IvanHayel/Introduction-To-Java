package matrices.task_7;

import java.util.Arrays;

import static java.lang.Math.sin;

/*
 * Form a square matrix of order N according to the rule:
 * a [i] [j] = sin ((i * i-j * j) / N)
 * and count the number of positive elements in it.
 */

public class Task7 {
    public static void main(String[] args) {
        int matrixSize = 1000;
        double[][] matrix = generateTaskMatrix(matrixSize);
        show(matrix);
        long countOfPositiveElements = getCountOfPositiveElements(matrix);
        System.out.println("Count of positive elements: " + countOfPositiveElements);
    }

    public static double[][] generateTaskMatrix(int matrixSize) {
        double[][] matrix = new double[matrixSize][matrixSize];
        for (int row = 0; row < matrixSize; row++)
            for (int column = 0; column < matrixSize; column++)
                matrix[row][column] = getRuleValue(row, column, matrixSize);
        return matrix;
    }

    public static double getRuleValue(int row, int column, int matrixSize) {
        return sin(((row + 1) * (row + 1) - (column + 1) * (column + 1)) /
                (double) matrixSize);
    }

    public static void show(double[][] matrix) {
        for (double[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    public static long getCountOfPositiveElements(double[][] matrix) {
        return Arrays.stream(matrix)
                .flatMapToDouble(Arrays::stream)
                .filter(value -> value > 0)
                .count();
    }
}