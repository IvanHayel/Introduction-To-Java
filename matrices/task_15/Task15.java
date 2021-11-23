package matrices.task_15;

/*
 * Найдите наибольший элемент матрицы и ззаменить ввсе нечётные элементы на него.
 */

import java.util.Arrays;
import java.util.OptionalInt;

public class Task15 {
    public static void main(String[] args) {
        int[][] matrix = {
                {43, -61, 11, 44},
                {33, -43, 13, 41},
                {12, -21, 14, 12}
        };

        System.out.println("Matrix:");
        show(matrix);

        int maxMatrixElement = getMaxElement(matrix);
        System.out.println("Maximum matrix element is " + maxMatrixElement);

        System.out.println("Matrix after replace odd elements: ");
        replaceOddElements(matrix, maxMatrixElement);
        show(matrix);
    }

    private static void show(int[][] matrix) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    private static void replaceOddElements(int[][] matrix, int valueToReplace) {
        for (int row = 0; row < matrix.length; row++)
            for (int column = 0; column < matrix[0].length; column++)
                if (matrix[row][column] % 2 != 0)
                    matrix[row][column] = valueToReplace;
    }

    private static int getMaxElement(int[][] matrix) {
        OptionalInt maxElement = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .max();
        if (maxElement.isPresent())
            return maxElement.getAsInt();
        else
            return Integer.MIN_VALUE;
    }
}