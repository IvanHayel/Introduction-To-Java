package com.epam.introduction.tasks.task_1.model.library;

import com.epam.introduction.tasks.task_1.util.console.ColorConsole;
import com.epam.introduction.tasks.task_1.util.console.ColorType;
import com.epam.introduction.tasks.task_1.model.book.Book;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public final class HomeLibrary {
    private static final Path BOOKS_DATA_PATH = Path.of("src/main/java/tasks/task_1/data/books/books.txt");

    private static HomeLibrary instance;

    private List<Book> books;

    private HomeLibrary() {
        loadBooks();
    }

    private void loadBooks() {
        try {
            List<String> lines = Files.readAllLines(BOOKS_DATA_PATH);
            books = new ArrayList<>();
            for (String line : lines) {
                String[] book = line.split(";");
                if (book.length > 6) {
                    books.add(new Book(book[0], book[1], book[2],
                            Year.of(Integer.parseInt(book[3])),
                            Integer.parseInt(book[4]),
                            Integer.parseInt(book[5]),
                            book[6]
                    ));
                }
            }
        } catch (IOException e) {
            ColorConsole.display("Can't find data file.\n", ColorType.RED);
            ColorConsole.display("Checkout books.txt data path: " + BOOKS_DATA_PATH + "\n", ColorType.RED);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        try {
            String line = getBookLine(book);
            Files.writeString(BOOKS_DATA_PATH, line, StandardOpenOption.APPEND);
            ColorConsole.display("The book was successfully uploaded!\n", ColorType.GREEN);
        } catch (IOException e) {
            ColorConsole.display("The book couldn't be uploaded!\n", ColorType.RED);
        }
    }

    private String getBookLine(Book book) {
        return book.getTitle() + ';' +
                book.getAuthors() + ';' +
                book.getPublisher() + ';' +
                book.getYearOfPublishing() + ';' +
                book.getNumberOfPages() + ';' +
                book.getPrice() + ';' +
                book.getDescription() + '\n';
    }

    public static HomeLibrary instance() {
        if (instance == null) {
            instance = new HomeLibrary();
        }
        return instance;
    }

    public boolean hasBook(int id) {
        for (Book book : books) {
            if (book.getBookIdentifier() == id) {
                return true;
            }
        }
        return false;
    }

    public Book getBook(int id) {
        for (Book book : books) {
            if (book.getBookIdentifier() == id) {
                return book;
            }
        }
        return null;
    }

    public void updateBook(Book book) {
        try (RandomAccessFile file = new RandomAccessFile(BOOKS_DATA_PATH.toFile(), "rwd")) {
            long currentPosition = file.getFilePointer();
            String title = book.getTitle();
            while (currentPosition != file.length()) {
                currentPosition = file.getFilePointer();
                String line = file.readLine();
                if (line.contains(title)) {
                    file.seek(currentPosition);
                    String bookLine = getBookUpdateLine(book);
                    String lineToUpdate = bookLine + insertSpaces(line.length() - bookLine.length()) + '\n';
                    file.writeBytes(lineToUpdate);
                    break;
                }
            }
        } catch (IOException e) {
            ColorConsole.display("Book update denied!\n", ColorType.RED);
        }
    }

    private String getBookUpdateLine(Book book) {
        return getBookLine(book).replaceAll("\n", "");
    }

    private String insertSpaces(int quantity) {
        return " ".repeat(Math.max(0, quantity));
    }
}