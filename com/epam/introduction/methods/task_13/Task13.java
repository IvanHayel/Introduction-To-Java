package com.epam.introduction.methods.task_13;

import java.util.HashMap;
import java.util.Map;

/*
 * Two primes are called "twins" if they differ from each other by 2 (for example 41 and 43).
 * Find and print all pairs of "twins" from the segment (n, 2n), where n is a given natural number greater than 2.
 * To solve the problem, use decomposition.
 */

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
        for (int counter = rangeValue; counter <= 2 * rangeValue; counter++) {
            if (isPrime(counter) && isPrime(counter + 2)) {
                twinPrimes.put(counter, counter + 2);
            }
        }
        return twinPrimes;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int counter = 2; counter < number; counter++) {
            if (number % counter == 0) {
                return false;
            }
        }
        return true;
    }
}