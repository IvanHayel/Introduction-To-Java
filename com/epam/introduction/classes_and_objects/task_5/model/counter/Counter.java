package com.epam.introduction.classes_and_objects.task_5.model.counter;

public class Counter {
    private final int MAX_VALUE;
    private final int MIN_VALUE;

    private int counterValue;
    private boolean upperLimit;
    private boolean lowerLimit;

    public Counter() {
        this(1, 9);
    }

    public Counter(int fromValue, int toValue) {
        counterValue = fromValue;
        MAX_VALUE = toValue;
        MIN_VALUE = fromValue;
        upperLimit = false;
        lowerLimit = true;
    }

    public void increase() {
        if (counterValue < MAX_VALUE) {
            counterValue++;
            lowerLimit = false;
        } else {
            upperLimit = true;
        }
    }

    public void decrease() {
        if (counterValue > MIN_VALUE) {
            counterValue--;
            upperLimit = false;
        } else {
            lowerLimit = true;
        }
    }

    public int getCounterValue() {
        return counterValue;
    }

    public boolean isUpperLimit() {
        return upperLimit;
    }

    public boolean isLowerLimit() {
        return lowerLimit;
    }

    public void reset(){
        counterValue = MIN_VALUE;
    }

    @Override
    public String toString() {
        return String.valueOf(getCounterValue());
    }
}