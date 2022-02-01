package com.epam.introduction.tasks.task_1.util.menu;

import com.epam.introduction.tasks.task_1.model.user.User;
import com.epam.introduction.tasks.task_1.util.console.ColorConsole;
import com.epam.introduction.tasks.task_1.util.console.ColorType;
import com.epam.introduction.tasks.task_1.util.encryption.Encoder;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    protected static final Scanner CONSOLE_INPUT = new Scanner(System.in);
    protected static final Path USERS_DATA_PATH = Path.of("src/main/java/tasks/task_1/data/users/users.txt");
    protected static final Encoder ENCODER = Encoder.instance();
    protected static final int MAX_WRONG_INPUT_ATTEMPTS = 3;

    protected static int attempts = MAX_WRONG_INPUT_ATTEMPTS;
    protected static List<User> users;

    protected Menu() {

    }

    protected static boolean isAttemptAvailable() {
        return attempts > 0;
    }

    protected static void refreshAttempts() {
        attempts = MAX_WRONG_INPUT_ATTEMPTS;
    }

    protected static void inputWarning() {
        ColorConsole.display("Wrong input! Attempts left: " + attempts-- + "\n", ColorType.RED);
    }

    protected static void loadUsers() {
        try {
            List<String> usersData = Files.readAllLines(USERS_DATA_PATH);
            users = new ArrayList<>();
            for (String line : usersData) {
                String[] userData = line.split(" ");
                if (userData.length > 3) {
                    users.add(new User(userData[0],
                            ENCODER.decrypt(userData[1]),
                            Boolean.parseBoolean(userData[2]),
                            userData[3]
                    ));
                }
            }
        } catch (IOException e) {
            ColorConsole.display("Can't find data file.\n", ColorType.RED);
            ColorConsole.display("Checkout users data path: " + USERS_DATA_PATH + "\n", ColorType.RED);
        }
    }

    protected static String enter(String item) {
        System.out.print("Enter " + item + " -> ");
        return CONSOLE_INPUT.nextLine().strip();
    }

    protected static String enterLogin() throws IOException {
        String login = enter("login");
        if (isCorrectLogin(login)) {
            refreshAttempts();
            return login;
        } else if (isAttemptAvailable()) {
            inputWarning();
            return enterLogin();
        } else {
            refreshAttempts();
            throw new IOException(login + " can't be login!");
        }
    }

    protected static boolean isCorrectLogin(String login) {
        if (login.isEmpty() || login.isBlank()) {
            return false;
        }
        return login.matches("\\w{3,20}");
    }

    protected static String enterPassword() throws IOException {
        String password = enter("password");
        if (isCorrectPassword(password)) {
            refreshAttempts();
            return password;
        } else if (isAttemptAvailable()) {
            inputWarning();
            return enterPassword();
        } else {
            refreshAttempts();
            throw new IOException(password + " can't be a password!");
        }
    }

    protected static boolean isCorrectPassword(String password) {
        if (password.isEmpty() || password.isBlank()) {
            return false;
        }
        return password.matches("\\w{3,15}");
    }

    protected static void confirmPassword(String password) throws IOException {
        ColorConsole.display("Confirm password:\n", ColorType.PURPLE);
        String confirmPassword = enterPassword();
        if (!confirmPassword.equals(password)) {
            throw new IOException("Password confirmation failed!");
        }
    }

    protected static void updateUser(User user) {
        try (RandomAccessFile file = new RandomAccessFile(USERS_DATA_PATH.toFile(), "rwd")) {
            long currentPosition = file.getFilePointer();
            String login = user.getLogin();
            while (currentPosition != file.length()) {
                currentPosition = file.getFilePointer();
                String line = file.readLine();
                if (line.contains(login)) {
                    file.seek(currentPosition);
                    String userLine = getUserUpdateLine(user);
                    String lineToUpdate = userLine + insertSpaces(line.length() - userLine.length());
                    file.writeBytes(lineToUpdate);
                    break;
                }
            }
        } catch (IOException e) {
            ColorConsole.display("User update denied!\n", ColorType.RED);
        }
    }

    private static String getUserUpdateLine(User user) throws IOException {
        return user.getLogin() + ' ' +
                ENCODER.encrypt(user.getPassword()) + ' ' +
                user.isAdmin() + ' ' +
                user.getEmail();
    }

    protected static String insertSpaces(int quantity) {
        return " ".repeat(Math.max(0, quantity));
    }
}