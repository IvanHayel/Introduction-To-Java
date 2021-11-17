package one_dimensional_arrays.task_9;

/*
 * В массиве целых чисел с количеством элементов n
 * найти наиболее часто встречающееся число.
 * Если таких чисел несколько, то определить наименьшее из них.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Task_9 {
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
            if (maxNumberOfOccurrences < numberOfOccurrences)
                maxNumberOfOccurrences = numberOfOccurrences;
        }
        TreeSet<Integer> mostCommonNumbers = new TreeSet<>();
        for (Map.Entry<Integer, Integer> entry : distinctNumbers.entrySet())
            if (entry.getValue().equals(maxNumberOfOccurrences))
                mostCommonNumbers.add(entry.getKey());
        return mostCommonNumbers.first();
    }

    public static HashMap<Integer, Integer> getHashMapOf(Integer[] arrayOfIntegers) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer number : arrayOfIntegers)
            hashMap.putIfAbsent(number, 0);
        return hashMap;
    }
}
