package com.epam.introduction.tasks.task_1.util.menu;

import com.epam.introduction.tasks.task_1.model.book.Book;
import com.epam.introduction.tasks.task_1.model.library.HomeLibrary;
import com.epam.introduction.tasks.task_1.model.user.User;
import com.epam.introduction.tasks.task_1.util.console.ColorConsole;
import com.epam.introduction.tasks.task_1.util.console.ColorType;
import com.epam.introduction.tasks.task_1.util.email.EmailSender;

import java.time.Year;
import java.util.List;
import java.util.Random;

public class MainMenu extends Menu {
    protected static final int DISPLAY_MAX_SIZE = 5;
    protected static final HomeLibrary LIBRARY = HomeLibrary.instance();

    protected static User loggedInUser;

    protected MainMenu() {
    }

    public static void show(User user) {
        loggedInUser = user;
        ColorConsole.display("Main menu:\n", ColorType.PURPLE);
        if (user.isEmailNotSpecified()) {
            ColorConsole.display("!. Specify email address.\n", ColorType.BLUE);
        }
        if (user.isAdmin()) {
            ColorConsole.display("1. Display all books.\n", ColorType.CYAN);
            ColorConsole.display("2. Search book.\n", ColorType.CYAN);
            ColorConsole.display("3. Add book.\n", ColorType.GREEN);
            ColorConsole.display("4. Add book description.\n", ColorType.GREEN);
            ColorConsole.display("Type 'exit' to terminate.\n", ColorType.PURPLE);
            ColorConsole.display("Type 'logout' to log out.\n", ColorType.PURPLE);
            adminSelect();
        } else {
            ColorConsole.display("1. Display all books.\n", ColorType.CYAN);
            ColorConsole.display("2. Search book.\n", ColorType.CYAN);
            ColorConsole.display("3. Suggest book to administrators.\n", ColorType.CYAN);
            ColorConsole.display("Type 'logout' to log out.\n", ColorType.PURPLE);
            ColorConsole.display("Type 'exit' to terminate.\n", ColorType.PURPLE);
            userSelect();
        }
    }

    protected static void adminSelect() {
        String key = enter("key");
        switch (key) {
            case "!" -> {
                if (loggedInUser.isEmailNotSpecified()) {
                    refreshAttempts();
                    String email = enterEmail();
                    if (!email.equals("miss")) {
                        loggedInUser.setEmail(email);
                        updateUser(loggedInUser);
                    }
                    MainMenu.show(loggedInUser);
                }
            }

            case "1" -> {
                refreshAttempts();
                List<Book> books = LIBRARY.getBooks();
                pageDisplay(books);
            }
            case "2" -> {
                refreshAttempts();
                SearchMenu.show();
            }
            case "3" -> {
                refreshAttempts();
                ColorConsole.display("Adding a book has started...\n", ColorType.GREEN);
                Book book = enterBook();
                LIBRARY.addBook(book);
                MainMenu.show(loggedInUser);
            }
            case "4" -> {
                refreshAttempts();
                ColorConsole.display("Adding description started...\n", ColorType.GREEN);
                ColorConsole.display("Enter book identifier:\n", ColorType.PURPLE);
                int bookIdentifier = enterBookIdentifier();
                if (LIBRARY.hasBook(bookIdentifier)) {
                    Book book = LIBRARY.getBook(bookIdentifier);
                    assert book != null;
                    if (book.isDescriptionPresent()) {
                        ColorConsole.display("Book already have description!\n", ColorType.GREEN);
                    } else {
                        ColorConsole.display("Enter description -> ");
                        String description = CONSOLE_INPUT.nextLine().strip();
                        book.setDescription(description);
                        LIBRARY.updateBook(book);
                        sendDescriptionUpdateToAllUsers(book);
                    }
                    MainMenu.show(loggedInUser);
                } else {
                    ColorConsole.display("Adding description failed...\n", ColorType.RED);
                    MainMenu.show(loggedInUser);
                }
            }
            case "logout" -> {
                refreshAttempts();
                StartMenu.show();
            }
            case "exit" -> {
                ColorConsole.display("See you soon!", ColorType.GREEN);
                CONSOLE_INPUT.close();
                System.exit(0);
            }
            default -> {
                if (isAttemptAvailable()) {
                    inputWarning();
                    adminSelect();
                } else {
                    ColorConsole.display("See you soon!", ColorType.GREEN);
                    CONSOLE_INPUT.close();
                    System.exit(0);
                }
            }
        }
    }

    protected static void userSelect() {
        String key = enter("key");
        switch (key) {
            case "!" -> {
                if (loggedInUser.isEmailNotSpecified()) {
                    refreshAttempts();
                    String email = enterEmail();
                    if (!email.equals("miss")) {
                        loggedInUser.setEmail(email);
                        updateUser(loggedInUser);
                    }
                    MainMenu.show(loggedInUser);
                }
            }
            case "1" -> {
                refreshAttempts();
                pageDisplay(LIBRARY.getBooks());
            }
            case "2" -> {
                refreshAttempts();
                SearchMenu.show();
            }
            case "3" -> {
                refreshAttempts();
                ColorConsole.display("Enter the data about the book and we will send\n", ColorType.PURPLE);
                ColorConsole.display("your proposal to all administrators by e-mail.\n", ColorType.PURPLE);
                Book book = enterBook();
                assert book != null;
                sendBookToAllAdministrators(book);
                MainMenu.show(loggedInUser);
            }
            case "logout" -> {
                refreshAttempts();
                StartMenu.show();
            }
            case "exit" -> {
                ColorConsole.display("See you soon!", ColorType.GREEN);
                CONSOLE_INPUT.close();
                System.exit(0);
            }
            case "makemeadmin" -> {
                loggedInUser.grantAdministratorRights();
                updateUser(loggedInUser);
                ColorConsole.display("Congratulations, you are an administrator!\n", ColorType.GREEN);
                MainMenu.show(loggedInUser);
            }
            default -> {
                if (isAttemptAvailable()) {
                    inputWarning();
                    adminSelect();
                } else {
                    ColorConsole.display("See you soon!", ColorType.GREEN);
                    CONSOLE_INPUT.close();
                    System.exit(0);
                }
            }
        }
    }

