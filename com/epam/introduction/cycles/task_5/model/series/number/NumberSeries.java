package com.epam.introduction.cycles.task_5.model.series.number;

import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class NumberSeries {
    private final double epsilon;
    private ArrayList<Double> members;

    public NumberSeries(double epsilon) {
        this.epsilon = epsilon;
        fillMembers();
    }

    private void fillMembers() {
        members = new ArrayList<>();
        for (int n = 0; abs(getMemberValue(n)) >= epsilon; n++) {
            double member = getMemberValue(n);
            members.add(member);
        }
    }

    private double getMemberValue(int n) {
        return pow(2, -n) + pow(3, -n);
    }

    public void showSumOfMembers() {
        double sum = 0;
        for (Double member_value : members)
            sum += member_value;
        System.out.print("Sum of members (epsilon " + epsilon + ") = ");
        System.out.println(sum);
    }

    @Override
    public String toString() {
        return "NumberSeries{" +
                "epsilon=" + epsilon +
                ", members=" + members +
                '}';
    }
}
