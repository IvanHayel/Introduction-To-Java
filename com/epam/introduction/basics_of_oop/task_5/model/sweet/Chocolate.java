package com.epam.introduction.basics_of_oop.task_5.model.sweet;

public class Chocolate implements Sweet {
    private static final String CHARACTERISTIC =
            "Chocolate is a food product made from roasted and ground cacao pods.";

    private String name;

    public Chocolate() {
        name = "Unknown chocolate.";
    }

    public Chocolate(String name) {
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