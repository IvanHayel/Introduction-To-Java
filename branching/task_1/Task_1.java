package branching.task_1;

public class Task_1 {
    public static void main(String[] args) {
        TriangleAngels triangle = new TriangleAngels(45, 45);
        System.out.println(triangle);
        System.out.println(triangle.isExist());
        System.out.println(triangle.isRight());
    }
}

final class TriangleAngels {
    private double[] anglesInDegrees;
    private double anglesSum = 0;

    private final double SUM_OF_ANGELS_MAX_VALUE = 180.0;

    public TriangleAngels(double firstAngelInDegrees, double secondAngelInDegrees) {
        anglesInDegrees = new double[2];
        anglesInDegrees[0] = firstAngelInDegrees;
        anglesInDegrees[1] = secondAngelInDegrees;

        for (double angle : anglesInDegrees) {
            anglesSum += angle;
        }
    }

    @Override
    public String toString() {
        if (!isExist()) {
            return "The triangle doesn't exist.";
        } else if (!isRight()) {
            return "The triangle exists.";
        } else {
            return "The right triangle exists.";
        }
    }

    public boolean isRight() {
        if (!isExist()) return false;
        return anglesSum == 90;
    }

    public boolean isExist() {
        return !(anglesSum >= SUM_OF_ANGELS_MAX_VALUE);
    }
}