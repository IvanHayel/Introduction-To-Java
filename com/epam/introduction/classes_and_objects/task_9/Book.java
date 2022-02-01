package com.epam.introduction.classes_and_objects.task_9;

import java.time.Year;

public class Book {
    private final int BOOK_ID;

    private String title;
    private String authors;
    private String publisher;
    private Year yearOfPublishing;
    private int numberOfPages;
    private int price;
    private BookBindingType bookBindingType;

    private static int nextID = 1;

    public Book(String title, String authors, String publisher, Year yearOfPublishing,
                int numberOfPages, int price, BookBindingType bookBindingType) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.bookBindingType = bookBindingType;
        BOOK_ID = nextID++;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public Year getYearOfPublishing() {
        return yearOfPublishing;
    }

    @Override
    public String toString() {
        return "Book [" +
                "book id = " + BOOK_ID +
                ", title = '" + title + '\'' +
                ", authors = '" + authors + '\'' +
                ", publisher = '" + publisher + '\'' +
                ", year of publishing = " + yearOfPublishing +
                ", number of pages = " + numberOfPages +
                ", price = " + price +
                ", book binding type = " + bookBindingType.getType() + "]";
    }
}