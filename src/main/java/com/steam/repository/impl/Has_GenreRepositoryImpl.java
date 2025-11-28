package com.steam.repository.impl;

import com.steam.repository.Has_GenreRepository;
import com.steam.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Has_GenreRepositoryImpl implements Has_GenreRepository {
    @Override
    public boolean isGameHasGenre(int gameId, int categoryId) {
        String sql = "SELECT COUNT(*) FROM HAS_GENRE WHERE Game_id = ? AND Category_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, gameId);
            stmt.setInt(2, categoryId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Trả về true nếu count > 0
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addGameToHasGenre(int gameId, int categoryId) {
        String sql = "INSERT INTO HAS_GENRE (Game_id, Category_id) VALUES (?, ?)";

        try (   Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, gameId);
            stmt.setInt(2, categoryId);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
