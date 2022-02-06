package com.epam.introduction.tasks.task_3.model.client;

import com.epam.introduction.tasks.task_3.model.card.StudentCard;
import com.epam.introduction.tasks.task_3.model.student.Student;

import java.util.Scanner;

public class ClientView {
    private final Scanner CONSOLE_INPUT = new Scanner(System.in);
    private final ClientModel clientModel;

    public ClientView(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public void authenticate() {
        showAuthenticationMenu();
        String key = enter("key");
        takeAuthenticationAction(key);
    }

    private void showAuthenticationMenu() {
        System.out.printf("%n%n%-50s%n", "~~~~~~~~~~~~~~~~~~AUTHENTICATION~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-50s%n", "1. Sign up.");
        System.out.printf("%-50s%n", "2. Sign in.");
        System.out.printf("%-50s%n", "3. Terminate.");
        System.out.printf("%-50s%n", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private String enter(String item) {
        System.out.printf("Enter %s -> ", item);
        return CONSOLE_INPUT.nextLine().strip();
    }

    private void takeAuthenticationAction(String key) {
        switch (key) {
            case "1" -> signUp();
            case "2" -> signIn();
            case "3" -> clientModel.terminate();
            default -> {
                System.out.println("\nWrong input!");
                authenticate();
            }
        }
    }

    private void signUp() {
        String login = enter("login");
        String password = enter("password");
        String confirmPassword = enter("password again");
        if (!password.equals(confirmPassword)) {
            System.out.println("Password mismatch! Try again.");
            signUp();
        }
        boolean isRegistered = clientModel.registerUser(login, password);
        if (isRegistered) {
            System.out.println("\nRegistration successfully ended");
            menu();
        } else {
            System.out.println("\nUser with this login already exist.");
            authenticate();
        }
    }

    private void signIn() {
        String login = enter("login");
        String password = enter("password");
        boolean isLoggedIn = clientModel.loginUser(login, password);
        if (isLoggedIn) {
            System.out.println("\nYou have successfully logged in!");
            menu();
        } else {
            System.out.println("\nWrong password or login!");
            authenticate();
        }
    }

    private void menu() {
        showMainOptions();
        String key = enter("key");
        takeMenuAction(key);
    }

    private void showMainOptions() {
        System.out.printf("%n%n%-50s%n", "~~~~~~~~~~~~~~~~~~~~~~OPTIONS~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-50s%n", "1. Show all student cards.");
        System.out.printf("%-50s%n", "2. Create student card. (administrator only)");
        System.out.printf("%-50s%n", "3. Modify student card. (administrator only)");
        System.out.printf("%-50s%n", "4. Terminate.");
        System.out.printf("%-50s%n", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private void takeMenuAction(String key) {
        switch (key) {
            case "1" -> showAllStudentCards();
            case "2" -> createStudentCard();
            case "3" -> modify();
            case "4" -> clientModel.terminate();
            default -> {
                System.out.println("\nWrong input!");
                menu();
            }
        }
    }

    private void showAllStudentCards() {
        System.out.println("\nAll student cards:");
        clientModel.showAllStudentCards();
        menu();
    }

    private void createStudentCard() {
        System.out.println();
        String surname = enter("student surname");
        String initials = enter("student initials");
        int course = Integer.parseInt(enter("student course"));
        double averageGrade = Double.parseDouble(enter("student average grade"));
        Student student = new Student(surname, initials, course, averageGrade);
        long cardNumber = Long.parseLong(enter("student card number"));
        StudentCard studentCard = new StudentCard(student, cardNumber);
        boolean isCreated = clientModel.addStudentCard(studentCard);
        if (isCreated) {
            System.out.println("\nStudent card added successfully.");
        } else {
            System.out.println("\nYou don't have enough rights to create a card!");
        }
        menu();
    }

    private void modify() {
        System.out.println();
        long cardNumber = Long.parseLong(enter("student card number"));
        showModifyOptions();
        String key = enter("key");
        takeModifyAction(key, cardNumber);
    }

    private void showModifyOptions() {
        System.out.printf("%n%n%-50s%n", "~~~~~~~~~~~~~~~~~~MODIFY OPTIONS~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-50s%n", "1. Modify all.");
        System.out.printf("%-50s%n", "2. Back.");
        System.out.printf("%-50s%n", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private void takeModifyAction(String key, long cardNumber) {
        switch (key) {
            case "1" -> modifyAll(cardNumber);
            case "2" -> menu();
            default -> {
                System.out.println("\nWrong input!");
                modify();
            }
        }
    }

    private void modifyAll(long cardNumber) {
        boolean isCardNumberExist = clientModel.verifyCardNumber(cardNumber);
        if (isCardNumberExist) {
            System.out.println("\nEditing a student card №" + cardNumber);
            String surname = enter("student surname");
            String initials = enter("student initials");
            int course = Integer.parseInt(enter("student course"));
            double averageGrade = Double.parseDouble(enter("student average grade"));
            Student student = new Student(surname, initials, course, averageGrade);
            StudentCard studentCard = new StudentCard(student, cardNumber);
            boolean isModified = clientModel.modifyStudentCard(studentCard);
            if (isModified) {
                System.out.printf("%nCard №%d successfully modified!", cardNumber);
            } else {
                System.out.println("%nYou don't have enough rights to modify cards!");
            }
        } else {
            System.out.printf("%nCard №%d doesn't exist!%n", cardNumber);
        }
        menu();
    }

}