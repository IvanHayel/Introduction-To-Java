package com.epam.introduction.matrices.task_16.model.magic_square;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * De La Lubert's method was used in the class for constructing the "magic square".
 */

public class MagicSquare {
    private final double MAGIC_CONST;

    private int size;
    private int[][] magicSquare;
    private int halfSize;
    private Queue<Integer> magicValues;
    private int currentRow;
    private int currentColumn;

    public MagicSquare(int size) throws Exception {
        if (size % 2 == 0) throw new Exception("Enter odd size to magic square!");
        this.size = size;
        this.halfSize = getHalfSize(size);
        this.magicValues = getMagicValues(size);
        this.MAGIC_CONST = (size * ((size * size) + 1)) / 2.0;
        this.magicSquare = generateMagicSquare();
    }

    private int getHalfSize(int size) {
        if (size % 2 == 0) {
            return size / 2;
        }
        return size / 2 + 1;
    }

    private Queue<Integer> getMagicValues(int size) {
        Queue<Integer> magicValues = new LinkedList<>();
        for (int counter = 1; counter <= size * size; counter++) {
            magicValues.add(counter);
        }
        return magicValues;
    }

    private int[][] generateMagicSquare() {
        magicSquare = new int[size][size];
        firstRule();
        while (!magicValues.isEmpty()) {
            secondRule();
        }
        return magicSquare;
    }

    private void firstRule() {
        currentRow = 0;
        currentColumn = halfSize - 1;
        magicSquare[currentRow][currentColumn] = magicValues.remove();
        secondRule();
    }

    private void secondRule() {
        if (isAbleToPut(currentRow - 1, currentColumn + 1)) {
            currentRow--;
            currentColumn++;
            magicSquare[currentRow][currentColumn] = magicValues.remove();
        } else thirdRule();
    }

    private void thirdRule() {
        if (currentRow - 1 < 0 && isAbleToPut(size - 1, currentColumn + 1)) {
            currentRow = size - 1;
            currentColumn++;
            magicSquare[currentRow][currentColumn] = magicValues.remove();
        } else fourthRule();
    }

    private void fourthRule() {
        if (currentColumn + 1 >= size && isAbleToPut(currentRow - 1, 0)) {
            currentRow--;
            currentColumn = 0;
            magicSquare[currentRow][currentColumn] = magicValues.remove();
        } else fifthRule();
    }

    private void fifthRule() {
        if (isAbleToPut(currentRow + 1, currentColumn)) {
            currentRow++;
            magicSquare[currentRow][currentColumn] = magicValues.remove();
        }
    }

    private boolean isAbleToPut(int row, int column) {
        if (row < 0 || column < 0) {
            return false;
        }
        if (row >= size || column >= size) {
            return false;
        }
        return isElementEmpty(row, column);
    }

    private boolean isElementEmpty(int row, int column) {
        return magicSquare[row][column] == 0;
    }

    public void show() {
        System.out.println("Magic square:");
        for (int[] row : magicSquare) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Magic constant is " + MAGIC_CONST);
    }
}
