package com.epam.introduction.tasks.task_1;

import com.epam.introduction.tasks.task_1.util.menu.StartMenu;

/*
 * TODO:
 *  1. Refactoring!
 *  2. You can use multithreading to send emails in the background.
 *  3. Yandex SMTP can be replaced with any mailing service (SendGrid, SendingBlue, etc.).
 *  4. Consider limits on email - 50 characters, on book description - 500 characters.
 *  5. Create test's to application.
 */

/*
 * ATTENTION!
 * Type "makemeadmin" in main menu to get admin rights.
 * DO NOT CHANGE users.txt and books.txt !!!
 * Base users:
 * Login: admin Password: admin - administrator
 * Login: user Password: user - user
 */

/**
 * Console application "Accounting for books in an installed library".
 */

public class Runner {
    public static void main(String[] args) {
        StartMenu.show();
    }
}