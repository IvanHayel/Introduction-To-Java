package matrices.task_7;

/*
 * Сформировать квадратную матрицу порядка N по правилу:
 * a[i][j] = sin((i*i-j*j)/N)
 * и подсчитать количество положительных элементов в ней.
 */

import java.util.Arrays;

import static java.lang.Math.sin;
import static java.lang.Math.pow;

public class Task_7 {
    public static void main(String[] args) {
        int matrixSize = 20;
        double[][] matrix = generateTaskMatrix(matrixSize);
        show(matrix);
        int countOfPositiveElements = getCountOfPositiveElements(matrix);
        System.out.println("Count of positive elements: " + countOfPositiveElements);
    }

    public static double[][] generateTaskMatrix(int matrixSize) {
        if (matrixSize % 2 != 0)
            return generateTaskMatrix(matrixSize + 1);
        double[][] matrix = new double[matrixSize][matrixSize];
        for (int row = 0; row < matrixSize; row++)
            for (int column = 0; column < matrixSize; column++)
                matrix[row][column] = sin((pow(row + 1, 2) - pow(column + 1, 2)) / matrixSize);
        return matrix;
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
