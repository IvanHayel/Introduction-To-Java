package com.epam.introduction.cycles.task_6;

/**
 * Display the correspondences between symbols and their numerical designations in the computer memory.
 */

public class Runner {
    public static void main(String[] args) {
        showUnicodeTable(231, 250);
    }

    public static void showUnicodeTable(int from, int to) {
        System.out.println("Unicode table from " + from +
                " to " + to + ".");
        for (int counter = from; counter <= to; counter++) {
            System.out.println(counter + " - " + (char) counter);
        }
    }
}