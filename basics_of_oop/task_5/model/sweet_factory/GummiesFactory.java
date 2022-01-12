package basics_of_oop.task_5.model.sweet_factory;

import basics_of_oop.task_5.model.sweet.Gummies;
import basics_of_oop.task_5.model.sweet.Sweet;

public class GummiesFactory extends SweetFactory{
    @Override
    public Sweet produce(String name) {
        return new Gummies(name);
    }
}