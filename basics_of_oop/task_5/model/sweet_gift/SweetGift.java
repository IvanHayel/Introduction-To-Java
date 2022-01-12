package basics_of_oop.task_5.model.sweet_gift;

import basics_of_oop.task_5.model.pack.Pack;
import basics_of_oop.task_5.model.sweet.*;
import basics_of_oop.task_5.model.sweet_factory.*;

public class SweetGift {
    private Sweet sweet;
    private Pack pack;

    public SweetGift(SweetType kindOfSweet, Pack pack) {
        sweet = receive(kindOfSweet);
        this.pack = pack;
    }

    private Sweet receive(SweetType kindOfSweet) {
        return switch (kindOfSweet) {
            case CARAMEL -> new CaramelFactory().produce("Coffee Rio");
            case CHOCOLATE -> new ChocolateFactory().produce("Milky Way");
            case GUMMIES -> new GummiesFactory().produce("Gummi bears");
            default -> new ChocolateFactory().produce("Hershey");
        };
    }

    @Override
    public String toString() {
        return String.format("Gift information:\n%s\n%s\n%s", sweet.getSweetName(), sweet.getCharacteristic(), pack);
    }
}