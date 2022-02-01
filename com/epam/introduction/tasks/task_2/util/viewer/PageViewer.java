package com.epam.introduction.tasks.task_2.util.viewer;

import java.util.List;
import java.util.Scanner;

public final class PageViewer {
    private static final int DISPLAY_MAX_SIZE = 5;
    private static final Scanner CONSOLE_INPUT = new Scanner(System.in);

    private PageViewer() {
    }

    public static <T> void pageDisplay(List<T> list) {
        int counter = 0;
        while (counter < list.size()) {
            int pageCounter = 0;
            while (pageCounter++ < DISPLAY_MAX_SIZE && counter < list.size()) {
                T item = list.get(counter++);
                System.out.println(counter + ". " + item);
            }
            if (counter == list.size()) {
                System.out.println("End of list...");
                return;
            }
            System.out.println("Press Enter or type 'next' (another key - end listing)");
            System.out.print("Enter key -> ");
            String choice = CONSOLE_INPUT.nextLine().strip();
            if (choice.equals("next") || choice.equals("")) {
                System.out.println("Next page:");
            } else {
                return;
            }
        }
        System.out.println("End of list...");
    }
}