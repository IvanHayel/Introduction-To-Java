package com.epam.introduction.aggregation_and_composition.task_2;

public enum CarWheelPlacement {
    FRONT_LEFT("front left"),
    FRONT_RIGHT("front right"),
    BACK_LEFT("back left"),
    BACK_RIGHT("back right"),
    SPARE("spare");

    private final String placement;

    CarWheelPlacement(String placement) {
        this.placement = placement;
    }

    @Override
    public String toString() {
        return placement;
    }
}