package com.epam.introduction.tasks.task_4.model.container;

public class Container {
    private static int nextId = 0;

    private final int ID;

    public Container(){
        ID = ++nextId;
    }

    @Override
    public String toString() {
        return String.format("container #%d",ID);
    }
}