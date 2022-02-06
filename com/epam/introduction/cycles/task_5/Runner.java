package com.epam.introduction.cycles.task_5;

import com.epam.introduction.cycles.task_5.model.series.number.NumberSeries;

/**
 * A number of series and some number e are given. Find the sum of those members of the series
 * whose modulus is greater than or equal to the given e. The general term of the series is:
 * a_n = 1 / (2 ^ n) + 1 / (3 ^ n).
 */

public class Runner {
    public static void main(String[] args) {
        NumberSeries numberSeries = new NumberSeries(1.0E-5);
        System.out.println(numberSeries);
        numberSeries.showSumOfMembers();
    }
}