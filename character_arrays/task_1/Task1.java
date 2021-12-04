package character_arrays.task_1;

import java.util.Arrays;

/*
 * Given an array of camelCase variable names.
 * Convert titles to snake_case
 */

public class Task1 {
    public static void main(String[] args) {
        String[] camelCaseNames = {"camelCase", "appKit", "bitLocker", "oneDrive", "pageRank"};
        System.out.println(Arrays.toString(camelCaseNames));
        transformSnakeCase(camelCaseNames);
        System.out.println(Arrays.toString(camelCaseNames));
    }

    private static void transformSnakeCase(String[] camelCaseNames) {
        StringBuilder newName = new StringBuilder();
        for (int counter = 0; counter < camelCaseNames.length; counter++) {
            newName.delete(0, newName.length());
            for (char symbol : camelCaseNames[counter].toCharArray()) {
                if (Character.isUpperCase(symbol)) {
                    newName.append("_");
                    newName.append(Character.toLowerCase(symbol));
                } else {
                    newName.append(symbol);
                }
            }
            camelCaseNames[counter] = newName.toString();
        }
    }
}
