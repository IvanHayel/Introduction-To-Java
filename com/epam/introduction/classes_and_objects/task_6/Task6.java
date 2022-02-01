package com.epam.introduction.classes_and_objects.task_6;

/**
 * Write a class description to represent time.
 * Provide the possibility of setting the time and changing
 * its individual fields (hour, minute, second) with checking
 * the validity of the entered values.
 * If the field values are invalid, the field is set to 0.
 * Create methods for changing the time by the specified number of
 * hours, minutes and seconds.
 */

public class Task6 {
    public static void main(String[] args) {
        System.out.print("First time: ");
        Time firstTime = new Time(2,33,50);
        System.out.println(firstTime);

        System.out.print("New first time: ");
        firstTime.setTime(24, 4, 23);
        System.out.println(firstTime);

        System.out.print("Time with wrong input: ");
        Time wrongTime = new Time(13,-3,68);
        System.out.println(wrongTime);

        System.out.print("New time with wrong set: ");
        wrongTime.setTime(25,30);
        System.out.println(wrongTime);
    }
}