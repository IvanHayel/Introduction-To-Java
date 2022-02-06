package com.epam.introduction.classes_and_objects.task_9.model.library;

import com.epam.introduction.classes_and_objects.task_9.model.book.Book;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void put(Book book) {
        books.add(book);
    }

    public void printByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthors().contains(author)) {
                System.out.println(book);
            }
        }
    }

    public void printByPublisher(String publisher) {
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                System.out.println(book);
            }
        }
    }

    public void printByYearAfter(Year year) {
        for (Book book : books) {
            if (book.getYearOfPublishing().isAfter(year)) {
                System.out.println(book);
            }
        }
    }
}