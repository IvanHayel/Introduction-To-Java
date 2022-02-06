package com.epam.introduction.classes_and_objects.task_9;

import com.epam.introduction.classes_and_objects.task_9.model.book.Book;
import com.epam.introduction.classes_and_objects.task_9.model.book.BookBindingType;
import com.epam.introduction.classes_and_objects.task_9.model.library.Library;

import java.time.Year;

/**
 * Create a Book class, the specification of which is given below. Define constructors, set- and get- methods, and
 * toString () method. Create a second class that aggregates an array of type Book with appropriate constructors and
 * methods. Set the criteria for selecting data and display this data on the console.
 * Book: id, title, author (s), publisher, year of publication, number of pages, price, type of binding.
 * Find and print:
 * a) a list of books by a given author;
 * b) a list of books published by a given publisher;
 * c) a list of books released after a given year.
 */

public class Runner {
    public static void main(String[] args) {
        Book firstBook = new Book(
                "Compilers: Principles, Techniques, and Tools",
                "Alfred V. Aho, Monica S. Lam, Ravi Sethi, Jeffrey D. Ullman",
                "Pearson Education, Inc",
                Year.of(1986),
                1184,
                150,
                BookBindingType.HARDCOVER

        );
        Book secondBook = new Book(
                "Clean Code",
                "Robert C. Martin",
                "Prentice Hall",
                Year.of(2021),
                464,
                30,
                BookBindingType.PUR
        );
        Book thirdBook = new Book(
                "Grokking Algorithms",
                "Aditya Bhargava",
                "Manning Publications Co.",
                Year.of(2022),
                288,
                25,
                BookBindingType.PUR
        );

        Library library = new Library();
        library.put(firstBook);
        library.put(secondBook);
        library.put(thirdBook);

        System.out.println("Books by author Lam:");
        library.printByAuthor("Lam");

        System.out.println("Books published after 2010:");
        library.printByYearAfter(Year.of(2010));

        System.out.println("Books published by Manning Publications Co.:");
        library.printByPublisher("Manning Publications Co.");
    }
}