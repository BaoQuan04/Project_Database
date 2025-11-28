package com.steam.repository.impl;

import com.steam.model.Game;
import com.steam.repository.GameRepository;
import com.steam.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRepositoryImpl implements GameRepository{

    public GameRepositoryImpl() {
    }

    @Override
    public Game save(Game game) {
       if(game.getGameId() > 0){
           return updateGame(game);
       }
       return insertGame(game);
    }

    private Game insertGame(Game game){
        String sql = "INSERT INTO GAME (Game_name, Price, Description, Release_date) " +
                "VALUES (?, ?, ?, ?)";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            stmt.setString(1, game.getGameName());
            stmt.setDouble(2, game.getPrice());
            stmt.setString(3, game.getDescription());
            stmt.setDate(4,new java.sql.Date(game.getReleaseDate().getTime()));

            int rowAffected = stmt.executeUpdate();

            if(rowAffected > 0){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        game.setGameId(rs.getInt(1));
                    }
                }
                return game;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private Game updateGame(Game game){
        String sql = "UPDATE GAME " +
                "SET Game_name = ?, Price = ?, Description = ?, Release_date = ? WHERE Game_id = ?";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setString(1, game.getGameName());
            stmt.setDouble(2, game.getPrice());
            stmt.setString(3, game.getDescription());
            stmt.setDate(4, new java.sql.Date(game.getReleaseDate().getTime()));
            stmt.setInt(5, game.getGameId());

            int rowAffected = stmt.executeUpdate();

            if(rowAffected > 0){
                return game;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  Game findById(int gameId) {
        String sql = "SELECT * FROM GAME WHERE game_id = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setInt(1, gameId);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return mapResultSetToGame(rs);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private Game mapResultSetToGame(ResultSet rs) throws SQLException {
        return new Game(
                rs.getInt("Game_id"),
                rs.getString("Game_name"),
                rs.getDouble("Price"),
                rs.getString("Description"),
                rs.getDate("Release_date")
                );
    }

    @Override
    public boolean deleteById(int gameId) {
        String sql = "DELETE FROM GAME WHERE Game_id = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setInt(1, gameId);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Game> findByName(String name) {

        String sql = "SELECT * FROM GAME WHERE game_name = ?";
        List<Game> games = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    games.add(mapResultSetToGame(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> findByNameContainingIgnoreCase(String keyword) {
        String sql = "SELECT * FROM GAME WHERE LOWER(Game_name) LIKE ?";
        List<Game> games = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try (
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword.toLowerCase() + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    games.add(mapResultSetToGame(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> findByPriceGreaterThan(double price) {
        String sql = "SELECT * FROM GAME WHERE price > ?";
        List<Game> games = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDouble(1, price);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    games.add(mapResultSetToGame(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> findByDeveloper(int devID) {
        String sql = "SELECT g.Game_id, g.Game_name, g.Price, g.Description, g.Release_date FROM GAME as g " +
                "JOIN DEVELOP as dev ON dev.Game_id = g.Game_id " +
                //"JOIN DEVELOPER as d ON dev.Dev_id = d.Dev_id " +
                "WHERE dev.Dev_id = ?";
        //System.out.println("SQL chạy với Dev_id = " + devID);
        ArrayList<Game> listGame = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        
        try(PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setInt(1, devID);
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    listGame.add(mapResultSetToGame(rs));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println("Số game lấy được = " + listGame.size());
        return listGame;
    }

    @Override
    public List<Game> findByCategory(String category) {
        String sql = "SELECT * FROM GAME as g " +
                "JOIN HAS_GENRE as  hg ON hg.Game_id = g.Game_id " +
                "JOIN CATEGORY as c ON hg.Category_id = c.Category_id " +
                "WHERE LOWER(c.Category_name) LIKE ?";
        ArrayList<Game> listGame = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try(
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setString(1, "%" + category.toLowerCase() + "%");
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    listGame.add(mapResultSetToGame(rs));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return listGame;
    }
    
    @Override
    public String findGenre(int gameId){
//        String sql = "SELECT Category_name FROM CATEGORY as c " +
//                "JOIN HAS_GENRE as  hg ON hg.Category_id = c.Category_id " +
//                "JOIN game as g ON g.game_id = hg.game_id " +
//                "WHERE g.game_id = ?";
        String sql = "SELECT GROUP_CONCAT(c.Category_name SEPARATOR ', ') as categories FROM GAME as g "  +
                "JOIN HAS_GENRE as hg ON g.Game_id = hg.Game_id " +
                "JOIN CATEGORY as c ON hg.Category_id = c.Category_id " +
                "WHERE g.Game_id = ?";
        //List<String> categories = new ArrayList<>();
        String categories = "";
        Connection con = DBConnection.getConnection();
        try(
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setInt(1, gameId);
            try(ResultSet rs = stmt.executeQuery()){
//                while(rs.next()){
//                    categories.add(rs.getString("Category_name"));
//                }
                if (rs.next()) { 
                    categories = rs.getString("categories"); // 
                    } else {
                        categories = "Không có thể loại nào.";
                    }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }

}
