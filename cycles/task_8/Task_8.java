package cycles.task_8;

import java.util.ArrayList;
import java.util.List;

public class Task_8 {
    public static void main(String[] args) {
        int firstValue = 113357799;
        int secondValue = 314159265;
        showIdenticalDigits(firstValue, secondValue);
    }

    public static void showIdenticalDigits(int firstValue, int secondValue) {
        List<Character> digits_1 = getListOfDigits(firstValue);
        List<Character> digits_2 = getListOfDigits(secondValue);
        List<Character> distinct_result_digits = new ArrayList<>();
        for (char digit : digits_1) {
            if (digits_2.contains(digit) && !distinct_result_digits.contains(digit))
                distinct_result_digits.add(digit);
        }

        System.out.print("Identical digits from both values: ");
        for (char digit : distinct_result_digits) {
            System.out.print(digit + " ");
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
