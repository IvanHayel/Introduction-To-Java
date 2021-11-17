package branching.task_5;

/*
 * Вычислить значени функции F(x):
 * = x^2 - 3x + 9, если x <= 3;
 * = 1/(x^3+6), если x > 3
 */

import static java.lang.Math.*;

public class Task_5 {
    public static void main(String[] args) {
        Function function = new Function(3.1415926535);
        System.out.println(function);

        double functionValue = function.getFunctionValue();
        System.out.println("Function value is " + functionValue + ".");
    }
}

final class Function{
    private double x;
    private double functionName;

    public Function(double x) {
        this.x = x;
        functionName = calculateFunctionValue();
    }

    @Override
    public String toString() {
        return "Function{" +
                "x=" + x +
                ", result=" + functionName +
                '}';
    }

    public double getFunctionValue() {
        return functionName;
    }

    private double calculateFunctionValue(){
        if(x <= 3)
            return pow(x,2)-3*x+9;
        else
            return 1/(pow(x,3)+6);
    }
}