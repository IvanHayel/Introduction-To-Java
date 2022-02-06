package com.epam.introduction.cycles.task_8;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Two numbers are given.
 * Determine the numbers included in the recording of both the first and second numbers.
 */


public class Runner {
    public static void main(String[] args) {
        int firstValue = 113357799;
        int secondValue = 314159265;
        System.out.printf("First value = %d. Second value = %d.\n", firstValue, secondValue);
        showIdenticalDigits(firstValue, secondValue);
    }

    public static void showIdenticalDigits(int firstValue, int secondValue) {
        List<Character> firstValueDigits = getListOfDigits(firstValue);
        List<Character> secondValueDigits = getListOfDigits(secondValue);
        TreeSet<Character> identicalDigits = new TreeSet<>(firstValueDigits);
        identicalDigits.retainAll(secondValueDigits);

        System.out.print("Identical digits from both values: ");
        for (char identicalDigit : identicalDigits) {
            System.out.print(identicalDigit + " ");
        }
    }

    public static List<Character> getListOfDigits(int number) {
        List<Character> resultList = new ArrayList<>();
        String value = Integer.toString(number);
        for (char digit : value.toCharArray()) {
            resultList.add(digit);
        }
        return resultList;
    }
}
