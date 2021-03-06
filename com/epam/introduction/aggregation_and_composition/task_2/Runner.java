package com.epam.introduction.aggregation_and_composition.task_2;

import com.epam.introduction.aggregation_and_composition.task_2.model.car.Car;
import com.epam.introduction.aggregation_and_composition.task_2.model.car.engine.Engine;
import com.epam.introduction.aggregation_and_composition.task_2.model.car.fuel.FuelType;
import com.epam.introduction.aggregation_and_composition.task_2.model.car.wheel.CarWheelPlacement;
import com.epam.introduction.aggregation_and_composition.task_2.model.car.wheel.Wheel;

/**
 * Create an object of the Car class using the Wheel and Engine classes.
 * Methods: driving, refueling, changing a wheel, displaying model of the car.
 */

public class Runner {
    public static void main(String[] args) {
        Engine firstEngine = new Engine("J32", FuelType.HYBRID);
        Engine secondEngine = new Engine("Tesla", FuelType.ELECTRICITY);

        Car honda = new Car("Honda", firstEngine, new Wheel("Michelin"));
        Car tesla = new Car("Tesla", secondEngine);
        Car toyota = new Car("Toyota");

        honda.printModel();
        System.out.println(honda);
        System.out.println();

        tesla.displayWheelsState();
        tesla.changeWheel(CarWheelPlacement.BACK_LEFT, new Wheel("Goodyear"));
        tesla.changeWheel(CarWheelPlacement.BACK_RIGHT, new Wheel("Goodyear"));
        tesla.displayWheelsState();
        System.out.println();

        toyota.ride();
        toyota.refuel();
        toyota.ride();
    }
}