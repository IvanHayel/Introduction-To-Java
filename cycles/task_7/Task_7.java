package cycles.task_7;

/*
 * Для каждого натурального числа в промежутке от m до n вывести все делители,
 * кроме единицы и самого числа. m и n вводятся с клавиатуры.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args) {
        NaturalNumbers numbers = new NaturalNumbers();
        System.out.println(numbers);
        numbers.showDivisors();
    }
}

final class NaturalNumbers {
    private int m;
    private int n;
    ArrayList<Integer> numbers;

    public NaturalNumbers() {
        enterRangeOfNaturalNumbers();
        fillNumbers();
    }

    public NaturalNumbers(int m, int n) {
        this.m = m;
        this.n = n;
        fillNumbers();
    }

    private void fillNumbers() {
        numbers = new ArrayList<>();
        for (int number = m; number <= n; number++)
            numbers.add(number);
    }

    private void enterRangeOfNaturalNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter range of natural numbers");
        System.out.print("from: ");
        m = scanner.nextInt();
        System.out.print("to: ");
        n = scanner.nextInt();
    }

    public void showDivisors() {
        for (Integer number : numbers) {
            System.out.print("Divisors for " + number + ": ");
            for (int divisor = 2; divisor < number; divisor++)
                if (number % divisor == 0)
                    System.out.print(divisor + " ");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "NaturalNumbers{" +
                "m=" + m +
                ", n=" + n +
                ", numbers=" + numbers +
                '}';
    }
}