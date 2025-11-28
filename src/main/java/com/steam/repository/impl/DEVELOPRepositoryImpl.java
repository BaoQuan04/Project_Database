package com.steam.repository.impl;

import com.steam.repository.DEVELOPRepository;

import com.steam.repository.impl.*;
import com.steam.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DEVELOPRepositoryImpl implements DEVELOPRepository {
    @Override
    public boolean isGameDevelopByDeveloper(int devId, int gameId) {
        String sql = "SELECT COUNT(*) FROM DEVELOP WHERE Dev_id = ? AND Game_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, devId);
            stmt.setInt(2, gameId);

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
    public boolean addGameToDeveloper(int devId, int gameId) {
        String sql = "INSERT INTO DEVELOP (dev_id, game_id) VALUES (?, ?)";

        try (   Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, devId);
            stmt.setInt(2, gameId);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
