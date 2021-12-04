package branching.task_5;

/*
 * Calculate the values of the function F (x):
 * = x ^ 2 - 3x + 9 if x <= 3;
 * = 1 / (x ^ 3 + 6) if x > 3;
 */

public class Task5 {
    public static void main(String[] args) {
        Function function = new Function(3.1415926535);
        System.out.println(function);
    }
}