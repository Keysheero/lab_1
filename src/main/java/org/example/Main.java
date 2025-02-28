package org.example;

import org.example.config.AppConfig;
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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Database db = context.getBean(Database.class);
        UserRepositoryInterface userRepo = context.getBean(UserRepositoryInterface.class);
        ItemRepositoryInterface itemRepo = context.getBean(ItemRepositoryInterface.class);
        EmailSenderInterface emailSender = context.getBean(EmailSenderInterface.class);
        ItemServiceInterface itemService = context.getBean(ItemServiceInterface.class);
        UserServiceInterface userService = context.getBean(UserServiceInterface.class);
        UserServiceInterface userServiceAlternative = (UserServiceInterface) context.getBean("alternativeUserService");


    }
}