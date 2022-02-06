package com.epam.introduction.branching.task_4;

/*
 * The dimensions A, B of the rectangular hole and the dimensions x, y, z of the brick are specified.
 * Determine if the brick will fit through the hole.
 */

import com.epam.introduction.branching.task_4.model.brick.Brick;
import com.epam.introduction.branching.task_4.model.hole.Hole;

public class Runner {
    public static void main(String[] args) {
        Brick brick = new Brick(250, 120, 65);
        Hole hole = new Hole(200, 200);

        brick.pushIntoHole(hole);
    }
}