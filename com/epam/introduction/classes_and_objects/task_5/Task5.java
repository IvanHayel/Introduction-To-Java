package com.epam.introduction.classes_and_objects.task_5;

public class Task5 {
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