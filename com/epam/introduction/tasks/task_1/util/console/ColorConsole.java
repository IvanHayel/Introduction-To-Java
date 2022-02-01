package com.epam.introduction.tasks.task_1.util.console;

public abstract class ColorConsole {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static void display(String message, ColorType color) {
        switch (color) {
            case RED -> System.out.print(ANSI_RED + message + ANSI_RESET);
            case GREEN -> System.out.print(ANSI_GREEN + message + ANSI_RESET);
            case CYAN -> System.out.print(ANSI_CYAN + message + ANSI_RESET);
            case PURPLE -> System.out.print(ANSI_PURPLE + message + ANSI_RESET);
            case BLACK -> System.out.print(ANSI_BLACK + message + ANSI_RESET);
            case YELLOW -> System.out.print(ANSI_YELLOW + message + ANSI_RESET);
            case BLUE -> System.out.print(ANSI_BLUE + message + ANSI_RESET);
            case WHITE -> System.out.print(ANSI_WHITE + message + ANSI_RESET);
            default -> System.out.print(message);
        }
    }

    public static void display(String message) {
        display(message, ColorType.DEFAULT);
    }
}