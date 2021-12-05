package regex.task_2;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notes {
    List<Note> notes;
    public int quantity;

    public Notes(String xml) {
        notes = new LinkedList<>();
        Pattern pattern = Pattern.compile("(\\d+)" +
                "(\\D+<to>)" + "([\\w ]+)" +
                "(\\D+<from>)" + "([\\w ]+)" +
                "(\\D+<heading>)" + "([\\w !]+)" +
                "(\\D+<body>?)" + "([\\w !]*)" +
                "(\\D+)"
        );
        Matcher matcher = pattern.matcher(xml);
        while (matcher.find()) {
            Note note = new Note(
                    Integer.parseInt(matcher.group(1)),
                    matcher.group(3),
                    matcher.group(5),
                    matcher.group(7),
                    matcher.group(9)
            );
            notes.add(note);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Note note : notes) {
            builder.append(note).append("\n");
        }
        return builder.toString();
    }
}