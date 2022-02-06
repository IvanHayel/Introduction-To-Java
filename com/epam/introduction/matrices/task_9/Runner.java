package com.epam.introduction.matrices.task_9;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A matrix of non-negative numbers is given.
 * Calculate the sum of the items in each column.
 * Determine which column contains the maximum amount.
 */

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = {
                {50, 60, 70, 80, 70, 80, 70, 80, 70, 80, 90, 19},
                {33, 44, 55, 66, 77, 66, 77, 66, 77, 66, 77, 29},
                {51, 21, 12, 29, 66, 77, 66, 77, 66, 77, 21, 34}
        };

        Map<Integer, Integer> columnsSums = getColumnsSum(matrix);
        System.out.println(columnsSums);
        int maxColumnSum = getMaxColumnSum(columnsSums);
        System.out.println("Maximum column sum is " + maxColumnSum + ".");
    }

    private static Map<Integer, Integer> getColumnsSum(int[][] matrix) {
        Map<Integer, Integer> columnsSums = new HashMap<>();
        for (int[] row : matrix) {
            for (int column = 0; column < matrix[0].length; column++) {
                columnsSums.put(column + 1, columnsSums.getOrDefault(column + 1, 0) + row[column]);
            }
        }
        return columnsSums;
    }

    private static int getMaxColumnSum(Map<Integer, Integer> columnsSums) {
        return Collections.max(columnsSums.values());
    }
}
