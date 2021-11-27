package methods.task_10;

/*
 * Дано натуральное число N. Написать метод(методы) для формирования массива,
 * элементами которого являются цифры числа N.
 */

import java.util.Arrays;

public class Task10 {
    public static void main(String[] args) {
        int naturalNumber = 10;
        int length = 5;
        int[] array = getArrayFilledWith(naturalNumber, length);
        show(array);
    }

    private static int[] getArrayFilledWith(int value, int length) {
        return Arrays.stream(new int[length])
                .map(el -> el = value)
                .toArray();
    }

    private static void show(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
