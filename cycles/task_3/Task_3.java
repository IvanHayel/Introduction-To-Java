package cycles.task_3;

/*
 * Найти сумму квадратов первых ста чисел.
 */

public class Task_3 {
    public static void main(String[] args) {
        int sum_squares_100 = getSumOfSquaresFor(100);
        System.out.print("Sum of the squares of the first hundred numbers = ");
        System.out.println(sum_squares_100);
    }

    public static int getSumOfSquaresFor(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i * i;
        }
        return sum;
    }
}
