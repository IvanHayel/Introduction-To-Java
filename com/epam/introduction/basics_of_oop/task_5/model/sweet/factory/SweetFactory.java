package com.epam.introduction.basics_of_oop.task_5.model.sweet.factory;

import com.epam.introduction.basics_of_oop.task_5.model.sweet.Sweet;

abstract public class SweetFactory {
    public abstract Sweet produce(String name);
}