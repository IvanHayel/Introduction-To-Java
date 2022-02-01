package com.epam.introduction.tasks.task_1.util.menu;

import com.epam.introduction.tasks.task_1.model.book.Book;
import com.epam.introduction.tasks.task_1.util.console.ColorConsole;
import com.epam.introduction.tasks.task_1.util.console.ColorType;

import java.util.ArrayList;
import java.util.List;

public final class SearchMenu extends MainMenu {
    private static final List<Book> books = LIBRARY.getBooks();

    private SearchMenu() {
    }

    public static void show() {
        ColorConsole.display("Search menu:\n", ColorType.PURPLE);
        ColorConsole.display("1. Search by author.\n", ColorType.CYAN);
        ColorConsole.display("2. Search by publisher.\n", ColorType.CYAN);
        ColorConsole.display("3. Search by year.\n", ColorType.CYAN);
        ColorConsole.display("4. Search by title.\n", ColorType.CYAN);
        ColorConsole.display("5. back.\n", ColorType.CYAN);
        selectItem();
    }

    private static void selectItem() {
        String key = enter("key");
        switch (key) {
            case "1" -> {
                refreshAttempts();
                String authors = enter("authors");
                authorBasicSearch(authors);
            }
            case "2" -> {
                refreshAttempts();
                String publisher = enter("publisher");
                publisherBasicSearch(publisher);
            }
            case "3" -> {
                refreshAttempts();
                String year = enter("year");
                yearBasicSearch(year);
            }
            case "4" -> {
                refreshAttempts();
                String title = enter("title");
                titleBasicSearch(title);
            }
            case "5" -> {
                show(loggedInUser);
            }
            default -> {
                if (isAttemptAvailable()) {
                    inputWarning();
                    selectItem();
                } else {
                    refreshAttempts();
                    show(loggedInUser);
                }
            }
        }
    }

    private static void authorBasicSearch(String author) {
        ColorConsole.display("Search result:\n", ColorType.GREEN);
        List<Book> booksToDisplay = new ArrayList<>();
        int counter = 1;
        for (Book book : books) {
            if (book.getAuthors().contains(author)) {
                booksToDisplay.add(book);
            }
        }
        pageDisplay(booksToDisplay);
    }

    private static void publisherBasicSearch(String publisher) {
        ColorConsole.display("Search result:\n", ColorType.GREEN);
        List<Book> booksToDisplay = new ArrayList<>();
        int counter = 1;
        for (Book book : books) {
            if (book.getPublisher().contains(publisher)) {
                booksToDisplay.add(book);
            }
        }
        pageDisplay(booksToDisplay);
    }

    private static void yearBasicSearch(String year) {
        ColorConsole.display("Search result:\n", ColorType.GREEN);
        List<Book> booksToDisplay = new ArrayList<>();
        int counter = 1;
        for (Book book : books) {
            if (book.getYearOfPublishing().toString().equals(year)) {
                booksToDisplay.add(book);
            }
        }
        pageDisplay(booksToDisplay);
    }

    private static void titleBasicSearch(String title) {
        ColorConsole.display("Search result:\n", ColorType.GREEN);
        List<Book> booksToDisplay = new ArrayList<>();
        int counter = 1;
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                booksToDisplay.add(book);
            }
        }
        pageDisplay(booksToDisplay);
    }
}