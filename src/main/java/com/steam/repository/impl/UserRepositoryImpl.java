package com.steam.repository.impl;

import com.steam.model.User;
import com.steam.repository.UserRepository;

import java.sql.*;

import com.steam.util.DBConnection;


public class UserRepositoryImpl implements UserRepository {

    public UserRepositoryImpl() {
    }

    @Override
//    dung de them moi hoac cap nhap user vao trong database
    public User saveUser(User user) {
        if(user.getUserId() > 0){
            return updateUser(user);
        }
        else{
            return insertUser(user);
        }
    }

    private User insertUser(User user){
        String sql = "INSERT INTO USER (user_name, password, email, wallet_balance) VALUES (?, ?, ?, ?)";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassWord());
            stmt.setString(3, user.getEmail());
            stmt.setDouble(4, user.getWalletBalance());

            int rowAffected = stmt.executeUpdate();
            if(rowAffected > 0){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        user.setUserId(rs.getInt(1)); //gan id moi cho User
                    }
                    return user;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public User updateUser(User user){
        String sql = "UPDATE USER SET user_name = ?, password = ?, email = ?, wallet_balance = ? WHERE user_id = ?";
        Connection con = DBConnection.getConnection();
        try (
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassWord());
            stmt.setString(3, user.getEmail());
            stmt.setDouble(4, user.getWalletBalance());
            stmt.setInt(5, user.getUserId());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public User findById(int userId) {
        String sql = "SELECT * FROM USER WHERE user_id = ?";
        Connection con = DBConnection.getConnection();
        try(
            PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setInt(1, userId);
            try(  ResultSet rs = stmt.executeQuery();){

                if(rs.next()){
                    return new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("password")
                                    ,rs.getString("email"), rs.getDouble("wallet_balance")
                    );
                }
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User findByUserName(String userName) {
        String sql = "SELECT * FROM USER WHERE user_name = ?";
        try( Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);){

            stmt.setString(1, userName);
            try( ResultSet rs = stmt.executeQuery();){
                if(rs.next()){
                    return new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("password")
                            ,rs.getString("email"), rs.getDouble("wallet_balance")
                    );
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM USER WHERE email = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setString(1, email);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("password")
                            ,rs.getString("email"), rs.getDouble("wallet_balance"));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateWalletBalance(int userId, double newBalance) {
            String sql = "UPDATE USER " +
                    "SET wallet_balance = ? " +
                    "WHERE user_id = ?";
            Connection con = DBConnection.getConnection();
            try(
                PreparedStatement stmt = con.prepareStatement(sql);

                ){
                stmt.setDouble(1, newBalance);
                stmt.setInt(2, userId);

                int rowAffected = stmt.executeUpdate();
                if (rowAffected > 0){
                    return true;
                }
                
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return false;
    }

    @Override
    public boolean deleteById(int userId) {
        String sql = "DELETE FROM USER " +
                    "WHERE user_id = ?";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

        ){
            stmt.setInt(1, userId);
            int rowAffected = stmt.executeUpdate();
            return rowAffected > 0;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
