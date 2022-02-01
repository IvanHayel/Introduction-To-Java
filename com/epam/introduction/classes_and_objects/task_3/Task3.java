package com.epam.introduction.classes_and_objects.task_3;

import java.util.Arrays;

/*
 * Create a class named Student containing the following fields:
 * last name and initials, group number, grade (five-element array).
 * Create an array of ten elements of this type.
 * Add the option to display surnames and numbers of groups of students
 * with grades of only 9 or 10.
 */

public class Task3 {
    public static void main(String[] args) {
        int studentsQuantity = 10;
        Student[] students = new Student[studentsQuantity];
        for (int counter = 0; counter < studentsQuantity; counter++) {
            students[counter] = Student.getRandomStudent();
        }

        System.out.println("List of students:");
        showStudentList(students);

        System.out.println("List of excellent students:");
        showExcellentStudents(students);
    }

    private static void showStudentList(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void showExcellentStudents(Student[] students) {
        Arrays.stream(students).filter(student -> {
            int[] grades = student.getGrades();
            for (int grade : grades) {
                if (grade < 9) {
                    return false;
                }
            }
            return true;
        }).forEach(System.out::println);
    }
}