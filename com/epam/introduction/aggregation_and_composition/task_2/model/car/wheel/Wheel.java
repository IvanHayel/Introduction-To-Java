package com.epam.introduction.aggregation_and_composition.task_2.model.car.wheel;

public class Wheel {
    private String brand;

    public Wheel(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Wheel [" +
                "brand = '" + brand + '\'' +
                ']';
    }
}