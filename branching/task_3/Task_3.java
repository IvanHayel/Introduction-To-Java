package branching.task_3;

/*
 * Даны три точки A(x1,y1), B(x2,y2), C(x3,y3).
 * Определить, будут ли они расположены на одной прямой.
 */

import java.awt.*;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Point[] points = enterPointsFromKeybord(3);
        showPointsInfo(points);
    }

    public static void showPointsInfo(Point[] points) {
        for (Point point : points) {
            System.out.print("P(" + point.x + "," + point.y + ") ");
        }
        if (isOnStraightLine(points)) {
            System.out.println("this points are on the same line.");
        } else {
            System.out.println("this points are not on the same line.");
        }
    }

    public static boolean isOnStraightLine(Point[] points) {
        if (points.length <= 2) return true;
        for (int counter = 2; counter < points.length; counter++)
            if (!isThreeOnStraightLine(points[0], points[1], points[counter]))
                return false;
        return true;
    }

    public static boolean isThreeOnStraightLine(Point... points) {
        if (points.length != 3) return false;
        try {
            if ((points[2].x - points[0].x) / (points[1].x - points[0].x) ==
                    (points[2].y - points[0].y) / (points[1].y - points[0].y))
                return true;
        } catch (ArithmeticException divisionByZero) {
            return false;
        }
        return false;
    }

    public static Point[] enterPointsFromKeybord(int quantity) {
        Scanner scanner = new Scanner(System.in);
        Point[] points = new Point[quantity];
        int x, y;
        System.out.println("Enter coordinates for " + quantity + " points.");
        for (int counter = 0; counter < points.length; counter++) {
            System.out.print("x" + (counter + 1) + " = ");
            x = scanner.nextInt();
            System.out.print("y" + (counter + 1) + " = ");
            y = scanner.nextInt();
            points[counter] = new Point(x, y);
        }
        scanner.close();
        return points;
    }
}
