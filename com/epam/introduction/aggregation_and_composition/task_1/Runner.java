package com.epam.introduction.aggregation_and_composition.task_1;

import com.epam.introduction.aggregation_and_composition.task_1.model.sentence.Sentence;
import com.epam.introduction.aggregation_and_composition.task_1.model.text.Text;
import com.epam.introduction.aggregation_and_composition.task_1.model.word.Word;

/**
 * Create an object of the Text class using the Sentence, Word classes.
 * Methods: add text, display text to console, text title.
 */

public class Runner {
    public static void main(String[] args) {
        Sentence firstSentence = new Sentence("The deadliest virus in modern history, perhaps of all time, " +
                "was the 1918 Spanish Flu.");
        Sentence secondSentence = new Sentence("It killed about 20 to 50 million people worldwide, perhaps more.");
        Sentence thirdSentence = new Sentence("The total death toll is unknown " +
                "because medical records were not kept in many areas.");
        Word firstWord = new Word("That's");
        Word secondWord = new Word("all");

        Text pandemicText = new Text();
        pandemicText.append(firstSentence, secondSentence).paragraph();
        pandemicText.append(thirdSentence).paragraph();

        Text endOfText = new Text(firstWord).space().append(secondWord).append('.');
        pandemicText.append(endOfText);

        pandemicText.setHeader("Spanish Flu Pandemic of 1918");

        pandemicText.displayToConsole();
    }
}