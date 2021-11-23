package matrices.task_11;

/*
 * Матрицу 10х20 заполнить случайными числами от 0 до 15. Вывести на экран матрицу
 * и номера строк, в которых число 5 встречается три и более раз.
 */

import java.util.*;

public class Task11 {
    public static void main(String[] args) {
        int commonValue = 5;
        int[][] matrix = generateRandomMatrix(10, 20);
        show(matrix);
        int[] rowsWithCommonValue = getRowNumbersWithCommonValue(matrix, commonValue);
        System.out.print("Matrix rows where the value " + commonValue + " occurs at least 3 times: ");
        System.out.println(Arrays.toString(rowsWithCommonValue));
    }

    private static int[][] generateRandomMatrix(int numberOfRows, int numberOfColumns) {
        int[][] matrix = new int[numberOfRows][numberOfColumns];
        Random random = new Random();
        for (int row = 0; row < numberOfRows; row++)
            for (int column = 0; column < numberOfColumns; column++)
                matrix[row][column] = random.nextInt(15);
        return matrix;
    }

    private static void show(int[][] matrix) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    private static int[] getRowNumbersWithCommonValue(int[][] matrix, int value) {
        Map<Integer, Integer> rowNumbers = new HashMap<>();
        for (int row = 0; row < matrix.length; row++)
            for (int column = 0; column < matrix[row].length; column++)
                if (matrix[row][column] == value)
                    rowNumbers.put(row + 1, rowNumbers.getOrDefault(row + 1, 0) + 1);
        rowNumbers.values()
                .removeIf(numberOfOccurrences -> numberOfOccurrences < 3);
        return rowNumbers
                .keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}