package com.epam.introduction.tasks.task_3.model.card;

import com.epam.introduction.tasks.task_3.model.student.Student;
import jakarta.xml.bind.annotation.XmlElement;

import java.io.Serial;
import java.io.Serializable;

public final class StudentCard implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Student student;
    private long cardNumber;

    private StudentCard() {
    }

    public StudentCard(Student student, long cardNumber) {
        this.student = student;
        this.cardNumber = cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    @XmlElement(name = "card-number")
    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCard that = (StudentCard) o;

        if (cardNumber != that.cardNumber) return false;
        return student.equals(that.student);
    }

    @Override
    public int hashCode() {
        int result = student.hashCode();
        result = 31 * result + (int) (cardNumber ^ (cardNumber >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "StudentCard {" +
                "student = " + student +
                ", cardNumber = " + cardNumber +
                '}';
    }
}