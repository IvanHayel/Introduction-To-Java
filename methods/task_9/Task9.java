package methods.task_9;

/*
 * Даны X,Y,Z,T длины сторон четырёхугольника.
 * Написать метод(методы) вычисления его площади,
 * если угол между сторонами длиной X и Y - прямой.
 */

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.*;

public class Task9 {
    public static void main(String[] args) {
        double[] quadrilateralSideLengths = new double[4];
        fillWithRandom(quadrilateralSideLengths);
        System.out.println("The lengths of the sides of the quadrilateral:");
        show(quadrilateralSideLengths);
        double quadrilateralArea = getQuadrilateralArea(quadrilateralSideLengths);
        System.out.println("The area of the quadrilateral is " + quadrilateralArea);
    }

    private static void fillWithRandom(double[] array) {
        Random generator = new Random();
        for (int counter = 0; counter < array.length; counter++)
            array[counter] = abs(generator.nextGaussian()) * 10 + 10;
    }

    private static void show(double[] quadrilateralSideLengths) {
        System.out.println(Arrays.toString(quadrilateralSideLengths));
    }

    private static double getQuadrilateralArea(double... quadrilateralLengths) {
        double perimeter = 0;
        for (double sideLength : quadrilateralLengths)
            perimeter += sideLength;
        double semiPerimeter = perimeter / 2;
        double quadrilateralArea = 1;
        for (double sideLength : quadrilateralLengths)
            quadrilateralArea *= semiPerimeter - sideLength;
        return sqrt(quadrilateralArea);
    }
}