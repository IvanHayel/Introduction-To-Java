package com.epam.introduction.tasks.task_1.util.menu;

import com.epam.introduction.tasks.task_1.util.console.ColorType;
import com.epam.introduction.tasks.task_1.util.console.ColorConsole;

public final class StartMenu extends Menu {
    private StartMenu() {
    }

    public static void show() {
        ColorConsole.display("Welcome to 'Home Library' console application!\n", ColorType.PURPLE);
        ColorConsole.display("1. Sign up.\n", ColorType.CYAN);
        ColorConsole.display("2. Log in.\n", ColorType.CYAN);
        ColorConsole.display("3. Terminate.\n", ColorType.PURPLE);
        selectMenuItem();
    }

    private static void selectMenuItem() {
        String key = enter("key");
        switch (key) {
            case "1" -> {
                refreshAttempts();
                RegistrationMenu.show();
            }
            case "2" -> {
                refreshAttempts();
                LogInMenu.show();
            }
            case "3" -> {
                ColorConsole.display("See you soon!", ColorType.GREEN);
                CONSOLE_INPUT.close();
                System.exit(0);
            }
            default -> {
                if (isAttemptAvailable()) {
                    inputWarning();
                    selectMenuItem();
                } else {
                    ColorConsole.display("See you soon!", ColorType.GREEN);
                    CONSOLE_INPUT.close();
                    System.exit(0);
                }
            }
        }
    }
}