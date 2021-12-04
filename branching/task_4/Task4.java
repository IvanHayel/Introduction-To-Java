package branching.task_4;

/*
 * The dimensions A, B of the rectangular hole and the dimensions x, y, z of the brick are specified.
 * Determine if the brick will fit through the hole.
 */

public class Task4 {
    public static void main(String[] args) {
        Brick brick = new Brick(250, 120, 65);
        Hole hole = new Hole(200, 200);

        brick.pushIntoHole(hole);
    }
}