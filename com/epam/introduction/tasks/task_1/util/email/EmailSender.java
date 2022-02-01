package com.epam.introduction.tasks.task_1.util.email;

import com.epam.introduction.tasks.task_1.util.email.interfaces.Mailer;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

//TODO: For mass mailings, use special services.

public final class EmailSender {
    private static EmailSender instance;

    private final Mailer MAILER;
    private final Properties PROPERTIES;
    private final Session SESSION;

    private EmailSender() throws Exception {
        MAILER = HomeLibraryMailer.instance();
        PROPERTIES = new Properties();
        PROPERTIES.put("mail.smtp.host", MAILER.getHost());
        PROPERTIES.put("mail.smtp.auth", "true");
        PROPERTIES.put("mail.smtp.socketFactory.port", MAILER.getPort());
        PROPERTIES.put("mail.smtp.ssl.enable", "true");
        PROPERTIES.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        PROPERTIES.put("mail.smtp.ssl.checkserveridentity", true);
        SESSION = Session.getDefaultInstance(PROPERTIES,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(MAILER.getUsername(), MAILER.getPassword());
                    }
                });
    }

    public static EmailSender instance() throws Exception {
        if (instance == null) {
            instance = new EmailSender();
        }
        return instance;
    }

    public void sendTextEmail(String toEmail, String subject, String text) throws MessagingException {
        Message message = new MimeMessage(SESSION);
        message.setFrom(new InternetAddress(MAILER.getEmailAddress()));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject(subject);
        message.setText(text);
        Transport.send(message);
    }
}