package com.epam.introduction.classes_and_objects.task_7.model.triangle;

import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.util.Arrays;

import static java.lang.Math.*;

public class Triangle {
    private static final int SUM_OF_ANGELS = 180;

    private Point2D[] vertices = new Point2D[3];
    private double[] sides = new double[3];
    private double[] angles = new double[3];
    private double area;
    private double perimeter;
    private Point2D[] medianVertices = new Point2D[3];
    private Point2D medianIntersection;
    private int precision = 2;
    private double precisionFactor = pow(10, precision);
    private boolean isCreated;

    public Triangle() {
        isCreated = false;
    }

    public Triangle(Point2D[] vertices) throws Exception {
        if (vertices.length != 3) {
            throw new Exception("Wrong count of vertices!");
        }
        this.vertices = vertices.clone();
        calculateSidesFromVertices();
        calculateAngelsFromSides();
        calculateArea();
        calculatePerimeter();
        if (!isTriangleExist()) {
            throw new Exception("Triangle doesn't exist!");
        }
        calculateMedianVertices();
        calculateMedianIntersection();
        isCreated = true;
    }

    private void calculateSidesFromVertices() {
        sides[0] = vertices[0].distance(vertices[1]);
        sides[1] = vertices[1].distance(vertices[2]);
        sides[2] = vertices[2].distance(vertices[0]);
    }

    private void calculateAngelsFromSides() {
        angles[0] = calculateAngelFromSides(sides[0], sides[1], sides[2]);
        angles[1] = calculateAngelFromSides(sides[1], sides[0], sides[2]);
        angles[2] = calculateAngelFromSides(sides[2], sides[0], sides[1]);
    }

    private double calculateAngelFromSides(double oppositeSide, double firstAdjoinSide, double secondAdjoinSide) {
        return round(acos((pow(firstAdjoinSide, 2) + pow(secondAdjoinSide, 2) - pow(oppositeSide, 2))
                / (2 * firstAdjoinSide * secondAdjoinSide)) * 180 / PI * precisionFactor) / precisionFactor;
    }

    private void calculateArea() {
        area = 0.5 * sin(angles[0] / 180 * PI) * sides[1] * sides[2];
        area = round(area * precisionFactor) / precisionFactor;
    }

    private void calculatePerimeter() {
        for (double side : sides) {
            perimeter += side;
        }
        perimeter = round(perimeter * precisionFactor) / precisionFactor;
    }

    private void calculateMedianVertices() {
        medianVertices[0] = new Point2D.Double(
                (vertices[1].getX() + vertices[2].getX()) * 0.5,
                (vertices[1].getY() + vertices[2].getY()) * 0.5
        );
        medianVertices[1] = new Point2D.Double(
                (vertices[0].getX() + vertices[2].getX()) * 0.5,
                (vertices[0].getY() + vertices[2].getY()) * 0.5
        );
        medianVertices[2] = new Point2D.Double(
                (vertices[0].getX() + vertices[1].getX()) * 0.5,
                (vertices[0].getY() + vertices[1].getY()) * 0.5
        );
    }

    private void calculateMedianIntersection() {
        double canonicalEquationConstant = calculateCanonicalEquationConstant();
        medianIntersection = new Point2D.Double(
                vertices[0].getX() + (medianVertices[0].getX() - vertices[0].getX()) * canonicalEquationConstant,
                vertices[0].getY() + (medianVertices[0].getY() - vertices[0].getY()) * canonicalEquationConstant
        );
    }

    private double calculateCanonicalEquationConstant() {
        return
                ((vertices[0].getX() - vertices[1].getX())
                        * (medianVertices[1].getY() - vertices[1].getY())
                        - (medianVertices[1].getX() - vertices[1].getX())
                        * (vertices[0].getY() - vertices[1].getY())) /
                        ((medianVertices[1].getX() - vertices[1].getX())
                                * (medianVertices[0].getY() - vertices[0].getY())
                                - (medianVertices[0].getX() - vertices[0].getX())
                                * (medianVertices[1].getY() - vertices[1].getY()));
    }

    private boolean isTriangleExist() {
        return isSidesCorrect() && isAngelsCorrect() && area > 0 && perimeter > 0;
    }

    private boolean isSidesCorrect() {
        for (int current = 0; current < 3; current++) {
            int sum = 0;
            for (int counter = 0; counter < 3; counter++) {
                if (counter != current) {
                    sum += sides[counter];
                }
            }
            if (sides[current] > sum) {
                return false;
            }
        }
        return true;
    }

    private boolean isAngelsCorrect() {
        int sumOfAngels = 0;
        for (double angle : angles) {
            sumOfAngels += angle;
        }
        return sumOfAngels <= SUM_OF_ANGELS;
    }

    public void showInfo() {
        if (!isCreated) {
            return;
        }
        System.out.println("TRIANGLE INFO");
        System.out.print("Vertices: ");
        for (Point2D point : vertices) {
            System.out.print(convertPointToString(point) + " ");
        }
        System.out.println("\nSide lengths: " + Arrays.toString(sides));
        System.out.println("Angles: " + Arrays.toString(angles));
        System.out.println("Area of triangle: " + area);
        System.out.println("Perimeter of triangle: " + perimeter);
        System.out.println("Median intersection point: " + convertPointToString(medianIntersection));
        System.out.println("Precision: " + precision);
    }

    private String convertPointToString(Point2D point2D) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return "[" + decimalFormat.format(point2D.getX()) + "," + decimalFormat.format(point2D.getY()) + "]";
    }
}