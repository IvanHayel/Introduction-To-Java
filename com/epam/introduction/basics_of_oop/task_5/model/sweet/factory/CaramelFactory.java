package com.epam.introduction.basics_of_oop.task_5.model.sweet.factory;

import com.epam.introduction.basics_of_oop.task_5.model.sweet.Caramel;
import com.epam.introduction.basics_of_oop.task_5.model.sweet.Sweet;

public class CaramelFactory extends SweetFactory {
    @Override
    public Sweet produce(String name) {
        return new Caramel(name);
    }
}