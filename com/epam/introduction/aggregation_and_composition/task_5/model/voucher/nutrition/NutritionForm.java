package com.epam.introduction.aggregation_and_composition.task_5.model.voucher.nutrition;

public enum NutritionForm {
    RO("room only"),
    EP("european plan"),
    BB("bed & breakfast"),
    HB("half board"),
    FB("full board"),
    AL("all inclusive");

    private String form;

    NutritionForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return form;
    }
}