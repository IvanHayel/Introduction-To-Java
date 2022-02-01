package com.epam.introduction.tasks.task_1.util.menu;

import com.epam.introduction.tasks.task_1.model.user.User;
import com.epam.introduction.tasks.task_1.util.console.ColorConsole;
import com.epam.introduction.tasks.task_1.util.console.ColorType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public final class RegistrationMenu extends Menu {
    private RegistrationMenu() {
    }

    static {
        loadUsers();
    }

    public static void show() {
        ColorConsole.display("Registration has started...\n", ColorType.PURPLE);
        try {
            startRegistration();
            ColorConsole.display("Registration successfully ended!\n", ColorType.GREEN);
            StartMenu.show();
        } catch (IOException e) {
            ColorConsole.display(e.getMessage() + "\nRegistration denied!\n", ColorType.RED);
            StartMenu.show();
        }
    }

    private static void startRegistration() throws IOException {
        String login = enterLogin();
        while (isLoginAlreadyExists(login)) {
            ColorConsole.display("User with this login already exist. Try another!\n", ColorType.YELLOW);
            login = enterLogin();
        }
        String password = enterPassword();
        confirmPassword(password);
        register(login, password);
    }

    private static boolean isLoginAlreadyExists(String login) {
        for (User user : users) {
            if (login.equals(user.getLogin())) {
                return true;
            }
        }
        return false;
    }

    private static void register(String login, String password) {
        try {
            Files.writeString(USERS_DATA_PATH, login + " " + ENCODER.encrypt(password) +
                    " false miss" + insertSpaces(50) + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            ColorConsole.display("Can't find data file.\n", ColorType.RED);
            ColorConsole.display("Checkout users.txt data path: " + USERS_DATA_PATH + "\n", ColorType.RED);
        }
    }
}