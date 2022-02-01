package com.epam.introduction.character_arrays.task_4;

/*
 * Find quantity of numbers in a string.
 */

public class Task4 {
    public static void main(String[] args) {
        String someString = "After ten (10), eleven (11), twelve (12), thirteen (13), fourteen (14)";
        System.out.println(someString);
        int quantityOfNumbers = getQuantityOfNumbers(someString);
        System.out.println("There are " + quantityOfNumbers + " numbers in this string.");
    }

    private static int getQuantityOfNumbers(String string) {
        char[] symbols = string.toCharArray();
        int quantity = 0;
        for (int counter = 0; counter < symbols.length; counter++) {
            if (Character.isDigit(symbols[counter])) {
                while (Character.isDigit(symbols[counter + 1])) {
                    counter++;
                }
                quantity++;
            }
        }
        return quantity;
    }
}
