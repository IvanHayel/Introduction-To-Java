package com.epam.introduction.basics_of_oop.task_3;

import java.time.LocalDate;
import java.time.Month;

/**
 * Create a Calendar class with an inner class that can be used to store information about weekends and holidays.
 */

public class Task3 {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        calendar.displayDate();

        calendar.addHoliday("Christmas Day", LocalDate.of(2022, Month.DECEMBER,25));
        calendar.addHoliday("Missionary Day", LocalDate.of(2022, Month.JANUARY,11));
        calendar.addHoliday("Mahavir Jayanti", LocalDate.of(2022, Month.APRIL,14));

        calendar.displayHolidays();
    }
}