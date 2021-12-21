package classes_and_objects.task_10;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Airline {
    private String destination;
    private long flightNumber;
    private AircraftType type;
    private LocalTime departureTime;
    private DayOfWeek dayOfWeek;

    public Airline(String destination, long flightNumber, AircraftType type,
                   LocalTime departureTime, DayOfWeek dayOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.type = type;
        this.departureTime = departureTime;
        this.dayOfWeek = dayOfWeek;
    }

    public Airline() {
        this("UNKNOWN", 0L, AircraftType.UNKNOWN,
                LocalTime.of(0, 0), DayOfWeek.MONDAY);
    }

    public String getDestination() {
        return destination;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "Airline [" +
                "destination = '" + destination + '\'' +
                ", flight number = " + flightNumber +
                ", type = " + type +
                ", departure time = " + departureTime +
                ", day of week = " + dayOfWeek +
                ']';
    }
}