package string.task_3;

/*
 * Check if the given word is a palindrome.
 */

public class Task3 {
    public static void main(String[] args) {
        String word = "madam";
        System.out.println(word);
        if (isPalindrome(word)) {
            System.out.println("This is a palindrome.");
        } else {
            System.out.println("This is not a palindrome.");
        }
    }

    private static boolean isPalindrome(String word) {
        StringBuilder reverseWord = new StringBuilder(word);
        reverseWord.reverse();
        return word.equals(reverseWord.toString());
    }
}
