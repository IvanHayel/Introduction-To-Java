package com.epam.introduction.tasks.task_4.model.ship.type;

public enum ShipType {
    SMALL(5),
    MEDIUM(10),
    LARGE(20),
    MONSTER(50);

    private final int capacity;

    ShipType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}