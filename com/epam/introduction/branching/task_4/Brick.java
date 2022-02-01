package com.epam.introduction.branching.task_4;

import static java.lang.Math.min;

public class Brick {
    private double x;
    private double y;
    private double z;
    private double minimumFaceArea;

    public Brick(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        minimumFaceArea = getMinimumFaceArea();
    }

    private double getMinimumFaceArea() {
        return min(x * y, min(x * z, y * z));
    }

    public void pushIntoHole(Hole hole) {
        if (isAbleToPassThroughTheHole(hole)) {
            System.out.println("The brick went through the hole.");
        } else {
            System.out.println("Brick can't go through the hole.");
        }
    }

    public boolean isAbleToPassThroughTheHole(Hole hole) {
        return minimumFaceArea < hole.getArea();
    }
}
