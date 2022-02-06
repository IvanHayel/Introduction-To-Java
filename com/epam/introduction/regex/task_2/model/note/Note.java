package com.epam.introduction.regex.task_2.model.note;

public class Note {
    private final int id;
    private final String to;
    private final String from;
    private final String heading;
    private final String body;

    public Note(int id, String to, String from, String heading, String body) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.heading = heading;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", heading='" + heading + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}