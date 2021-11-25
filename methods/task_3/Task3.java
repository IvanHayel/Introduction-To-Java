package methods.task_3;

/*
 * Вычислить площадь правильного шестиугольника со стороной a,
 * используя метод вычисления площади треугольника.
 */

import static java.lang.Math.*;

public class Task3 {
    public static void main(String[] args) {
        int regularHexagonSideValue = 3;
        double regularHexagonArea = 6 * getAreaOfEquilateralTriangle(regularHexagonSideValue);
        System.out.println("The area of a regular hexagon is equal to " + regularHexagonArea);
    }

    private static double getAreaOfEquilateralTriangle(int sideValue) {
        return sqrt(3) / 4 * pow(sideValue, 2);
    }
}