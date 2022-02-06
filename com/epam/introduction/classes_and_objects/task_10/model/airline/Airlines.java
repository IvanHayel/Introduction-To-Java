package com.epam.introduction.classes_and_objects.task_10.model.airline;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airlines {
    private List<Airline> airlines = new ArrayList<>();

    public void add(Airline airline) {
        airlines.add(airline);
    }

    public void printByDestination(String destination) {
        for (Airline airline : airlines) {
            if (destination.equals(airline.getDestination())) {
                System.out.println(airline);
            }
        }
    }

    public void printByDayOfWeek(DayOfWeek dayOfWeek) {
        for (Airline airline : airlines) {
            if (dayOfWeek == airline.getDayOfWeek()) {
                System.out.println(airline);
            }
        }
    }

    public void printByDayOfWeekAfterTime(DayOfWeek dayOfWeek, LocalTime time) {
        for (Airline airline : airlines) {
            if (dayOfWeek == airline.getDayOfWeek() && airline.getDepartureTime().isAfter(time)) {
                System.out.println(airline);
            }
        }
    }

}