package classes_and_objects.task_10;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Task10 {
    public static void main(String[] args) {
        Airline unknownAirline = new Airline();
        Airline firstAirline = new Airline(
                "Bangkok", 91231239, AircraftType.WIDE_BODY,
                LocalTime.of(23, 30), DayOfWeek.SUNDAY
        );
        Airline secondAirline = new Airline(
                "Bangkok", 123124, AircraftType.NARROW_BODY,
                LocalTime.of(5, 25), DayOfWeek.SUNDAY
        );
        Airline thirdAirline = new Airline(
                "Yokohama", 2134135, AircraftType.REGIONAL,
                LocalTime.of(6, 30), DayOfWeek.THURSDAY
        );

        Airlines airlines = new Airlines();
        airlines.add(unknownAirline);
        airlines.add(firstAirline);
        airlines.add(secondAirline);
        airlines.add(thirdAirline);

        System.out.println("Airlines with destination 'Bangkok':");
        airlines.printByDestination("Bangkok");
        System.out.println("Airplanes that take off on thursday:");
        airlines.printByDayOfWeek(DayOfWeek.THURSDAY);
        System.out.println("Airplanes that take off on sunday after 10:00 PM:");
        airlines.printByDayOfWeekAfterTime(DayOfWeek.SUNDAY, LocalTime.of(22, 0));
    }
}