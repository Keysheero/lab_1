package org.example.services.interfaces;

public interface ItemServiceInterface {
    public void  addBook(String title, String item_type, String status);
    public void markItemAsCheckedOut(int libraryItemId);
    public void markItemAsAvailable(int libraryItemId);
    public void saveBorrowRecord(int userId, int libraryItemId);
    public void updateReturnTime(int userId, int libraryItemId);
    public void updateItemStatus(int libraryItemId, String status);
}
