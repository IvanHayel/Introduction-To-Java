package com.epam.introduction.aggregation_and_composition.task_2.model.car;

import com.epam.introduction.aggregation_and_composition.task_2.model.car.wheel.CarWheelPlacement;
import com.epam.introduction.aggregation_and_composition.task_2.model.car.engine.Engine;
import com.epam.introduction.aggregation_and_composition.task_2.model.car.fuel.FuelType;
import com.epam.introduction.aggregation_and_composition.task_2.model.car.wheel.Wheel;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private String model;
    private Map<CarWheelPlacement, Wheel> wheels;
    private Engine engine;
    private boolean isFueled;

    public Car(String model, Engine engine, Wheel wheelType) {
        this.model = model;
        this.engine = engine;
        wheels = new HashMap<>();
        completeWithWheels(wheelType);
    }

    public Car(String model, Engine engine) {
        this(model, engine, new Wheel(model + " standard wheel"));
    }

    public Car(String model) {
        this(model, new Engine(model + " standard engine", FuelType.PETROL));
    }

    private void completeWithWheels(Wheel wheel) {
        for (CarWheelPlacement placement : CarWheelPlacement.values()) {
            wheels.put(placement, wheel);
        }
    }

    public void ride() {
        if (isFueled) {
            System.out.println(model + " rides.");
            isFueled = false;
        } else {
            System.out.println(model + " need refuel.");
        }
    }

    public void printModel() {
        System.out.println(model);
    }

    public void refuel() {
        System.out.println(model + " is refueled.");
        isFueled = true;
    }

    public void changeWheel(CarWheelPlacement replacementWheel, Wheel wheel) {
        wheels.put(replacementWheel, wheel);
    }

    public void displayWheelsState() {
        System.out.println(model + " wheels state: ");
        for (Map.Entry<CarWheelPlacement, Wheel> entry : wheels.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return ("Car [model: " + model + ", engine: " + engine + ']');
    }
}