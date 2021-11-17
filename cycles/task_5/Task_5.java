package cycles.task_5;

/*
 * Даны числовой ряд и некоторое число e. Найти сумму тех членов ряда,
 * модуль которых больше или равен заданному e. Общий член ряда имеет вид:
 * a_n = 1/(2^n) + 1/(3^n).
 */

import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.abs;

public class Task_5 {
    public static void main(String[] args) {
        NumberSeries numberSeries = new NumberSeries(0.314);
        System.out.println(numberSeries);
        numberSeries.showSumOfMembers();
    }
}

final class NumberSeries {
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
        for (Double member_value : members) {
            sum += member_value;
        }
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