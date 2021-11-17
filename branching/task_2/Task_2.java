package branching.task_2;

/*
 * Найти max{min(a,b),min(c,d)}.
 */

import static java.lang.Math.*;

public class Task_2 {

    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        int c = 4;
        int d = 1;

        int result = findValueAccordingTask(a, b, c, d);
        System.out.println("Result value: " + result);
    }

    public static int findValueAccordingTask(int... argumentList) {
        if (argumentList.length != 4) return 0;
        return max(min(argumentList[0], argumentList[1]), min(argumentList[2], argumentList[3]));
    }
}
