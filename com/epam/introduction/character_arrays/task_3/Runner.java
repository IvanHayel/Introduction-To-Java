package com.epam.introduction.character_arrays.task_3;

/*
 * Find the number of digits in the string.
 */

public class Runner {
    public static void main(String[] args) {
        String someString = "After ten (10), eleven (11), twelve (12), thirteen (13), fourteen (14)";
        System.out.println(someString);
        int countOfDigits = getCountOfDigits(someString);
        System.out.println("There are " + countOfDigits + " digits in this string.");
    }

    private static int getCountOfDigits(String string) {
        int count = 0;
        for (char symbol : string.toCharArray()) {
            if (Character.isDigit(symbol)) {
                count++;
            }
        }
        return count;
    }
}