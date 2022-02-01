package com.epam.introduction.tasks.task_1.util.email;

import com.epam.introduction.tasks.task_1.util.email.interfaces.Mailer;
import com.epam.introduction.tasks.task_1.util.encryption.Encoder;

//TODO: For mass mailings, use special services.

public final class HomeLibraryMailer implements Mailer {
    private static HomeLibraryMailer instance;

    private final Encoder ENCODER;
    private final String HOST;
    private final String PORT;
    private final String USERNAME;
    private final String PASSWORD;
    private final String EMAIL_ADDRESS;

    private HomeLibraryMailer() throws Exception {
        ENCODER = Encoder.instance();
        HOST = "smtp.yandex.ru";
        PORT = "465";
        USERNAME = "h.library@yandex.ru";
        PASSWORD = ENCODER.decrypt("cin9SlKsLosH097SvDEmSg==");
        EMAIL_ADDRESS = "h.library@yandex.ru";
    }

    public static HomeLibraryMailer instance() throws Exception {
        if (instance == null) {
            instance = new HomeLibraryMailer();
        }
        return instance;
    }

    @Override
    public String getHost() {
        return HOST;
    }

    @Override
    public String getPort() {
        return PORT;
    }

    @Override
    public String getUsername() {
        return USERNAME;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public String getEmailAddress() {
        return EMAIL_ADDRESS;
    }
}