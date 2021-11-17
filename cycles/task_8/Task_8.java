package cycles.task_8;

/*
 * Даны два числа. Определить цифры, входящие в запись как первого
 * так и второго числа.
 */

import java.util.ArrayList;
import java.util.List;

public class Task_8 {
    public static void main(String[] args) {
        int firstValue = 113357799;
        int secondValue = 314159265;
        showIdenticalDigits(firstValue, secondValue);
    }

    public static void showIdenticalDigits(int firstValue, int secondValue) {
        List<Character> firstValueDigits = getListOfDigits(firstValue);
        List<Character> secondValueDigits = getListOfDigits(secondValue);
        List<Character> distinctDigits = new ArrayList<>();
        for (char digit : firstValueDigits)
            if (secondValueDigits.contains(digit) && !distinctDigits.contains(digit))
                distinctDigits.add(digit);

        System.out.print("Identical digits from both values: ");
        for (char identicalDigit : distinctDigits)
            System.out.print(identicalDigit + " ");
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
