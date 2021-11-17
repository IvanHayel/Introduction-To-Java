package linear_programs.task_6;

/*
 * Для заданной области составить программу, которая печатает true,
 * если точка с координатами (x,y) пренадлежит закрашенной области,
 * и false - в противном случае.
 */

import java.awt.*;

import static java.lang.Math.*;

public class Task_6 {
    public static void main(String[] args) {
        Point point = new Point(-2, 1);
        showLocation(point);
    }

    public static void showLocation(Point point) {
        if (isInDesiredArea(point)) {
            System.out.println("Point(" + point.x +
                    "," + point.y +
                    ") is in desired area.");
        } else {
            System.out.println("Point(" + point.x +
                    "," + point.y +
                    ") is not in desired area.");
        }
    }

    public static boolean isInDesiredArea(Point point) {
        if (abs(point.x) <= 4 && point.y >= -3 && point.y <= 0) {
            return true;
        } else {
            return abs(point.y) <= 4 && point.x >= -2 && point.x <= 2;
        }
    }
}