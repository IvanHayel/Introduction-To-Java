package basics_of_oop.task_5.model.sweet_factory;

import basics_of_oop.task_5.model.sweet.Chocolate;
import basics_of_oop.task_5.model.sweet.Sweet;

public class ChocolateFactory extends SweetFactory {
    @Override
    public Sweet produce(String name) {
        return new Chocolate(name);
    }
}