package aggregation_and_composition.task_5;

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