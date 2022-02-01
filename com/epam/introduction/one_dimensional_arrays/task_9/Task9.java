package com.epam.introduction.one_dimensional_arrays.task_9;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
 * Find the most common number in an array of integers with n elements.
 * If there are several such numbers, then determine the smallest of them.
 */

public class Task9 {
    public static void main(String[] args) {
        Integer[] arrayOfIntegers = {
                9, 7, 11, 5,
                9, 7, 11, 0,
                9, 7, 11, 2,
                9, 7, 11, 5,
                9, 7, 11, 4
        };
        int mostCommonNumber = getMostCommonNumber(arrayOfIntegers);
        System.out.println("The most common number is " + mostCommonNumber + ".");
    }

    public static Integer getMostCommonNumber(Integer[] arrayOfIntegers) {
        HashMap<Integer, Integer> distinctNumbers = getHashMapOf(arrayOfIntegers);
        int numberOfOccurrences;
        int maxNumberOfOccurrences = 0;
        for (Integer number : arrayOfIntegers) {
            numberOfOccurrences = distinctNumbers.get(number) + 1;
            distinctNumbers.put(number, numberOfOccurrences);
            if (maxNumberOfOccurrences < numberOfOccurrences) {
                maxNumberOfOccurrences = numberOfOccurrences;
            }
        }
        TreeSet<Integer> mostCommonNumbers = new TreeSet<>();
        for (Map.Entry<Integer, Integer> entry : distinctNumbers.entrySet()) {
            if (entry.getValue().equals(maxNumberOfOccurrences)) {
                mostCommonNumbers.add(entry.getKey());
            }
        }
        return mostCommonNumbers.first();
    }

    public static HashMap<Integer, Integer> getHashMapOf(Integer[] arrayOfIntegers) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer number : arrayOfIntegers) {
            hashMap.putIfAbsent(number, 0);
        }
        return hashMap;
    }
}