package com.epam.introduction.tasks.task_2.util.menu;

import com.epam.introduction.tasks.task_2.model.note.Note;
import com.epam.introduction.tasks.task_2.model.pad.Notepad;

import java.time.LocalDate;
import java.util.Scanner;

public final class Menu {
    private static final Scanner CONSOLE_INPUT = new Scanner(System.in);
    private static final Notepad notepad = Notepad.getInstance();
    private static final String DISPLAY_BASE = "%-46s%n";

    private Menu() {
    }

    public static void start() {
        displayMenuOptions();
        String key = enter("key");
        takeMenuAction(key);
    }

    private static void displayMenuOptions() {
        System.out.printf("%n" + DISPLAY_BASE, "~~~~~~~~~~~~~~~~~NOTEPAD MENU~~~~~~~~~~~~~~~~~");
        System.out.printf(DISPLAY_BASE, "1. Display all notes.");
        System.out.printf(DISPLAY_BASE, "2. Search by parameters.");
        System.out.printf(DISPLAY_BASE, "3. Display in sorted order");
        System.out.printf(DISPLAY_BASE, "4. Search by keywords.");
        System.out.printf(DISPLAY_BASE, "5. Add note.");
        System.out.printf(DISPLAY_BASE, "6. Terminate.");
        System.out.printf(DISPLAY_BASE, "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static String enter(String item) {
        System.out.print("Enter " + item + " -> ");
        return CONSOLE_INPUT.nextLine().strip();
    }

    private static void takeMenuAction(String key) {
        switch (key) {
            case "1" -> {
                notepad.displayAllNotes();
                start();
            }
            case "2" -> search();
            case "3" -> {
                notepad.displayAllNotesSorted();
                start();
            }
            case "4" -> {
                String keywords = enter("keywords");
                notepad.displayByKeywords(keywords);
                start();
            }
            case "5" -> {
                System.out.println("\nADDING A NEW NOTE");
                String subject = enter("subject");
                String creationDate = enter("creation date (YYYY-MM-DD)");
                while (!isDateCorrect(creationDate)){
                    System.out.println("Wrong date! Try again...");
                    creationDate = enter("creation date (YYYY-MM-DD)");
                }
                String email = enter("email");
                while(!isEmailCorrect(email)){
                    System.out.println("Wrong email address! Try again...");
                    email = enter("email");
                }
                String message = enter("message");
                notepad.addNote(new Note(subject,LocalDate.parse(creationDate),email,message));
                start();
            }
            case "6" -> {
                notepad.update();
                System.exit(0);
            }
            default -> {
                System.out.println("Wrong input!");
                start();
            }
        }
    }

    private static void search() {
        displaySearchOptions();
        String key = enter("key");
        takeSearchAction(key);
    }

    private static void displaySearchOptions() {
        System.out.printf("%n" + DISPLAY_BASE, "~~~~~~~~~~~~~~~~NOTEPAD SEARCH~~~~~~~~~~~~~~~~");
        System.out.printf(DISPLAY_BASE, "1. Search by subject.");
        System.out.printf(DISPLAY_BASE, "2. Search by creation date.");
        System.out.printf(DISPLAY_BASE, "3. Search by email.");
        System.out.printf(DISPLAY_BASE, "4. Search by message.");
        System.out.printf(DISPLAY_BASE, "5. Back to menu.");
        System.out.printf(DISPLAY_BASE, "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static void takeSearchAction(String key) {
        switch (key) {
            case "1" -> {
                String subject = enter("subject");
                notepad.displayBySubject(subject);
                search();
            }
            case "2" -> {
                String creationDate = enter("creation date (YYYY-MM-DD)");
                while (!isDateCorrect(creationDate)){
                    System.out.println("Wrong date! Try again...");
                    creationDate = enter("creation date (YYYY-MM-DD)");
                }
                notepad.displayByCreationDate(LocalDate.parse(creationDate));
                search();
            }
            case "3" -> {
                String email = enter("email");
                while(!isEmailCorrect(email)){
                    System.out.println("Wrong email address! Try again...");
                    email = enter("email");
                }
                notepad.displayByEmail(email);
                search();
            }
            case "4" -> {
                String message = enter("message");
                notepad.displayByMessage(message);
                search();
            }
            case "5", "" -> start();
            default -> {
                System.out.println("Wrong input!");
                search();
            }
        }
    }

    private static boolean isEmailCorrect(String email) {
        return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
    }

    private static boolean isDateCorrect(String date) {
        return date.matches("\\d{1,4}-(0[0-9]|1[12])-([012][0-9]|3[01])");
    }
}