package com.epam.introduction.linear_programs.task_5;

import java.time.LocalTime;

/*
 * A natural number T is given, which represents the length of the elapsed time in seconds.
 * Output the given value of duration in hours,
 * minutes and seconds in the following form: HHhh MMmin SSs
 */

public class Task5 {

    public static void main(String[] args) {
        int duration = 31415;
        showInTimeFormat(duration);
    }

    public static void showInTimeFormat(int seconds) {
        LocalTime timeFormat = LocalTime.of(0, 0, 0).plusSeconds(seconds);
        System.out.println(seconds + "s = "
                + timeFormat.getHour() + "h "
                + timeFormat.getMinute() + "min "
                + timeFormat.getSecond() + "s.");
    }
}