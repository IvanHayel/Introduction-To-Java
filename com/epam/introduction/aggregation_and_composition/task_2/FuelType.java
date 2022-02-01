package com.epam.introduction.aggregation_and_composition.task_2;

public enum FuelType {
    PETROL("petrol"),
    DIESEL("diesel"),
    GAS("gas"),
    ELECTRICITY("electricity"),
    HYBRID("hybrid");

    private final String type;

    FuelType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}