    protected static String enterEmail() {
        String email = enter("email");
        if (isEmailCorrect(email)) {
            ColorConsole.display("Email successfully added!\n", ColorType.GREEN);
            refreshAttempts();
            return email;
        } else {
            if (isAttemptAvailable()) {
                inputWarning();
                return enterEmail();
            } else {
                refreshAttempts();
                ColorConsole.display("Email wasn't added!\n", ColorType.RED);
                return "miss";
            }
        }
    }

    protected static boolean isEmailCorrect(String email) {
        return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
    }

    private static Book enterBook() {
        try {
            String title = enter("title");
            String authors = enter("authors");
            String publisher = enter("publisher");
            String yearOfPublishing = enter("year of publishing");
            Year year = Year.of(Integer.parseInt(yearOfPublishing));
            String numberOfPages = enter("number of pages");
            int pages = Integer.parseInt(numberOfPages);
            String bookPrice = enter("price");
            int price = Integer.parseInt(bookPrice);
            Book book = new Book(title, authors, publisher, year, pages, price, "miss" + insertSpaces(500));
            ColorConsole.display("Book successfully entered!\n", ColorType.GREEN);
            refreshAttempts();
            return book;
        } catch (Exception e) {
            if (isAttemptAvailable()) {
                inputWarning();
                return enterBook();
            } else {
                refreshAttempts();
                ColorConsole.display("Entering book denied!\n", ColorType.RED);
                MainMenu.show(loggedInUser);
            }
        }
        return null;
    }

    protected static <T> void pageDisplay(List<T> list) {
        ColorConsole.display("List:\n", ColorType.YELLOW);
        int counter = 0;
        while (counter < list.size()) {
            int pageCounter = 0;
            while (pageCounter++ < DISPLAY_MAX_SIZE && counter < list.size()) {
                T item = list.get(counter++);
                ColorConsole.display(counter + ". " + item + "\n");
            }
            if (counter == list.size()) {
                MainMenu.show(loggedInUser);
            }
            ColorConsole.display("Press Enter or type 'next' (another key - move to main menu)\n", ColorType.CYAN);
            String key = enter("key");
            switch (key) {
                case "next", "" -> ColorConsole.display("Next page:\n", ColorType.YELLOW);
                default -> MainMenu.show(loggedInUser);
            }
        }
        MainMenu.show(loggedInUser);
    }

    private static void sendBookToAllAdministrators(Book book) {
        try {
            EmailSender sender = EmailSender.instance();
            ColorConsole.display("Sending messages, wait for it ...\n", ColorType.YELLOW);
            for (User user : users) {
                if (user.isAdmin() && !user.isEmailNotSpecified()) {
                    String adminEmail = user.getEmail();
                    String subject = new Random().nextInt(1000)
                            + " - " + loggedInUser.getLogin() + " book offer from 'Home Library'";
                    StringBuilder message = new StringBuilder();
                    message.append("Good day, dear administrator!\n\n");
                    message.append("Here is book offer from user '");
                    message.append(loggedInUser.getLogin());
                    message.append("'.\n Consider it please.\n\n");
                    message.append(book.getPrettyInfo());
                    message.append("\n See you soon, " + user.getLogin() + " :)");
                    sender.sendTextEmail(adminEmail, subject, message.toString());
                    Thread.sleep(1500); // avoid yandex anti spam
                }
            }
            ColorConsole.display("The book has been successfully sent to administrators!\n", ColorType.GREEN);
        } catch (Exception e) {
            ColorConsole.display("Sending book denied by Yandex anti spam service!\n", ColorType.RED);
        }
    }


    private static int enterBookIdentifier() {
        try {
            String identifier = enter("identifier");
            int id = Integer.parseInt(identifier);
            refreshAttempts();
            return id;
        } catch (Exception e) {
            if (isAttemptAvailable()) {
                inputWarning();
                return enterBookIdentifier();
            } else {
                ColorConsole.display("Entering book identifier denied!\n", ColorType.RED);
                return 0;
            }
        }
    }

    private static void sendDescriptionUpdateToAllUsers(Book book) {
        try {
            EmailSender sender = EmailSender.instance();
            ColorConsole.display("Sending messages, wait for it ...\n", ColorType.YELLOW);
            for (User user : users) {
                if (!user.isAdmin() && !user.isEmailNotSpecified()) {
                    String userEmail = user.getEmail();
                    String subject = new Random().nextInt(1000) +
                            ". Book " + book.getTitle() + " description updated!";
                    StringBuilder message = new StringBuilder();
                    message.append("Good day, dear reader!\n\n");
                    message.append("Here is book description update from administration.\n");
                    message.append("Check it out please.\n\n");
                    message.append(book.getPrettyInfo());
                    message.append("\n See you soon, " + user.getLogin() + " :)");
                    sender.sendTextEmail(userEmail, subject, message.toString());
                    Thread.sleep(1500); // avoid yandex anti spam
                }
            }
            ColorConsole.display("The update has been successfully sent to users!\n", ColorType.GREEN);
        } catch (Exception e) {
            ColorConsole.display("Sending book description update denied by 'Yandex' anti spam service!\n", ColorType.RED);
        }
    }
}