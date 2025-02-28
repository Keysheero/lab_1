package org.example.storage.repository.postgres.user;

import org.example.storage.repository.Repository;
import org.example.storage.repository.interfaces.UserRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository extends Repository implements UserRepositoryInterface {
    public UserRepository(Connection connection) {
        super(connection);
    }

    public int countActiveBorrowedBooks(int userId) {
        String sql = "SELECT COUNT(*) FROM BorrowRecords WHERE user_id = ? AND returned_at IS NULL";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int countReturnedBooks(int userId) {
        String sql = "SELECT COUNT(*) FROM BorrowRecords WHERE user_id = ? AND returned_at IS NOT NULL";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void saveUser(String username, String role, String email) {
        String insertSql = "INSERT INTO Users(username, role, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertSql)) {
            stmt.setString(1, username);
            stmt.setString(2, role);
            stmt.setString(3, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(int userId) {
        String deleteSql = "DELETE FROM Users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(deleteSql)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
