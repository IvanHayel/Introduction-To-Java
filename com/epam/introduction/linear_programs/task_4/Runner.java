package com.epam.introduction.linear_programs.task_4;

import com.epam.introduction.linear_programs.task_4.model.real_number.RealNumber;

/**
 * You are given a real number R of the form nnn.ddd (three digital digits in fractional and integer parts).
 * Swap the fractional and integer parts of the number and display the resulting value of the number.
 */

public class Runner {
    public static void main(String[] args) {
        RealNumber realNumber = new RealNumber(231.123);
        realNumber.showRealNumber();
        realNumber.swapIntegerAndFractional();
        realNumber.showRealNumber();
        realNumber.swapIntegerAndFractional();
        System.out.println(realNumber);
    }
}