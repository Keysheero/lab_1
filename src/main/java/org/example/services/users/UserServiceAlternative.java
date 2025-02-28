package org.example.services.users;

import org.example.services.interfaces.ItemServiceInterface;
import org.example.services.interfaces.UserServiceInterface;
import org.example.storage.repository.interfaces.UserRepositoryInterface;
import org.example.utils.notifications.interfaces.EmailSenderInterface;
import org.springframework.stereotype.Service;

@Service("alternativeUserService")
public class UserServiceAlternative implements UserServiceInterface {
    private final UserRepositoryInterface ur;
    private final ItemServiceInterface is;
    private final EmailSenderInterface sender;

    public UserServiceAlternative(UserRepositoryInterface userRepository,
                                  ItemServiceInterface itemService,
                                  EmailSenderInterface sender) {
        this.ur = userRepository;
        this.is = itemService;
        this.sender = sender;
    }

    @Override
    public boolean canUserBorrow(int userId) {
        int activeBooks = ur.countActiveBorrowedBooks(userId);
        int returnedBooks = ur.countReturnedBooks(userId);
        int limit = 3 + (returnedBooks / 5);
        System.out.println("UserServiceAlternative: Checking if user " + userId + " can borrow books.");
        return activeBooks < limit;
    }

    @Override
    public void borrowBook(int userId, int libraryItemId) {
        if (!canUserBorrow(userId)) {
            throw new IllegalStateException("Borrow limit exceeded. (Alternative implementation)");
        }
        is.markItemAsCheckedOut(libraryItemId);
        is.saveBorrowRecord(userId, libraryItemId);
    }

    @Override
    public void returnBook(int userId, int libraryItemId) {
        is.updateReturnTime(userId, libraryItemId);
        is.markItemAsAvailable(libraryItemId);
    }

    @Override
    public void addUser(String username, String role, String email) {
        ur.saveUser(username, role, email);
        sender.sendEmail(email, "LAB_DEFENCE ALERT (Alternative)", "Alternative service implementation");
    }
}
