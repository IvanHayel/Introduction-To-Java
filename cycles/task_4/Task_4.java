package cycles.task_4;

public class Task_4 {
    public static void main(String[] args) {
        int sum_squares_200 = getSumOfSquaresFor(200);
        System.out.print("Product of the squares of the first two hundred numbers = ");
        System.out.println(sum_squares_200 + ".");
    }

    public static int getSumOfSquaresFor(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i * i;
        }
        return sum;
    }
}
