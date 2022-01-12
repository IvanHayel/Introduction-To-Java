package basics_of_oop.task_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private List<Holiday> holidays;
    private LocalDate today;

    public Calendar() {
        holidays = new ArrayList<>();
        today = LocalDate.now();
    }

    public void displayDate() {
        today = LocalDate.now();
        System.out.println("Today is " + today + ", " + today.getDayOfWeek().toString().toLowerCase());
    }

    public void addHoliday(String holidayName, LocalDate date) {
        holidays.add(new Holiday(holidayName, date));
    }

    public void displayHolidays() {
        System.out.println("Holidays:");
        int counter = 0;
        for (Holiday holiday : holidays) {
            System.out.println(++counter + ". " + holiday);
        }
    }

    class Holiday {
        private String holidayName;
        private LocalDate holidayDate;

        public Holiday(String holidayName, LocalDate holidayDate) {
            this.holidayName = holidayName;
            this.holidayDate = holidayDate;
        }

        @Override
        public String toString() {
            return holidayName + " " + holidayDate;
        }
    }
}