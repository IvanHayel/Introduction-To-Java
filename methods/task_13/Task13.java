package methods.task_13;

/*
 * Два простых числа называются "близнецами", если они отличаются друг от друга на 2
 * (например 41 и 43). Найти и напечатать все пары "близнецов" из отрезка (n,2n), где
 * n - заданное натуральное число больше 2.
 * Для решения задачи использовать декомпозицию.
 */

import java.util.HashMap;
import java.util.Map;

public class Task13 {
    public static void main(String[] args) {
        int naturalNumber = 40;
        showTwinPrimes(naturalNumber);
    }

    private static void showTwinPrimes(int rangeValue) {
        Map<Integer, Integer> primeTwins = getTwinPrimes(rangeValue);
        System.out.println("Twin primes ranging from " + rangeValue + " to " + 2 * rangeValue + ":");
        System.out.println(primeTwins);
    }

    private static Map<Integer, Integer> getTwinPrimes(int rangeValue) {
        Map<Integer, Integer> twinPrimes = new HashMap<>();
        for (int counter = rangeValue; counter <= 2 * rangeValue; counter++)
            if (isPrime(counter) && isPrime(counter + 2))
                twinPrimes.put(counter, counter + 2);
        return twinPrimes;
    }

    private static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int counter = 2; counter < number; counter++)
            if (number % counter == 0)
                return false;
        return true;
    }
}
