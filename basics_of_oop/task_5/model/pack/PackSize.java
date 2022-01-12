package basics_of_oop.task_5.model.pack;

public enum PackSize {
    XS("extra small"),
    S("small"),
    M("medium"),
    L("large"),
    XL("extra large");

    private final String size;

    PackSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size;
    }
}