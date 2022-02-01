package com.epam.introduction.aggregation_and_composition.task_2;

public class Engine {
    private String engine;
    private FuelType fuelType;

    public Engine(String engine, FuelType fuelType) {
        this.engine = engine;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return '\'' + engine + '\'' +
                ", fuel type = " + fuelType;
    }
}