package com.epam.introduction.string.task_4;

/*
 * Using the copy function and the concatenation operation,
 * form the word “cake” from the parts of the word “cracker”.
 */

public class Task4 {
    public static void main(String[] args) {
        String sourceWord = "cracker";
        System.out.println("Source: " + sourceWord);
        String wordToCreate = String.copyValueOf(sourceWord.toCharArray(), sourceWord.indexOf('c'), 1);
        wordToCreate += String.copyValueOf(sourceWord.toCharArray(), sourceWord.indexOf('a'), 1);
        wordToCreate += String.copyValueOf(sourceWord.toCharArray(), sourceWord.indexOf('k'), 1);
        wordToCreate += String.copyValueOf(sourceWord.toCharArray(), sourceWord.indexOf('e'), 1);
        System.out.println("Created word: " + wordToCreate);
    }
}