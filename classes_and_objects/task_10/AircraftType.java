package classes_and_objects.task_10;

public enum AircraftType {
    WIDE_BODY("wide-body"),
    NARROW_BODY("narrow-body"),
    REGIONAL("regional"),
    LOCAL("local"),
    UNKNOWN("unknown");

    private final String TYPE;

    AircraftType(String type) {
        TYPE = type;
    }

    public String getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return TYPE;
    }
}