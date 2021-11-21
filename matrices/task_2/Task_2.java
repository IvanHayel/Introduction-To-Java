package matrices.task_2;

/*
 * Дана квадратная матрица.
 * Вывести на экран элементы, стоящие на диагонали.
 */

public class Task_2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {50, 60, 70},
                {33, 44, 55},
                {51, 21, 12}
        };

        showMainDiagonalElements(matrix);
        showSideDiagonalElements(matrix);
    }

    public static void showMainDiagonalElements(int[][] matrix) {
        if (matrix.length != matrix[0].length)
            return;
        int matrixSize = matrix.length;

        System.out.print("Elements of the main diagonal of the matrix: ");
        for (int counter = 0; counter < matrixSize; counter++)
            System.out.print(matrix[counter][counter] + " ");
        System.out.println();
    }

    public static void showSideDiagonalElements(int[][] matrix) {
        if (matrix.length != matrix[0].length)
            return;
        int matrixSize = matrix.length;

        System.out.print("Elements of the side diagonal of the matrix: ");
        for (int counter = 0; counter < matrixSize; counter++)
            System.out.print(matrix[counter][matrixSize - counter - 1] + " ");
        System.out.println();
    }
}
