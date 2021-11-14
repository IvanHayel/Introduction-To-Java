package branching.task_4;

/*
 * Заданы размеры A, B прямоугольного отверстия и размеры x,y,z кирпича.
 * Определить, пройдёт ли кирпич через отверстие.
 */

import static java.lang.Math.*;

public class Task_4 {
    public static void main(String[] args) {
        Brick brick = new Brick(250, 120, 65);
        Hole hole = new Hole(200, 200);

        brick.pushIntoHole(hole);
    }
}

final class Brick {
    private double x;
    private double y;
    private double z;
    private double minimumFaceArea;

    public Brick(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        minimumFaceArea = findMinimumFaceArea();
    }

    private double findMinimumFaceArea() {
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

final class Hole {
    private double a;
    private double b;
    private double area;

    public Hole(double a, double b) {
        this.a = a;
        this.b = b;
        area = a * b;
    }

    public double getArea() {
        return area;
    }
}