package com.epam.introduction.basics_of_oop.task_4;

import com.epam.introduction.basics_of_oop.task_4.resource.model.treasure.DragonTreasures;

/**
 * The dragon and its treasures.
 * Create a program that allows you to collect information about 100 treasures in the dragon's cave.
 * Implement the ability to view treasures, select the most expensive treasure and value,
 * select a reward for a given amount.
 */

public class Runner {
    public static void main(String[] args) {
        DragonTreasures treasures = new DragonTreasures();

        treasures.displayTreasures();
        System.out.println();

        treasures.displayMostExpensiveTreasures();
        System.out.println();

        treasures.makeDealWithDragon(56500);
        System.out.println();

        treasures.displayTreasures();
        System.out.println();
    }
}