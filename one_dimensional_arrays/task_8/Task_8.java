package one_dimensional_arrays.task_8;

/*
 * Дана последовательность целых чисел a_1, a_2, ..., a_n.
 * Образовать новую последовательность, выбросив из исходной те члены,
 * которые равны min(a_1, a_2, ..., a_n).
 */

import java.util.ArrayList;

public class Task_8 {
    public static void main(String[] args) {
        int[] sequence = {1,1,3,4,11,23,43,1,1,55,1,23,1,1,1};
        ArrayList<Integer> numbers = getNumbers(sequence);
        removeMinNumbers(numbers);
        System.out.println(numbers);
    }

    public static void removeMinNumbers(ArrayList<Integer> numbers){
        if(numbers.isEmpty()) return;
        Integer minValue = getMinValue(numbers);
        while(numbers.contains(minValue))
            numbers.remove(minValue);
    }

    public static Integer getMinValue(ArrayList<Integer> numbers){
        Integer min = numbers.get(0);
        for(Integer number: numbers)
            if(min > number)
                min = number;
        return min;
    }

    public static ArrayList<Integer> getNumbers(int[] sequence){
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int number: sequence)
            numbers.add(number);
        return numbers;
    }
}
