package matrices.task_12;

/*
 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */

import java.util.Arrays;
import java.util.Collections;

public class Task12 {
    public static void main(String[] args) {
        int[][] matrix = {
                {50, -60, 70},
                {33, -44, 55},
                {51, -21, 12}
        };

        show(matrix);
        sortRowsAsc(matrix);
        System.out.println("Ascending order:");
        show(matrix);
        sortRowsDesc(matrix);
        System.out.println("Descending order:");
        show(matrix);
    }

    private static void show(int[][] matrix) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    private static void sortRowsAsc(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++)
            matrix[row] = Arrays.stream(matrix[row])
                    .sorted()
                    .toArray();
    }

    private static void sortRowsDesc(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++)
            matrix[row] = Arrays.stream(matrix[row])
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();

    }
}
