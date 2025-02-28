package org.example.config;

import org.example.storage.repository.postgres.Database;
import org.example.utils.notifications.email.GmailSender;
import org.example.utils.notifications.interfaces.EmailSenderInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    @Bean
    public Database database() throws SQLException {
        return new Database();
    }
    @Bean
    public Connection connection(Database db) throws SQLException {
        return db.getConnection();
    }


    @Bean
    public EmailSenderInterface emailSender() {
        return new GmailSender();
    }



}

