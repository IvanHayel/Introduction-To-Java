package com.epam.introduction.character_arrays.task_5;

/*
 * Remove all extra insertSpaces in the line, that is,
 * replace series of consecutive insertSpaces with single insertSpaces.
 * Remove trailing insertSpaces in the line.
 */

public class Runner {
    public static void main(String[] args) {
        String string = "    Hello,      chars   !!!  !     !";
        System.out.println(string);
        string = transformString(string);
        System.out.println(string);
    }

    private static String transformString(String string) {
        char[] symbols = string.toCharArray();
        int fromSymbol = 0;
        int toSymbol = symbols.length - 1;
        if (symbols[fromSymbol] == ' ') {
            while (symbols[fromSymbol] == ' ') {
                fromSymbol++;
            }
        }
        if (symbols[toSymbol] == ' ') {
            while (symbols[toSymbol] == ' ') {
                toSymbol--;
            }
        }
        StringBuilder newString = new StringBuilder();
        for (int counter = fromSymbol; counter < toSymbol; counter++) {
            if (symbols[counter] == ' ' && symbols[counter + 1] == ' ') {
                newString.append(" ");
                while (symbols[counter] == ' ' && counter < toSymbol) {
                    counter++;
                }
            }
            newString.append(symbols[counter]);
        }
        return newString.toString();
    }
}