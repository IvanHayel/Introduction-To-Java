package cycles.task_3;

public class Task_3 {
    public static void main(String[] args) {
        int sum_of_hundred = getSumOfNumbersFor(100);
        System.out.print("Sum of the first hundred numbers = ");
        System.out.println(sum_of_hundred + ".");
    }

    public static int getSumOfNumbersFor(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }
}
