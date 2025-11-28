package com.steam.repository.impl;

import com.steam.model.Game;
import com.steam.repository.ContainRepository;
import com.steam.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContainRepositoryImpl implements ContainRepository {

    public ContainRepositoryImpl() {
    }

    @Override
    public  boolean isGameOwnedByUser(int userId, int gameId) {
        String sql = "SELECT COUNT(*) FROM CONTAIN WHERE User_id = ? AND Game_id = ?";
        Connection con = DBConnection.getConnection();
        try (
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, gameId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getInt(1));
                    return rs.getInt(1) > 0; // Trả về true nếu count > 0
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addGameToUser(int userId, int gameId) {
        String sql = "INSERT INTO CONTAIN (User_id, Game_id) VALUES (?, ?)";
        Connection con = DBConnection.getConnection();
        try (   
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, gameId);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
    } catch (SQLException e) {
           e.printStackTrace();
            return false;
        }
        
    }

    @Override
    public List<Game> gamesOwnByUser(int user_id) {
        String sql = "SELECT * FROM GAME as g "
                    + "JOIN CONTAIN as c ON c.Game_id = g.Game_id "
                    + "WHERE c.User_id = ?";
        
        List<Game> gamesOwn = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try (   
                PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, user_id);

            try{ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                        gamesOwn.add(new Game(rs.getInt("game_id"),
                                                rs.getString("game_name"),
                                                rs.getDouble("price"),
                                                rs.getString("description"),
                                                rs.getDate("release_date")));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
           e.printStackTrace();    
        }
        return gamesOwn;
    }
    
    @Override
    public boolean removeGameFromUser(int userId, int gameId){
        String sql = "DELETE FROM CONTAIN WHERE User_id = ? AND Game_id = ?";
        Connection con = DBConnection.getConnection();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, gameId);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
    } catch (SQLException e) {
           e.printStackTrace();
            return false;
        }
    }
    
}
