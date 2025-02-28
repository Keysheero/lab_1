package org.example;

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
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        UserRepositoryInterface userRepo = new UserRepository(db.getConnection());
        ItemRepositoryInterface itemRepo = new ItemRepository(db.getConnection());
        EmailSenderInterface emailSender = new GmailSender();
        ItemServiceInterface itemService = new ItemService(itemRepo);
        UserServiceInterface userService = new UserService(userRepo, itemService, emailSender);



    }
}