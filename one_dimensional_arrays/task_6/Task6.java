package one_dimensional_arrays.task_6;

/*
 * Задана последовательность N вещественных чисел.
 * Вычислить сумму чисел, порядковые номера 1,2, ..., N
 * которых являются простыми числами.
 */

public class Task6 {
    public static void main(String[] args) {
        double[] numbers = {3.14, 1.59, 2.65, 3.58, 9.79, 3.23};
        double sum = getSumWithPrimeIndexNumber(numbers);
        System.out.print("The sum of numbers whose index numbers are prime numbers: ");
        System.out.println(sum);
    }

    public static double getSumWithPrimeIndexNumber(double[] numbers) {
        double sum = 0;
        for (int counter = 0; counter < numbers.length; counter++) {
            if(isPrime(counter+1))
                sum += numbers[counter];
        }
        return sum;
    }

    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int counter = 2; counter < number; counter++) {
            if (number % counter == 0)
                return false;
        }
        return true;
    }


}