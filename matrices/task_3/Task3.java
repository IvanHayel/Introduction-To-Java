package matrices.task_3;

/*
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */

public class Task3 {
    public static void main(String[] args) {
        int[][] matrix = {
                {50, 60, 70, 80, 90, 19},
                {33, 44, 55, 66, 77, 29},
                {51, 21, 12, 29, 21, 34}
        };

        showRow(matrix, 1);
        showColumn(matrix, 5);
    }

    public static void showRow(int[][] matrix, int rowNumber) {
        if (rowNumber < 1 || rowNumber > matrix.length)
            return;
        int columnLength = matrix[0].length;
        System.out.print("Row " + rowNumber + ": ");
        for (int counter = 0; counter < columnLength; counter++)
            System.out.print(matrix[rowNumber - 1][counter] + " ");
        System.out.println();
    }

    public static void showColumn(int[][] matrix, int columnNumber) {
        if (columnNumber < 1 || columnNumber > matrix[0].length)
            return;
        System.out.println("Column " + columnNumber + ":");
        for (int[] rows : matrix)
            System.out.println(rows[columnNumber - 1] + " ");
    }
}
