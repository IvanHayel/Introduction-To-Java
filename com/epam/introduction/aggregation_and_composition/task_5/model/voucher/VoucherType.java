package com.epam.introduction.aggregation_and_composition.task_5.model.voucher;

public enum VoucherType {
    REST("rest"),
    EXCURSION("excursion"),
    TREATMENT("treatment"),
    SHOPPING("shopping"),
    CRUISE("cruise");

    private String type;

    VoucherType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}