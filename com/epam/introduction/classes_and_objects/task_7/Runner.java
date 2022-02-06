package com.epam.introduction.classes_and_objects.task_7;

import com.epam.introduction.classes_and_objects.task_7.model.triangle.Triangle;

import java.awt.geom.Point2D;

/**
 * Describe a class that represents a triangle.
 * Provide methods for creating objects, calculating area, perimeter and median intersection point.
 */

public class Runner {
    public static void main(String[] args) {
        Point2D[] points = new Point2D[3];
        points[0] = new Point2D.Double(5,5);
        points[1] = new Point2D.Double(8,-3);
        points[2] = new Point2D.Double(-4,1);
        Triangle triangle = createTriangle(points);
        triangle.showInfo();
    }

    private static Triangle createTriangle(Point2D[] points) {
        try {
            return new Triangle(points);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new Triangle();
        }
    }
}