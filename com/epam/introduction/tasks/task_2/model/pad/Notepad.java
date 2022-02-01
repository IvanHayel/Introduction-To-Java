package com.epam.introduction.tasks.task_2.model.pad;

import com.epam.introduction.tasks.task_2.model.note.Note;
import com.epam.introduction.tasks.task_2.util.viewer.PageViewer;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Notepad {
    private final static Path DATA =
            Paths.get("src/main/java/tasks/task_2/data/notes/notes.txt");

    private static Notepad instance;
    private static List<Note> notes;

    private Notepad() {
        notes = new ArrayList<>();
        loadNotes();
    }

    private void loadNotes() {
        try {
            List<String> lines = Files.readAllLines(DATA);
            for (String line : lines) {
                String[] data = line.split(" \\| ");
                if (data.length == 4) {
                    String subject = data[0];
                    LocalDate creationDate = LocalDate.parse(data[1]);
                    String email = data[2];
                    String message = data[3];
                    notes.add(new Note(subject, creationDate, email, message));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Notepad getInstance() {
        if (instance == null) {
            instance = new Notepad();
        }
        return instance;
    }

    public void update() {
        try {
            Files.delete(DATA);
            Files.createFile(DATA);
            for (Note note : notes) {
                String updateLine = note.getUpdateLine();
                Files.writeString(DATA, updateLine, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayAllNotes() {
        if (!notes.isEmpty()) {
            System.out.println("\nALL NOTES:");
            PageViewer.pageDisplay(notes);
        } else {
            System.out.println("\nNO NOTES...");
        }
    }

    public void displayBySubject(String subject) {
        if (!notes.isEmpty()) {
            System.out.println("\nNotes with subject - " + subject + ":");
            List<Note> notesBySubject = notes
                    .stream()
                    .filter(note -> subject.equals(note.getSubject()))
                    .toList();
            PageViewer.pageDisplay(notesBySubject);
        } else {
            System.out.println("\nNO NOTES...");
        }
    }

    public void displayByCreationDate(LocalDate creationDate) {
        if (!notes.isEmpty()) {
            System.out.println("\nNotes with creation date - " + creationDate + ":");
            List<Note> notesByCreationDate = notes
                    .stream()
                    .filter(note -> creationDate.equals(note.getCreationDate()))
                    .toList();
            PageViewer.pageDisplay(notesByCreationDate);
        } else {
            System.out.println("\nNO NOTES...");
        }
    }

    public void displayByEmail(String email) {
        if (!notes.isEmpty()) {
            System.out.println("\nNotes with email - " + email + ":");
            List<Note> notesByEmail = notes
                    .stream()
                    .filter(note -> email.equals(note.getEmail()))
                    .toList();
            PageViewer.pageDisplay(notesByEmail);
        } else {
            System.out.println("\nNO NOTES...");
        }
    }

    public void displayByMessage(String message) {
        if (!notes.isEmpty()) {
            System.out.println("\nNotes with email - " + message + ":");
            List<Note> notesByMessage = notes
                    .stream()
                    .filter(note -> message.equals(note.getMessage()))
                    .toList();
            PageViewer.pageDisplay(notesByMessage);
        } else {
            System.out.println("\nNO NOTES...");
        }
    }

    public void displayByKeywords(String keywords) {
        if (!notes.isEmpty()) {
            System.out.println("\nNotes with keywords - " + keywords + ":");
            List<Note> notesByKeywords = notes
                    .stream()
                    .filter(note -> note.isContainsKeywords(keywords))
                    .toList();
            PageViewer.pageDisplay(notesByKeywords);
        } else {
            System.out.println("\nNO NOTES...");
        }
    }

    public void displayAllNotesSorted() {
        if (!notes.isEmpty()) {
            System.out.println("\nALL NOTES (SORTED):");
            List<Note> sortedNotes = notes.stream().sorted().toList();
            PageViewer.pageDisplay(sortedNotes);
        } else {
            System.out.println("\nNO NOTES...");
        }
    }

    public void addNote(Note note) {
        notes.add(note);
    }
}