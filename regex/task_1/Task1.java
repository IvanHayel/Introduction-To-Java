package regex.task_1;

import java.util.*;
import java.util.regex.*;

/*
 * Create an application that parses the text (the text is stored in String) and allows you to perform
 * three different operations with the text: sort paragraphs by the number of sentences;
 * sort words by length in each sentence; sort tokens in a sentence in descending order of the number
 * of occurrences of a given character, and in case of equality, alphabetically.
 */

public class Task1 {
    private static final String text = """
                \tShe went wondering back into the house, and laid her son’s saying in her heart.
                Then, going upstairs with her handmaids into her room, she mourned her dear husband till
                Minerva shed sweet sleep over her eyes.
                But the suitors were clamorous throughout the covered cloisters11,
                and prayed each one that he might be her bed fellow.\r
                \tThen Telemachus spoke, “Shameless,” he cried, “and insolent suitors, let us feast at our pleasure now,
                and let there be no brawling, for it is a rare thing to hear a man with such a divine voice as Phemius
                has; but in the morning meet me in full assembly that I may give you formal notice to depart, and feast
                at one another’s houses, turn and turn about, at your own cost.
                If on the other hand you choose to persist in spunging upon one man, heaven help me, but Jove shall
                reckon with you in full, and when you fall in my father’s house there shall be no man to avenge you”.\r
                \tThe suitors bit their lips as they heard him, and marvelled at the boldness of his speech.
                Then, Antinous, son of Eupeithes, said, “The gods seem to have given you lessons in bluster and tall
                talking; may Jove never grant you to be chief in Ithaca as your father was before you”.\r
            """;

    public static void main(String[] args) {
        LIVE:
        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Select the required operation");
            System.out.println("1. Show text.");
            System.out.println("2. Show paragraphs sorted by number of sentences.");
            System.out.println("3. Show words from sentences, sorted by length.");
            System.out.print("""
                    4. Show lexemes from sentences in descending
                    order of the number of occurrences of entered
                    character, and in case of equality - alphabetically.
                    """);
            System.out.println("5. Exit.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Enter the item you want: ");
            int selectedItem = enterItem();
            switch (selectedItem) {
                case 1 -> showText();
                case 2 -> showSortedParagraphs();
                case 3 -> showSortedSentences();
                case 4 -> showSortedLexemes();
                case 5 -> {
                    break LIVE;
                }
            }
        }
    }

    private static int enterItem() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void showText() {
        System.out.println(text);
    }

    private static void showSortedParagraphs() {
        List<String> paragraphs = getParagraphs();
        paragraphs.sort((paragraph, anotherParagraph) -> {
            int countOfSentences = getCountOfSentences(paragraph);
            int anotherCountOfSentences = getCountOfSentences(anotherParagraph);
            return countOfSentences - anotherCountOfSentences;
        });
        for (String paragraph : paragraphs) {
            System.out.println("\t\t" + paragraph.trim());
        }
    }

    private static List<String> getParagraphs() {
        Pattern pattern = Pattern.compile("[^\\r]+");
        Matcher matcher = pattern.matcher(text);
        List<String> paragraphs = new ArrayList<>();
        while (matcher.find()) {
            paragraphs.add(matcher.group());
        }
        return paragraphs;
    }

    private static int getCountOfSentences(String paragraph) {
        Pattern pattern = Pattern.compile("[^.?!]+");
        Matcher matcher = pattern.matcher(paragraph);
        int countOfSentences = 0;
        while (matcher.find()) {
            countOfSentences++;
        }
        return countOfSentences;
    }

    private static void showSortedSentences() {
        List<String> sentences = getSentences();
        List<String> sortedSentences = new LinkedList<>();
        for (String sentence : sentences) {
            List<String> words = getWords(sentence);
            words.sort(Comparator.comparingInt(String::length));
            StringBuilder newSentence = new StringBuilder();
            for (String word : words) {
                newSentence.append(word).append(" ");
            }
            sortedSentences.add(newSentence.toString());
        }
        for (String sentence : sortedSentences) {
            System.out.println(sentence);
        }
    }

    private static List<String> getSentences() {
        List<String> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^.?!]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            sentences.add(matcher.group());
        }
        return sentences;
    }

    private static List<String> getWords(String text) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[^ .?!\";,]+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    private static void showSortedLexemes() {
        System.out.print("Enter character [A-Z or a-z]: ");
        char givenCharacter = enterCharacter();
        List<String> sentences = getSentences();
        List<String> sortedSentences = new LinkedList<>();
        for (String sentence : sentences) {
            List<String> words = getWords(sentence);
            words.sort((word, anotherWord) -> {
                int numberOfOccurrences = getNumberOfOccurrences(word, givenCharacter);
                int anotherNumberOfOccurrences = getNumberOfOccurrences(anotherWord, givenCharacter);
                if (numberOfOccurrences == anotherNumberOfOccurrences) {
                    return word.toLowerCase().compareTo(anotherWord.toLowerCase());
                }
                return anotherNumberOfOccurrences - numberOfOccurrences;
            });
            StringBuilder newSentence = new StringBuilder();
            for (String word : words) {
                newSentence.append(word).append(" ");
            }
            sortedSentences.add(newSentence.toString());
        }
        for (String sentence : sortedSentences) {
            System.out.println(sentence);
        }
    }

    private static char enterCharacter() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.next("[A-Za-z]").charAt(0);
        } catch (InputMismatchException exception) {
            System.out.print("Wrong character, try again: ");
            return enterCharacter();
        }
    }

    private static int getNumberOfOccurrences(String source, char target) {
        int numberOfOccurrences = 0;
        for (char symbol : source.toCharArray()) {
            if (symbol == target) {
                numberOfOccurrences++;
            }
        }
        return numberOfOccurrences;
    }
}