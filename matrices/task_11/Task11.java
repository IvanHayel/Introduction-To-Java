package matrices.task_11;

import java.util.*;

/*
 * Fill the 10x20 matrix with random numbers from 0 to 15.
 * Display the matrix and the row numbers in which the number 5 occurs three or more times.
 */

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
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                matrix[row][column] = random.nextInt(15);
            }
        }
        return matrix;
    }

    private static void show(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[] getRowNumbersWithCommonValue(int[][] matrix, int value) {
        Map<Integer, Integer> rowNumbers = new HashMap<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == value) {
                    rowNumbers.put(row + 1, rowNumbers.getOrDefault(row + 1, 0) + 1);
                }
            }
        }
        rowNumbers.values()
                .removeIf(numberOfOccurrences -> numberOfOccurrences < 3);
        return rowNumbers
                .keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}