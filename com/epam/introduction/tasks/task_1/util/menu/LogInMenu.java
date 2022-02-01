package com.epam.introduction.tasks.task_1.util.menu;

import com.epam.introduction.tasks.task_1.model.user.User;
import com.epam.introduction.tasks.task_1.util.console.ColorConsole;
import com.epam.introduction.tasks.task_1.util.console.ColorType;

import java.io.IOException;

public final class LogInMenu extends Menu {
    private LogInMenu() {
    }

    static {
        loadUsers();
    }

    public static void show() {
        ColorConsole.display("Loging in has started...\n", ColorType.PURPLE);
        try {
            User user = logIn();
            ColorConsole.display(user.getLogin() + ", you are welcome!\n", ColorType.GREEN);
            MainMenu.show(user);
        } catch (IOException e) {
            ColorConsole.display(e.getMessage() + '\n', ColorType.RED);
            ColorConsole.display("Loging in denied!\n", ColorType.RED);
            StartMenu.show();
        }
    }

    private static User logIn() throws IOException {
        String login = enterLogin();
        String password = enterPassword();
        User currentUser = new User(login, password);
        for (User user : users) {
            if (user.equals(currentUser)) {
                return user;
            }
        }
        throw new IOException("Wrong login or password!");
    }
}