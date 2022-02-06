package com.epam.introduction.classes_and_objects.task_1;

/*
 * Create class Test1 with two variables.
 * Add a display method and methods for modifying these variables.
 * Add a method that finds the sum of the values of these variables
 * and a method that finds the largest value of these two variables.
 */

import com.epam.introduction.classes_and_objects.task_1.model.test.Test1;

public class Runner {
    public static void main(String[] args) {
        int firstValue = 2;
        int secondValue = 3;

        Test1 object = new Test1(firstValue, secondValue);

        object.setFirst(3.141592);
        object.setSecond(3.589793);

        object.printFirst();
        object.printSecond();

        double sum = object.getSum();
        System.out.printf("Sum of values = %f\n", sum);

        double maxValue = object.getMax();
        System.out.printf("Max value = %f\n", maxValue);
    }
}