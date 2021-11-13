package linear_programs.task_5;

import java.time.LocalTime;

public class Task_5 {

    public static void main(String[] args) {
        int duration = 31415;
        showDurationInTimeFormat(duration);
    }

    public static void showDurationInTimeFormat(int seconds) {
        LocalTime timeFormat = LocalTime.of(0, 0, 0).plusSeconds(seconds);
        System.out.println(timeFormat.getHour() + " " +
                timeFormat.getMinute() + " " +
                timeFormat.getSecond());
    }
}
