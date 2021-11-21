package matrices.task_14;

/*
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц,
 * причём в каждом столбце число единиц равно номеру столбца.
 * (P.S. 5x10, столбцы начиная с 6 не вместят в себя столько единиц.)
 */

import java.util.*;

public class Task_14 {
    public static void main(String[] args) {
        int m = 5;
        int n = 10;
        int[][] matrix = generateRandomMatrix(m, n);
        show(matrix);
    }

    private static void show(int[][] matrix) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    private static int[][] generateRandomMatrix(int numberOfRows, int numberOfColumns) {
        int[][] matrix = new int[numberOfColumns][numberOfRows];
        Queue<Integer> randomColumns = getRandomColumnNumbers(matrix[0].length);
        for (int row = 0; row < matrix.length; row++)
            for (int counter = 0; counter <= row; counter++) {
                if (randomColumns.isEmpty())
                    randomColumns = getRandomColumnNumbers(matrix[0].length);
                int column = randomColumns.remove();
                matrix[row][column] = 1;
            }
        matrix = transpose(matrix);
        return matrix;
    }

    private static LinkedList<Integer> getRandomColumnNumbers(int length) {
        List<Integer> columnNumbers = new ArrayList<>();
        for (int counter = 0; counter < length; counter++)
            columnNumbers.add(counter);
        Collections.shuffle(columnNumbers);
        return new LinkedList<>(columnNumbers);
    }

    private static int[][] transpose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++)
            for (int column = 0; column < matrix[row].length; column++)
                transposedMatrix[column][row] = matrix[row][column];
        return transposedMatrix;
    }
}