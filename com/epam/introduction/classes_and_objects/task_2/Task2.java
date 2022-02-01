package com.epam.introduction.classes_and_objects.task_2;

/*
 * Create class Test2 with two variables.
 * Add a constructor with input parameters.
 * Add a constructor that initializes the default class members.
 * Add set- and get- methods for the fields of the class instance.
 */

public class Task2 {
    public static void main(String[] args) {
        byte firstValue = -50;
        byte secondValue = 35;

        Test2 firstObject = new Test2(firstValue, secondValue);
        Test2 secondObject = new Test2();

        firstObject.setFirst((byte) 12);
        System.out.println(firstObject.getFirst() + " " + firstObject.getSecond());

        secondObject.setFirst(firstValue);
        System.out.println(secondObject.getFirst() + " " + secondObject.getSecond());
    }
}