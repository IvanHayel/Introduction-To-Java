package sorting.task_1;

/*
 * Заданы два одномерных массива с различным количеством элементов и натуральное число k.
 * Объединить их в один массив, включив второй массив между k-м и (k+1)-м элементами первого,
 * при этом не используя дополнительный массив.
 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        int[] firstArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] secondArray = {22, 22, 22, 22, 22};
        int naturalNumber = 7;
        IntStream firstPart = IntStream.of(firstArray).limit(naturalNumber);
        IntStream secondPart = IntStream.of(secondArray);
        IntStream thirdPart = IntStream.of(firstArray).skip(naturalNumber);
        firstArray = concat(firstPart, secondPart, thirdPart).toArray();
        showArray(firstArray);
    }

    public static void showArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static IntStream concat(IntStream first, IntStream second, IntStream third) {
        return IntStream.concat(IntStream.concat(first, second), third);
    }
}