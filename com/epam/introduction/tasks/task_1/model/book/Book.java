package com.epam.introduction.tasks.task_1.model.book;

import java.time.Year;

public class Book {
    private final int BOOK_ID;

    private String title;
    private String authors;
    private String publisher;
    private Year yearOfPublishing;
    private int numberOfPages;
    private int price;
    private String description;

    private static int nextID = 1;

    public Book(String title, String authors, String publisher, Year yearOfPublishing,
                int numberOfPages, int price, String description) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.description = description;
        BOOK_ID = nextID++;
    }

    public int getBookIdentifier() {
        return BOOK_ID;
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

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDescriptionPresent() {
        return !description.strip().equals("miss");
    }

    public String getPrettyInfo() {
        StringBuilder info = new StringBuilder();
        info.append("BOOK INFORMATION\n");
        info.append("Title: " + title + '\n');
        info.append("Authors: " + authors + '\n');
        info.append("Publisher: " + publisher + '\n');
        info.append("Year of publishing: " + yearOfPublishing + '\n');
        info.append("Number of pages: " + numberOfPages + '\n');
        info.append("Price: " + price + '\n');
        info.append("Description: " + description.strip() + '\n');
        return info.toString();
    }

    @Override
    public String toString() {
        return "Book #" + BOOK_ID + " [" +
                "title - '" + title + '\'' +
                ", authors - '" + authors + '\'' +
                ", publisher - '" + publisher + '\'' +
                ", year of publishing - " + yearOfPublishing +
                ", number of pages - " + numberOfPages +
                ", price - " + price +
                ", description: '" + description.strip() + "']";
    }
}