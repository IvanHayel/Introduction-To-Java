package com.epam.introduction.character_arrays.task_2;

/*
 * Replace all occurrences of 'word' in the string with 'letter'.
 */

public class Task2 {
    public static void main(String[] args) {
        String text = "Some word with word to word.";
        System.out.println(text);
        text = replaceWord(text);
        System.out.println(text);
    }

    private static String replaceWord(String text) {
        char[] symbols = text.toCharArray();
        StringBuilder newText = new StringBuilder();
        for (int index = 0; index < symbols.length; index++) {
            if (    symbols[index] == 'w'
                    && symbols[index + 1] == 'o'
                    && symbols[index + 2] == 'r'
                    && symbols[index + 3] == 'd'
            ) {
                index += 3;
                newText.append("letter");
            } else {
                newText.append(symbols[index]);
            }
        }
        return newText.toString();
    }
}