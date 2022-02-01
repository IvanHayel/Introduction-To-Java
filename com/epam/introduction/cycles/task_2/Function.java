package com.epam.introduction.cycles.task_2;

import java.text.DecimalFormat;
import java.util.ArrayList;

class Function {
    private float a;
    private float b;
    private float step;
    ArrayList<Float> arrayList = new ArrayList<>();

    public Function(float a, float b, float step) {
        this.a = a;
        this.b = b;
        this.step = step;

        fillArrayList();
    }

    private void fillArrayList() {
        float current_step = a;
        while (current_step <= b) {
            float current_value = getFunctionValue(current_step);
            arrayList.add(current_value);
            current_step += step;
        }
    }

    private float getFunctionValue(float x) {
        return x > 2.0f ? x : -x;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Function values in [" + a + "," + b + "] ");
        result.append("with step = " + step + " : ");
        for (Float value : arrayList) {
            String current_value = new DecimalFormat("#0.00").format(value);
            result.append(current_value + " ");
        }
        return result.toString();
    }
}