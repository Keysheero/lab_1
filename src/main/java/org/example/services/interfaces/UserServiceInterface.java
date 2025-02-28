package org.example.services.interfaces;

public interface UserServiceInterface {
    public boolean canUserBorrow(int userId);
    public void borrowBook(int userId, int libraryItemId);
    public void returnBook(int userId, int libraryItemId);
    public void addUser(String username, String role, String email);
}
