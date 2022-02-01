package com.epam.introduction.tasks.task_2.model.note;

import java.time.LocalDate;

public class Note implements Comparable<Note> {
    private String subject;
    private LocalDate creationDate;
    private String email;
    private String message;

    public Note(String subject, LocalDate creationDate, String email, String message) {
        this.subject = subject;
        this.creationDate = creationDate;
        this.email = email;
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public String getUpdateLine() {
        return subject + " | " +
                creationDate + " | " +
                email + " | " +
                message + '\n';
    }

    public boolean isContainsKeywords(String keywords) {
        keywords = keywords.toLowerCase().strip();
        return subject.toLowerCase().contains(keywords) ||
                creationDate.toString().toLowerCase().contains(keywords) ||
                email.toLowerCase().contains(keywords) ||
                message.toLowerCase().contains(keywords);
    }

    @Override
    public int compareTo(Note note) {
        if (note.creationDate.equals(creationDate)) {
            return 0;
        }
        return creationDate.isBefore(note.creationDate) ? 1 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (!subject.equals(note.subject)) return false;
        if (!creationDate.equals(note.creationDate)) return false;
        if (!email.equals(note.email)) return false;
        return message.equals(note.message);
    }

    @Override
    public int hashCode() {
        int result = subject.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Note {" +
                "subject = '" + subject + '\'' +
                ", creation date = " + creationDate +
                ", email = " + email +
                ", message = '" + message + '\'' +
                '}';
    }
}