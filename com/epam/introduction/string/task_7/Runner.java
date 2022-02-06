package com.epam.introduction.string.task_7;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A string is entered. It is required to remove duplicate characters and all insertSpaces from it.
 * For example, if you entered "abc cde def ", then "abcdef" should be output.
 */

public class Runner {
    public static void main(String[] args) {
        String string = "abc cde def AD sadsa r  wq";
        String distinctString = getDistinctString(string);
        System.out.println(distinctString);
    }

    private static String getDistinctString(String string) {
        Set<Character> characterSet = new LinkedHashSet<>();
        for (Character character : string.toCharArray()) {
            characterSet.add(character);
        }
        characterSet.remove(' ');
        StringBuilder distinctString = new StringBuilder();
        for (Character character : characterSet) {
            distinctString.append(character);
        }
        return distinctString.toString();
    }
}
