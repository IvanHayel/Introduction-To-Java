package cycles.task_6;

/*
 * Вывести на экран соответствий между символами и их численными
 * обозначениями в памяти компьютера.
 */

public class Task_6 {
    public static void main(String[] args) {
        showUnicodeTable(231, 250);
    }

    public static void showUnicodeTable(int from, int to) {
        System.out.println("Unicode table from " + from +
                " to " + to + ".");
        for (int counter = from; counter <= to; counter++)
            System.out.println(counter + " - " + (char) counter);
    }
}
