package org.example.storage.repository.postgres.item;

import org.example.storage.repository.Repository;
import org.example.storage.repository.interfaces.ItemRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemRepository extends Repository implements ItemRepositoryInterface {

    public ItemRepository(Connection connection) {
        super(connection);
    }

    public void saveLibraryItem(String title, String itemType, String status) {
        String saveItemSql = "INSERT INTO libraryitems(title, item_type, status) VALUES(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(saveItemSql)) {
            stmt.setString(1, title);
            stmt.setString(2, itemType);
            stmt.setString(3, status);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLibraryItem(int libraryItemId) {
        String sql = "DELETE FROM LibraryItems WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, libraryItemId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveBorrowRecord(int userId, int libraryItemId) {
        String sql = "INSERT INTO borrowrecords(user_id, library_item_id, borrowed_at) VALUES (?, ?, NOW())";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, libraryItemId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateReturnTime(int userId, int libraryItemId) {
        String sql = "UPDATE BorrowRecords SET returned_at = NOW() WHERE user_id = ? AND library_item_id = ? AND returned_at IS NULL";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, libraryItemId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateItemStatus(int libraryItemId, String status) {
        String sql = "UPDATE LibraryItems SET status = ? WHERE id = ?";
        try (var stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, libraryItemId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
