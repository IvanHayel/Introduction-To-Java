package basics_of_oop.task_5.model.pack;

public enum PackColor {
    RED("red"),
    WHITE("white"),
    BLACK("black"),
    RAINBOW("rainbow"),
    CUSTOM("custom");

    private final String color;

    PackColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}