package com.steam.service.impl;

import com.steam.model.Game;
import com.steam.service.GameService;
import java.util.List;
import com.steam.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class GameServiceImpl implements GameService{
    @Override
    public boolean removeGame(int gameId){
        return false;
    }
    
    @Override
    public Game getGameDetails(int gameId){
        return null;
    }
    
    @Override
    public List<Game> getAllGames(){
        String sql = "SELECT * FROM GAME LIMIT 8";
        List<Game> gameQuerry = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try{
            
            PreparedStatement stmt = con.prepareStatement(sql);
            try{
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    gameQuerry.add(new Game(rs.getInt("Game_id"), rs.getString("Game_name"),
                                            rs.getDouble("Price"), rs.getString("Description"), rs.getDate("Release_date")));
                }
            
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        catch(Exception e){
                
        }
        return gameQuerry;
    }
    
    @Override
    public List<Game> searchGamesByKeyword(String keyword){
        return null;
    };

    @Override
    public List<Game> filterGamesByMinPrice(double minPrice){
        return null;
    };
    
    @Override
    public List<Game> findGamesByDeveloperAndCategory(String developer, String category){
        return null;
    };
    
}
