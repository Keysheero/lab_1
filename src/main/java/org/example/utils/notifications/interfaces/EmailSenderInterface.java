package org.example.utils.notifications.interfaces;

public interface EmailSenderInterface {
    void sendEmail(String toEmail, String subject, String body);
}
