package basics_of_oop.task_5.model.sweet_factory;

import basics_of_oop.task_5.model.sweet.Sweet;

abstract public class SweetFactory {
    public abstract Sweet produce(String name);
}