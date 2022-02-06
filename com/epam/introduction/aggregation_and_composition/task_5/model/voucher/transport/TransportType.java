package com.epam.introduction.aggregation_and_composition.task_5.model.voucher.transport;

public enum TransportType {
    WATER("water"),
    AIR("air"),
    LAND("land"),
    INDIVIDUAL("individual");

    private String type;

    TransportType(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}