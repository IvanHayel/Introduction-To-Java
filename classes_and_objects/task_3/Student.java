package classes_and_objects.task_3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String fullName;
    private String surname;
    private int groupNumber;
    private List<Integer> grades;

    public Student(String fullName, int groupNumber, int[] grades) {
        this.fullName = fullName;
        this.groupNumber = groupNumber;
        this.grades = new ArrayList<>(5);
        for (int grade : grades) {
            this.grades.add(grade);
        }
        this.surname = getSurname();
    }

    private String getSurname() {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(fullName);
        matcher.find();
        return matcher.group();
    }

    public static void showAllStudents(Student[] students) {
        System.out.println("List of students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void showExcellentStudents(Student[] students) {
        System.out.println("List of excellent students:");
        for (Student student : students) {
            if (isExcellent(student)) {
                System.out.println("\tSurname: " + student.surname +
                        "\t\tGroup number: " + student.groupNumber +
                        "\t\tGrades: " + student.grades);
            }
        }
    }

    private static boolean isExcellent(Student student) {
        for (int grade : student.grades) {
            if (grade < 9) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "\tFull name: " + fullName +
                "\t\tGroup number: " + groupNumber +
                "\t\tGrades: " + grades;
    }
}