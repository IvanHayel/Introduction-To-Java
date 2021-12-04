package linear_programs.task_6;

import java.awt.*;

import static java.lang.Math.*;

/*
 * For the given area, compose a program that prints
 * true if the point with coordinates (x, y) belongs to the filled area,
 * and false otherwise. (Picture)
 */

public class Task6 {
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