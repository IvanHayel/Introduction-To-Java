package aggregation_and_composition.task_1;

import java.util.Locale;

public class Text implements IText {
    private StringBuilder text = new StringBuilder();
    private String header;

    public Text(String text) {
        this.text.append(text);
        header = "DEFAULT HEADER";
    }

    public Text() {
        this("");
    }

    public Text(IText... texts) {
        for (IText text : texts) {
            this.text.append(text);
        }
        header = "DEFAULT HEADER";
    }

    public Text append(String text) {
        this.text.append(text);
        return this;
    }

    public Text append(IText... texts) {
        for (IText text : texts) {
            this.text.append(text.toString());
        }
        return this;
    }

    public Text append(char character) {
        text.append(character);
        return this;
    }

    public Text space() {
        text.append(" ");
        return this;
    }

    public Text paragraph() {
        text.append("\n");
        return this;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void displayToConsole() {
        System.out.println(header.toUpperCase(Locale.ROOT));
        System.out.println(text);
    }

    @Override
    public String toString() {
        return text.toString();
    }
}