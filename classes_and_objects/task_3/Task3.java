package classes_and_objects.task_3;

import java.util.Random;

/*
 * Create a class named Student containing the following fields:
 * last name and initials, group number, grade (five-element array).
 * Create an array of ten elements of this type.
 * Add the option to display surnames and numbers of groups of students
 * with grades of only 9 or 10.
 */

public class Task3 {
    public static void main(String[] args) {
        int quantityOfStudents = 10;
        Student[] students = generateStudents(quantityOfStudents);
        Student.showAllStudents(students);
        Student.showExcellentStudents(students);
    }

    private static Student[] generateStudents(int quantity) {
        Student[] students = new Student[quantity];
        for (int counter = 0; counter < quantity; counter++) {
            students[counter] = getRandomStudent();
        }
        return students;
    }

    private static Student getRandomStudent() {
        String fullName = getRandomFullName();
        int groupNumber = getRandomGroupNumber();
        int[] grades = getRandomGrades();
        return new Student(fullName, groupNumber, grades);
    }

    private static String getRandomFullName() {
        return getRandomSurname() + " " + getRandomInitials();
    }

    private static String getRandomSurname() {
        Random generator = new Random();
        switch (generator.nextInt(5)) {
            case 1 -> {
                return "Norris";
            }
            case 2 -> {
                return "Smith";
            }
            case 3 -> {
                return "Brown";
            }
            case 4 -> {
                return "Jones";
            }
            default -> {
                return "Wilson";
            }
        }
    }

    private static String getRandomInitials() {
        Random generator = new Random();
        char firstInitial = (char) (generator.nextInt(25) + 65);
        char secondInitial = (char) (generator.nextInt(25) + 65);
        return firstInitial + "." + secondInitial + ".";
    }

    private static int getRandomGroupNumber() {
        Random generator = new Random();
        return generator.nextInt(5) + 1;
    }

    private static int[] getRandomGrades() {
        Random generator = new Random();
        boolean isLucky = generator.nextInt(4) == 1;
        int[] grades = new int[5];
        if (isLucky) {
            for (int counter = 0; counter < grades.length; counter++) {
                grades[counter] = generator.nextInt(2) + 9;
            }
        } else {
            for (int counter = 0; counter < grades.length; counter++) {
                grades[counter] = generator.nextInt(7) + 4;
            }
        }
        return grades;
    }
}