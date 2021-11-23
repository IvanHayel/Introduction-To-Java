package cycles.task_8;

/*
 * Даны два числа. Определить цифры, входящие в запись как первого
 * так и второго числа.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Task8 {
    public static void main(String[] args) {
        int firstValue = 113357799;
        int secondValue = 314159265;
        showIdenticalDigits(firstValue, secondValue);
    }

    public static void showIdenticalDigits(int firstValue, int secondValue) {
        List<Character> firstValueDigits = getListOfDigits(firstValue);
        List<Character> secondValueDigits = getListOfDigits(secondValue);
        TreeSet<Character> identicalDigits = new TreeSet<>(firstValueDigits);
        identicalDigits.retainAll(secondValueDigits);

        System.out.print("Identical digits from both values: ");
        for (char identicalDigit : identicalDigits)
            System.out.print(identicalDigit + " ");
    }

    public static List<Character> getListOfDigits(int number) {
        List<Character> resultList = new ArrayList<>();
        String value = Integer.toString(number);
        for (char digit : value.toCharArray())
            resultList.add(digit);
        return resultList;
    }
}
