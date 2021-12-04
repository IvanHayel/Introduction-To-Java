package one_dimensional_arrays.task_5;

/*
 * Integers a_1, a_2, ..., a_n are given.
 * Print only those numbers for which a_i > i.
 */

public class Task5 {
    public static void main(String[] args) {
        int[] numbers = {0, 31, 2, 5, 2, 12, 5};
        showLargerThanSerialNumber(numbers);
    }

    public static void showLargerThanSerialNumber(int[] numbers) {
        int serialNumber;
        System.out.println("Numbers larger than their serial number:");
        for (int index = 0; index < numbers.length; index++) {
            serialNumber = index + 1;
            if (numbers[index] > serialNumber) {
                System.out.print(numbers[index] + " ");
            }
        }
    }
}

