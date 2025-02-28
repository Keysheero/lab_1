package org.example.storage.repository.interfaces;

public interface ItemRepositoryInterface {
    public void saveLibraryItem(String title, String itemType, String status);
    public void deleteLibraryItem(int libraryItemId);
    public void saveBorrowRecord(int userId, int libraryItemId);
    public void updateReturnTime(int userId, int libraryItemId);
    public void updateItemStatus(int libraryItemId, String status);
}
