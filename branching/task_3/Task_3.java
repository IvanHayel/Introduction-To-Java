package branching.task_3;

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
        for (int i = 2; i < points.length; i++) {
            if (!isThreeOnStraightLine(points[0], points[1], points[i]))
                return false;
        }
        return true;
    }

    public static boolean isThreeOnStraightLine(Point... points) {
        if (points.length != 3) return false;
        try{
            if ((points[2].x - points[0].x) / (points[1].x - points[0].x) ==
                    (points[2].y - points[0].y) / (points[1].y - points[0].y)) {
                return true;
            }
        } catch (ArithmeticException division_by_zero){
            return false;
        }
        return false;
    }

    public static Point[] enterPointsFromKeybord(int quantity) {
        Scanner scanner = new Scanner(System.in);
        Point[] points = new Point[quantity];
        int x, y;
        System.out.println("Enter coordinates for " + quantity + " points.");
        for (int i = 0; i < points.length; i++) {
            System.out.print("x" + (i+1) + " = ");
            x = scanner.nextInt();
            System.out.print("y" + (i+1) + " = ");
            y = scanner.nextInt();
            points[i] = new Point(x, y);
        }
        scanner.close();
        return points;
    }
}
