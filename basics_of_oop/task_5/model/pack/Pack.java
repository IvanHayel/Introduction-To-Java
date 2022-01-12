package basics_of_oop.task_5.model.pack;

public class Pack {
    private PackSize size;
    private PackColor color;

    public Pack(PackSize size, PackColor color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Pack size - %s, color - %s.", size, color);
    }
}