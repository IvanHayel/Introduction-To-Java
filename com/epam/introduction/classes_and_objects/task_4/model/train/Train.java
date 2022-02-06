package com.epam.introduction.classes_and_objects.task_4.model.train;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class Train implements Comparable<Train> {
    private final String destination;
    private final int trainNumber;
    private final LocalTime departureTime;

    public Train(String destination, int trainNumber, LocalTime departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    public void showInfo() {
        System.out.printf("Train %d leaves at %s for %s\n",
                trainNumber, departureTime, destination);
    }

    public static void showTrainsInfo(Train[] trains) {
        System.out.println("\t\tTRAINS INFORMATION");
        for (Train train : trains) {
            train.showInfo();
        }
    }

    public static void findTrainByNumber(Train[] trains) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter train number: ");
        int trainNumber = scanner.nextInt();
        for (Train train : trains) {
            if (train.trainNumber == trainNumber) {
                train.showInfo();
                return;
            }
        }
        System.out.println("No trains with this number were found.");
    }

    public static void sortTrainsByNumber(Train[] trains) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~TRAINS SORTED BY NUMBER~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Arrays.sort(trains);
    }

    public static void sortTrainsByDestination(Train[] trains) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~TRAINS SORTED BY DESTINATION~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Arrays.sort(trains, (train, anotherTrain) -> {
            if (train.destination.equals(anotherTrain.destination)) {
                return train.departureTime.compareTo(anotherTrain.departureTime);
            }
            return train.destination.compareTo(anotherTrain.destination);
        });
    }

    @Override
    public int compareTo(Train train) {
        return Integer.compare(trainNumber, train.trainNumber);
    }
}