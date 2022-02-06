package com.epam.introduction.aggregation_and_composition.task_1.model.sentence;

import com.epam.introduction.aggregation_and_composition.task_1.model.text.IText;

import java.util.regex.Pattern;

public class Sentence implements IText {
    private String sentence;

    public Sentence(String sentence) {
        if (isSentence(sentence)) {
            this.sentence = sentence;
        } else {
            throw new IllegalArgumentException('\'' + sentence + "' - this is not a sentence!");
        }
    }

    private boolean isSentence(String sentence) {
        Pattern pattern = Pattern.compile("[\\w|\\s|,|;|:]+[!.?]{0,3}");
        return pattern.matcher(sentence).matches();
    }

    @Override
    public String toString() {
        return sentence;
    }
}