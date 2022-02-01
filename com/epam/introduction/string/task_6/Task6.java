package com.epam.introduction.string.task_6;

/*
 * Get a new one from the given string by repeating each character twice.
 */

public class Task6 {
    public static void main(String[] args) {
        String text = "Some text";
        System.out.println(text);
        String textWithRepeatedCharacters = getTextWithRepeatedCharacters(text);
        System.out.println(textWithRepeatedCharacters);
    }

    private static String getTextWithRepeatedCharacters(String text) {
        StringBuilder newText = new StringBuilder();
        for (char character : text.toCharArray()) {
            newText.append(character);
            newText.append(character);
        }
        return newText.toString();
    }
}
