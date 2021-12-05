package string.task_2;

/*
 * In the string insert after each 'a' character 'b'
 */

public class Task2 {
    public static void main(String[] args) {
        String text = "Programming is a social activity.";
        System.out.println(text);
        text = text.replaceAll("a", "ab");
        System.out.println(text);
    }
}
