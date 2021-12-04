package cycles.task_2;

import java.util.ArrayList;
import java.text.DecimalFormat;

/*
 * Calculate the values of the function on the segment [a, b] with step h y(x)
 * = x, x > 2
 * = -x, x <= 2
 */

public class Task2 {
    public static void main(String[] args) {
        Function y = new Function(1, 3, 0.15f);
        System.out.println(y);
    }
}