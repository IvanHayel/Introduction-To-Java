package com.epam.introduction.classes_and_objects.task_4;

/*
 * Create a Train class containing fields: destination name, train number, departure time.
 * Create data into an array of five elements of the Train type,
 * add the ability to sort the array elements by train numbers.
 * Add the ability to display information about the train, the number of which is entered by the user.
 * Add the ability to sort the array by destination,
 * where trains with the same destination must be sorted by departure time.
 */

import java.time.LocalTime;

public class Task4 {
    public static void main(String[] args) {
        Train[] trains = getFiveTrains();

        Train.showTrainsInfo(trains);

        Train.sortTrainsByNumber(trains);
        Train.showTrainsInfo(trains);

        Train.sortTrainsByDestination(trains);
        Train.showTrainsInfo(trains);

        Train.findTrainByNumber(trains);
    }

    private static Train[] getFiveTrains() {
        Train[] trains = new Train[5];
        Train train1 = new Train("London", 314, LocalTime.of(22, 50));
        Train train2 = new Train("Oxford", 159, LocalTime.of(4, 20));
        Train train3 = new Train("Salisbury", 265, LocalTime.of(13, 40));
        Train train4 = new Train("London", 358, LocalTime.of(14, 10));
        Train train5 = new Train("Oxford", 979, LocalTime.of(23, 30));
        trains[0] = train1;
        trains[1] = train2;
        trains[2] = train3;
        trains[3] = train4;
        trains[4] = train5;
        return trains;
    }
}