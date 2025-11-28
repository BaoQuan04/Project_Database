package com.steam.repository.impl;

import com.steam.model.Review;
import com.steam.model.ReviewWithUser;
import com.steam.repository.ReviewRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.steam.model.*;
import com.steam.util.DBConnection;

public class ReviewRepositoryImpl implements ReviewRepository {

    private Review mapResultSetToReview(ResultSet rs) throws SQLException{
        return new Review(
                rs.getInt("game_id"),
                rs.getInt("user_id"),
                rs.getString("comment"),
                rs.getString("rating")
        );
    }
    
    private ReviewWithUser mapResultSetToReview2(ResultSet rs) throws SQLException{
        return new ReviewWithUser(
                rs.getInt("game_id"),
                rs.getInt("user_id"),
                rs.getString("user_name"),
                rs.getString("comment"),
                rs.getString("rating")
        );
    }

    @Override
    public Review save(Review review) {
        Review existedReview = findByGameIdAndUserId(review.getGameId(), review.getUserId());

        if(existedReview == null){
            System.out.println("error");
            return insertReview(review);
            
        }
        else{
            System.out.println("ok");
            return updateReview(review);
        }

    }

    private Review insertReview(Review review){
        String sql = "INSERT INTO REVIEW(game_id, user_id, comment, rating) " +
                "VALUES (?, ?, ?, ?)";
        Connection con = DBConnection.getConnection();
        try(
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setInt(1, review.getGameId());
            stmt.setInt(2, review.getUserId());
            stmt.setString(3, review.getComment());
            stmt.setString(4, review.getRating());

            int rowAffected = stmt.executeUpdate();
            if (rowAffected > 0) return review;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private Review updateReview(Review review){
        String sql = "UPDATE REVIEW " +
                "SET comment = ?, rating = ? " +
                "WHERE game_id = ? and user_id = ?";
        Connection con = DBConnection.getConnection();
        try(
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setString(1, review.getComment());
            stmt.setString(2, review.getRating());
            stmt.setInt(3, review.getGameId());
            stmt.setInt(4, review.getUserId());

        int rowAffected  = stmt.executeUpdate();
        if(rowAffected > 0){
            return review;
        }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteByGameIdAndUserId(int gameId, int userId) {
        String sql = "DELETE FROM REVIEW " +
                "WHERE game_id = ? AND user_id = ?";
        Connection con = DBConnection.getConnection();
        try(
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setInt(1, gameId);
            stmt.setInt(2, userId);

            int rowAffected = stmt.executeUpdate();
            if(rowAffected > 0){
                return true;
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public Review findByGameIdAndUserId(int gameId, int userId) {
        String sql = "SELECT * FROM REVIEW " +
                "WHERE game_id = ? AND user_id = ?";
        Connection con = DBConnection.getConnection();
        try(
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setInt(1, gameId);
            stmt.setInt(2, userId);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return mapResultSetToReview(rs);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ReviewWithUser> findByGameId(int gameId) {
//        String sql = "SELECT * FROM REVIEW " +
//                "WHERE game_id = ?";
        String sql = "SELECT r.Game_id ,u.User_id, u.User_name, r.Comment, r.Rating FROM USER as u "
                    + "JOIN REVIEW as r ON r.User_id = u.User_id "
                    + "WHERE r.Game_id = ?";
        Connection con = DBConnection.getConnection();
        try(
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setInt(1, gameId);

            ArrayList<ReviewWithUser> lsReview = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                lsReview.add(mapResultSetToReview2(rs));
            }
            return lsReview;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return Collections.EMPTY_LIST;
    }

    @Override
    public int countByGameId(int gameId) {
        String sql = "SELECT COUNT(*) " +
                "FROM REVIEW " +
                "WHERE game_id = ?";
        Connection con = DBConnection.getConnection();
        try(
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setInt(1, gameId);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return 0;
    }

}
