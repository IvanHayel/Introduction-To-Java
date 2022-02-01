package com.epam.introduction.basics_of_oop.task_5.model.sweet;

public class Gummies implements Sweet {
    private static final String CHARACTERISTIC =
            "Gummies are gelatin based chewy candies that come in a variety of shapes, colors and flavors.";

    private String name;

    public Gummies() {
        name = "Unknown gummies.";
    }

    public Gummies(String name) {
        this.name = name;
    }

    @Override
    public String getSweetName() {
        return name;
    }

    @Override
    public String getCharacteristic() {
        return CHARACTERISTIC;
    }
}