package org.example.services.items;

import org.example.services.interfaces.ItemServiceInterface;
import org.example.storage.repository.interfaces.ItemRepositoryInterface;

public class ItemService implements ItemServiceInterface {
    private final ItemRepositoryInterface itemRepository;

    public ItemService(ItemRepositoryInterface itemRepository) {
        this.itemRepository = itemRepository;
    }
    public void  addBook(String title, String item_type, String status) {
        itemRepository.saveLibraryItem(title, item_type, status);
        System.out.println("Book has been saved " + title);
    }
    public void markItemAsCheckedOut(int libraryItemId) {
        updateItemStatus(libraryItemId, "CheckedOut");
    }

    public void markItemAsAvailable(int libraryItemId) {
        updateItemStatus(libraryItemId, "Available");
    }

    public void saveBorrowRecord(int userId, int libraryItemId) {
        itemRepository.saveBorrowRecord(userId, libraryItemId);
    }

    public void updateReturnTime(int userId, int libraryItemId) {
        itemRepository.updateReturnTime(userId, libraryItemId);
    }

    public void updateItemStatus(int libraryItemId, String status) {
        itemRepository.updateItemStatus(libraryItemId, status);
    }

}
