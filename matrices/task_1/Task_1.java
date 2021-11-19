package matrices.task_1;

/*
 * Дана матрица. Вывести на экран все нечётные столбцы,
 * у которых первый элемент больше последнего.
 */

public class Task_1 {
    public static void main(String[] args) {
        int[][] matrix = {
                {50, 60, 70, 80, 90, 19},
                {33, 44, 55, 66, 77, 29},
                {51, 21, 12, 29, 21, 34}
        };

        showTaskOddColumns(matrix);
    }

    public static void showTaskOddColumns(int[][] matrix) {
        int rowLength = matrix.length;
        int first = 0;
        int last = rowLength - 1;

        System.out.println("Odd columns according task:");
        for (int[] rows : matrix) {
            for (int column = 0; column < rows.length; column++)
                if (column % 2 != 0)
                    if (matrix[first][column] > matrix[last][column])
                        System.out.print(rows[column] + " ");
            System.out.println();
        }
    }
}