package branching.task_5;

/*
 * Вычислить значени функции F(x):
 * = x^2 - 3x + 9, если x <= 3;
 * = 1/(x^3+6), если x > 3
 */

import static java.lang.Math.*;

public class Task_5 {
    public static void main(String[] args) {
        Function f_x = new Function(3.1415926535);
        System.out.println(f_x);

        double result = f_x.getResult();
        System.out.println("Result is " + result);
    }
}

final class Function{
    private double x;
    private double result;

    public Function(double x) {
        this.x = x;
        result = calculateFunctionValue();
    }

    @Override
    public String toString() {
        return "Function{" +
                "x=" + x +
                ", result=" + result +
                '}';
    }

    public double getResult() {
        return result;
    }

    private double calculateFunctionValue(){
        if(x <= 3)
            return pow(x,2)-3*x+9;
        else
            return 1/(pow(x,3)+6);
    }
}