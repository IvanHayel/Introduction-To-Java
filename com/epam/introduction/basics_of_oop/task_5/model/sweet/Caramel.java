package com.epam.introduction.basics_of_oop.task_5.model.sweet;

public class Caramel implements Sweet{
    private static final String CHARACTERISTIC =
            "Caramels are made by cooking sugar and water together.";

    private String name;

    public Caramel() {
        name = "Unknown caramel.";
    }

    public Caramel(String name) {
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