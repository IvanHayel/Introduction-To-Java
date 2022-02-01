package com.epam.introduction.basics_of_oop.task_4.resource.model.treasure;

public class Treasure {
    private String name;
    private int cost;

    public Treasure(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + " - " + cost;
    }
}