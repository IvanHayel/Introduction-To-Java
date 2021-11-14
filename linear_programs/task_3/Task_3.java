package linear_programs.task_3;

/*
 * Линейные программы.
 * Вычислить выражение по формуле (все переменные принимают действительные значения):
 * (sin(x)+cos(y))/(cos(x)-sin(y))*tg(xy)
 */

import static java.lang.Math.*;

public class Task_3 {
    public static void main(String[] args) {
        Expression e = new Expression(3.1,4.1);
        e.showResult();
        System.out.println(e);
    }
}

final class Expression {
    private double x;
    private double y;

    public Expression(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void showResult() {
        System.out.println("Expression value is " +
                getExpressionValue());
    }

    @Override
    public String toString() {
        return Double.toString(getExpressionValue());
    }

    public double getExpressionValue() {
        return (sin(x) + cos(y)) / (cos(x) - sin(y)) *
                tan(x * y);
    }

}