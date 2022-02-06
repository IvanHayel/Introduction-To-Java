package com.epam.introduction.tasks.task_3.model.student;

import jakarta.xml.bind.annotation.XmlElement;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String surname;
    private String initials;
    private int course;
    private double averageGrade;

    private Student() {
    }

    public Student(String surname, String initials, int course, double averageGrade) {
        this.surname = surname;
        this.initials = initials;
        this.course = course;
        this.averageGrade = averageGrade;
        assert this.surname != null;
        assert this.initials != null;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @XmlElement(name = "average-grade")
    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getSurname() {
        return surname;
    }

    public String getInitials() {
        return initials;
    }

    public int getCourse() {
        return course;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (course != student.course) return false;
        if (Double.compare(student.averageGrade, averageGrade) != 0) return false;
        if (!surname.equals(student.surname)) return false;
        return initials.equals(student.initials);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = surname.hashCode();
        result = 31 * result + initials.hashCode();
        result = 31 * result + course;
        temp = Double.doubleToLongBits(averageGrade);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Student {" +
                "surname = '" + surname + '\'' +
                ", initials = '" + initials + '\'' +
                ", course = " + course +
                ", averageGrade = " + String.format("%.2f", averageGrade) +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        if (student.averageGrade == averageGrade) {
            return 0;
        }
        return student.averageGrade > averageGrade ? 1 : -1;
    }
}