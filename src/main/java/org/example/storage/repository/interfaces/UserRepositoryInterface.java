package org.example.storage.repository.interfaces;

public interface UserRepositoryInterface {
    public int countActiveBorrowedBooks(int userId);
    public int countReturnedBooks(int userId);
    public void saveUser(String username, String role, String email);
    public void removeUser(int userId);
}
