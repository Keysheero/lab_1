package org.example.config;

import org.example.services.interfaces.ItemServiceInterface;
import org.example.services.interfaces.UserServiceInterface;
import org.example.services.items.ItemService;
import org.example.services.users.UserService;
import org.example.storage.repository.interfaces.ItemRepositoryInterface;
import org.example.storage.repository.interfaces.UserRepositoryInterface;
import org.example.storage.repository.postgres.Database;
import org.example.storage.repository.postgres.item.ItemRepository;
import org.example.storage.repository.postgres.user.UserRepository;
import org.example.utils.notifications.email.GmailSender;
import org.example.utils.notifications.interfaces.EmailSenderInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    @Bean
    public Database database() throws SQLException {
        return new Database();
    }

    @Bean
    public UserRepositoryInterface userRepository(Database db) throws SQLException {
        return new UserRepository(db.getConnection());
    }

    @Bean
    public ItemRepositoryInterface itemRepository(Database db) throws SQLException {
        return new ItemRepository(db.getConnection());
    }

    @Bean
    public EmailSenderInterface emailSender() {
        return new GmailSender();
    }

    @Bean
    public ItemServiceInterface itemService(ItemRepositoryInterface itemRepo) {
        return new ItemService(itemRepo);
    }

    @Bean
    public UserServiceInterface userService(UserRepositoryInterface userRepo,
                                            ItemServiceInterface itemService,
                                            EmailSenderInterface emailSender) {
        return new UserService(userRepo, itemService, emailSender);
    }
}

