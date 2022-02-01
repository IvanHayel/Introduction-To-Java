package com.epam.introduction.string.task_8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * A string of words is entered, separated by insertSpaces.
 * Find the longest word and display it on the screen.
 * Do not process the case when there can be several longest words.
 */

public class Task8 {
    public static void main(String[] args) {
        String text = "The nonprofessional would shrug his shoulders, say " +
                "“stuff happens,” and start writing the next module";
        printLongestWord(text);
    }

    private static void printLongestWord(String text) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);
        int maxWordLength = getMaxWordLength(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() == maxWordLength) {
                System.out.println("The longest word: " + word);
                break;
            }
        }
    }

    private static int getMaxWordLength(String text) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);
        int maxWordLength = 0;
        int wordLength;
        while (matcher.find()) {
            wordLength = matcher.group().length();
            if (maxWordLength < wordLength) {
                maxWordLength = wordLength;
            }
        }
        return maxWordLength;
    }
}