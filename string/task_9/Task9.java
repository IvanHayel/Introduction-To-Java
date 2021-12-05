package string.task_9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Count the number of lowercase and uppercase letters in the entered line.
 * Consider only English letters.
 */

public class Task9 {
    public static void main(String[] args) {
        String text = "Don’t Use a Comment When You Can Use a Function or a Variable";
        System.out.println(text);
        printCountOfUppercase(text);
        printCountOfLowercase(text);
    }

    private static void printCountOfUppercase(String text) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(text);
        int quantity = 0;
        while (matcher.find()) {
            quantity++;
        }
        System.out.println("Quantity of uppercase letter is " + quantity);
    }

    private static void printCountOfLowercase(String text) {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(text);
        int quantity = 0;
        while (matcher.find()) {
            quantity++;
        }
        System.out.println("Quantity of lowercase letter is " + quantity);
    }
}
