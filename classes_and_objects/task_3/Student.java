package classes_and_objects.task_3;

import java.util.Arrays;
import java.util.Random;

public class Student {
    private String surname;
    private String initials;
    private int groupNumber;
    private int[] grades;

    public Student(String surname, String initials, int groupNumber, int[] grades) {
        this.surname = surname;
        this.initials = initials;
        this.groupNumber = groupNumber;
        this.grades = grades.clone();
    }

    public int[] getGrades() {
        return grades.clone();
    }

    @Override
    public String toString() {
        return "Student " + surname + " " + initials + ", group number = " + groupNumber + ", grades = " + Arrays.toString(grades);
    }

    public static Student getRandomStudent() {
        return new Student(getRandomSurname(), getRandomInitials(), getRandomGroupNumber(), getRandomGrades());
    }

    private static String getRandomSurname() {
        Random generator = new Random();
        return switch (generator.nextInt(10)) {
            case 1 -> "Smith";
            case 2 -> "Jones";
            case 3 -> "Taylor";
            case 4 -> "Brown";
            case 5 -> "Williams";
            case 6 -> "Wilson";
            case 7 -> "Johnson";
            case 8 -> "Davies";
            case 9 -> "Abrams";
            default -> "Chapel";
        };
    }

    private static String getRandomInitials() {
        Random generator = new Random();
        return String.valueOf((char) (generator.nextInt(25) + 66)) + '.' +
                (char) (generator.nextInt(25) + 66) + '.';
    }

    private static int getRandomGroupNumber() {
        Random generator = new Random();
        return generator.nextInt(20) + 1;
    }

    public static int[] getRandomGrades() {
        Random generator = new Random();
        int[] grades = new int[5];
        boolean isLucky = generator.nextBoolean() && generator.nextBoolean();
        for (int counter = 0; counter < 5; counter++) {
            if (isLucky) {
                grades[counter] = generator.nextInt(2) + 9;
            } else {
                grades[counter] = generator.nextInt(7) + 4;
            }
        }
        return grades;
    }
}