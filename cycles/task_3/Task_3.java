package cycles.task_3;

/*
 * Найти сумму квадратов первых ста чисел.
 */

public class Task_3 {
    public static void main(String[] args) {
        int sumOfSquares = getSumOfSquaresFor(100);
        System.out.print("Sum of the squares of the first hundred numbers = ");
        System.out.println(sumOfSquares);
    }

    public static int getSumOfSquaresFor(int number) {
        int sum = 0;
        for (int counter = 1; counter <= number; counter++) {
            sum += counter * counter;
        }
        return sum;
    }
}
