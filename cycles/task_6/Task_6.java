package cycles.task_6;

public class Task_6 {
    public static void main(String[] args) {
        showUnicodeTable(231, 250);
    }

    public static void showUnicodeTable(int from, int to) {
        System.out.println("Unicode table from " + from +
                " to " + to + ".");
        for (int i = from; i <= to; i++) {
            System.out.println(i + " - " + (char) i);
        }
    }
}