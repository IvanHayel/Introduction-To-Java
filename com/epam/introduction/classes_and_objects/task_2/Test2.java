package com.epam.introduction.classes_and_objects.task_2;

public class Test2 {
    private byte first;
    private byte second;

    public Test2(byte first, byte second) {
        this.first = first;
        this.second = second;
    }

    public Test2() {
        this(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    public byte getFirst() {
        return first;
    }

    public void setFirst(byte first) {
        this.first = first;
    }

    public byte getSecond() {
        return second;
    }

    public void setSecond(byte second) {
        this.second = second;
    }
}