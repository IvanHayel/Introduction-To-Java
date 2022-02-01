package com.epam.introduction.string.task_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Count how many times the letter "a" is among the characters of a given string.
 */

public class Task5 {
    public static void main(String[] args) {
        String text = """
                Why do most developers fear to make continuous changes to their code?
                They are afraid they’ll break it!
                Why are they afraid they’ll break it?
                Because they don’t have tests.\s
                """;
        System.out.println(text);

        int quantity = getQuantityOfLetter(text, 'a');
        System.out.println("Quantity of letter 'a' in text = " + quantity);
    }

    private static int getQuantityOfLetter(String text, char letter) {
        Pattern pattern = Pattern.compile(String.valueOf(letter));
        Matcher matcher = pattern.matcher(text);
        int quantity = 0;
        while (matcher.find()) {
            quantity++;
        }
        return quantity;
    }
}