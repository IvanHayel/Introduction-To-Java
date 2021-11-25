package methods.task_4;

/*
 * На плоскости заданы своими координатами n точек.
 * Написать метод(методы), определяющие, между какими из пар точек самое большое расстояние.
 * Указание. Координаты точек занести в массив.
 */

import java.awt.Point;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Point[] points = getRandomPoints(10);
        System.out.println("Points:");
        show(points);
        Point[] pointsWithMaxDistance = getPointsWithMaxDistance(points);
        System.out.println("Points with maximum distance:");
        show(pointsWithMaxDistance);
    }

    private static Point[] getRandomPoints(int quantity) {
        Point[] points = new Point[quantity];
        Random generator = new Random();
        int x;
        int y;
        for (int counter = 0; counter < quantity; counter++) {
            x = generator.nextInt(10);
            y = generator.nextInt(10);
            points[counter] = new Point(x, y);
        }
        return points;
    }

    private static void show(Point[] points) {
        int counter = 1;
        for (Point point : points) {
            System.out.println(counter++ + ". Point(" + point.x + "," + point.y + ")");
        }
    }

    private static Point[] getPointsWithMaxDistance(Point[] points) {
        Point[] pointsWithMaxDistance = new Point[2];
        double maxDistance = 0;
        for (int currentPoint = 0; currentPoint < points.length; currentPoint++)
            for (int counter = currentPoint + 1; counter < points.length; counter++) {
                double currentDistance = points[currentPoint].distance(points[counter]);
                if (maxDistance < currentDistance) {
                    maxDistance = currentDistance;
                    pointsWithMaxDistance[0] = points[currentPoint];
                    pointsWithMaxDistance[1] = points[counter];
                }
            }
        return pointsWithMaxDistance;
    }

}
