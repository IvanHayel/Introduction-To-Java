package com.epam.introduction.aggregation_and_composition.task_1.model.word;

import com.epam.introduction.aggregation_and_composition.task_1.model.text.IText;

import java.util.regex.Pattern;

public class Word implements IText {
    private String word;

    public Word(String word) {
        if (isWord(word)) {
            this.word = word;
        } else {
            throw new IllegalArgumentException('\'' + word + "' - this is not a word!");
        }
    }

    private boolean isWord(String word) {
        Pattern pattern = Pattern.compile("[A-Za-z-']+");
        return pattern.matcher(word).matches();
    }

    @Override
    public String toString() {
        return word;
    }
}