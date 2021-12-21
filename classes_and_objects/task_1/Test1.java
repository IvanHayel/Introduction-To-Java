package classes_and_objects.task_1;

public class Test1 {
    private double first;
    private double second;

    public Test1(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public void printFirst() {
        System.out.println("First value: " + first);
    }

    public void printSecond() {
        System.out.println("Second value: " + second);
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public double getSum() {
        return first + second;
    }

    public double getMax() {
        return Math.max(first, second);
    }
}