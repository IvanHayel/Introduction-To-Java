package linear_programs.task_5;

/*
 * Дано натуральное число T, которое представляет длительность прошедшего
 * времени в секундах. Вывести данное значение длительности в часах, минутах
 * и секундах в следующей форме: HHчч MMмин SSс
 */

import java.time.LocalTime;

public class Task_5 {

    public static void main(String[] args) {
        int duration = 31415;
        showInTimeFormat(duration);
    }

    public static void showInTimeFormat(int seconds) {
        LocalTime timeFormat = LocalTime.of(0, 0, 0).plusSeconds(seconds);
        System.out.println(timeFormat.getHour() + " " +
                timeFormat.getMinute() + " " +
                timeFormat.getSecond());
    }
}
