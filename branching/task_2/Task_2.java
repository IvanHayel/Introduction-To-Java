package branching.task_2;

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

    public static int findValueAccordingTask(int... args) {
        if (args.length != 4) return 0;
        return max(min(args[0], args[1]), min(args[2], args[3]));
    }
}
