package matrices.task_7;

/*
 * Сформировать квадратную матрицу порядка N по правилу:
 * a[i][j] = sin((i*i-j*j)/N)
 * и подсчитать количество положительных элементов в ней.
 */

import java.util.Arrays;

import static java.lang.Math.sin;

public class Task_7 {
    public static void main(String[] args) {
        int matrixSize = 10000;
        double[][] matrix = generateTaskMatrix(matrixSize);
        show(matrix);
        int countOfPositiveElements = getCountOfPositiveElements(matrix);
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

    public static int getCountOfPositiveElements(double[][] matrix) {
        int counter = 0;
        for (double[] row : matrix)
            for (double element : row)
                if (element > 0)
                    counter++;
        return counter;
    }
}
