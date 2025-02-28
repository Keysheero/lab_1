package org.example.utils.notifications.email;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.example.utils.notifications.interfaces.EmailSenderInterface;

import java.util.Properties;

public class GmailSender implements EmailSenderInterface {
    private static final String USERNAME = "slowdeath654@gmail.com";
    private static final String APP_PASSWORD = "keye gxol txmh clbp";
    public void  sendEmail(String toEmail, String subject, String body) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, APP_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email has been sent to " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
