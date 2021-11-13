package linear_programs.task_1;

public class Task_1 {
    public static void main(String... args) {
        FunctionZ z = new FunctionZ(3.1, 4.1, 5.9);
        z.showResult();
        System.out.println(z);
    }
}

final class FunctionZ {
    private double a;
    private double b;
    private double c;

    public FunctionZ(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void showResult() {
        System.out.println("z = " + getFunctionValue());
}

    @Override
    public String toString() {
        return "((" + a + " - 3) * " +
                b + " / 2) + " + c +
                " = " + getFunctionValue();
    }

    public double getFunctionValue() {
        return ((a - 3) * b / 2) + c;
    }

}