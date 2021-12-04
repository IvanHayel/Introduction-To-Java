package linear_programs.task_2;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Expression {
    private double a;
    private double b;
    private double c;

    public Expression(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void showValue() {
        System.out.println("Expression value is " + getExpressionValue());
    }

    @Override
    public String toString() {
        return Double.toString(getExpressionValue());
    }

    public double getExpressionValue() {
        return (b + sqrt(pow(b, 2) + 4 * a * c)) / (2 * a) - pow(a, 3) * c + pow(b, -2);
    }
}