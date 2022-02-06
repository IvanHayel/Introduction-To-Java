package com.epam.introduction.string.task_10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Line X consists of several sentences, each ending with a dot, exclamation mark, or question mark.
 * Determine the number of sentences in line X.
 */

public class Runner {
    public static void main(String[] args) {
        String text = """
                What would happen if you allowed a bug to slip through a module, and it cost
                your company $10,000? The nonprofessional would shrug his shoulders, say
                “stuff happens,” and start writing the next module. The professional would
                write the company a check for $10,000!
                """;
        System.out.println(text);
        int numberOfSentences = getNumberOfSentences(text);
        System.out.printf("There are %d sentences.", numberOfSentences);
    }

    private static int getNumberOfSentences(String text) {
        Pattern pattern = Pattern.compile("[^.?!]+");
        Matcher matcher = pattern.matcher(text);
        int quantity = 0;
        while (matcher.find()) {
            quantity++;
        }
        return quantity;
    }
}
