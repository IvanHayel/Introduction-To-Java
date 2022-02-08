package com.epam.introduction.classes_and_objects.task_5;

import com.epam.introduction.classes_and_objects.task_5.model.counter.Counter;

/**
 * Describe a class that implements a decimal counter that can increment or
 * decrement its value by one within a given range.
 * Consider initializing the counter with default values and arbitrary values.
 * The counter has state increment and decrement methods, and a method to get its current state.
 * Write code that demonstrates all the features of the class.
 */

public class Runner {
    public static void main(String[] args) {
        Counter counter = new Counter(-5, 5);
        System.out.print("Increasing: ");
        while(!counter.isUpperLimit()){
            System.out.print(counter + " ");
            counter.increase();
        }
        System.out.print("\nDecreasing: ");
        while (!counter.isLowerLimit()){
            System.out.print(counter + " ");
            counter.decrease();
        }

        Counter defaultCounter = new Counter();
        System.out.print("\n\nDefault Counter increasing: ");
        while(!defaultCounter.isUpperLimit()){
            System.out.print(defaultCounter + " ");
            defaultCounter.increase();
        }
        System.out.print("\nDefault Counter decreasing: ");
        while (!defaultCounter.isLowerLimit()){
            System.out.print(defaultCounter + " ");
            defaultCounter.decrease();
        }
    }
}