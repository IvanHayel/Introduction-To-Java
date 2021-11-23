package cycles.task_2;

/*
 * Вычислить значения функции на отрезке [a,b] c шагом h y(x)
 * = x, x > 2
 * = -x, x <= 2
 */

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Task2 {
    public static void main(String[] args) {
        Function y = new Function(-1, 3, 0.15f);
        System.out.println(y);
    }
}

final class Function {
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Function values in [").append(a).append(",").append(b).append("] ");
        result.append("with step = ").append(step).append(" : ");
        for (Float value : arrayList) {
            String current_value = new DecimalFormat("#0.00").format(value);
            result.append(current_value);
            result.append(" ");
        }
        return result.toString();
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
        return x > 2.0 ? x : -x;
    }
}
