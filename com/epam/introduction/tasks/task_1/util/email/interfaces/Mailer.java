package com.epam.introduction.tasks.task_1.util.email.interfaces;

public interface Mailer {
    String getHost();
    String getPort();
    String getUsername();
    String getPassword();
    String getEmailAddress();
}
