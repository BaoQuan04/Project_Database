package com.steam.repository.impl;

import com.steam.model.Game;
import com.steam.model.Transaction;
import com.steam.model.User;
import com.steam.repository.TransactionRepository;
import com.steam.util.DBConnection;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {

    public TransactionRepositoryImpl() {
    }

    private Transaction mapResultSetToTransaction(ResultSet rs) throws SQLException {
        return new Transaction(
                rs.getInt("Trans_id"),
                rs.getDouble("Total_amount"),
                rs.getDate("Trans_date"),
                rs.getInt("User_id"),
                rs.getInt("Game_id"),
                rs.getString("Game_name")
        );
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        String sql = "INSERT INTO TRANSACTION ( total_amount, trans_date, user_id, game_id) " +
                "VALUES ( ?, ?, ?, ?)";
        Connection con = DBConnection.getConnection();
        try (
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setDouble(1, transaction.getTotalAmount());
            stmt.setDate(2, new java.sql.Date(transaction.getTransDate().getTime()));
            stmt.setInt(3, transaction.getUserId());
            stmt.setInt(4, transaction.getGameId());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        transaction.setTransId(rs.getInt(1));
                    }
                }
                return transaction;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Transaction findById(int transId) {
        String sql = "SELECT * FROM TRANSACTION WHERE Trans_id = ? ORDER BY Trans_date DESC";
        Connection con = DBConnection.getConnection();
        try (
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, transId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToTransaction(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Transaction> findByUserId(int userId) {
        String sql = "SELECT t.Trans_id, t.Total_amount, t.Trans_date, t.User_id, t.Game_id, g.Game_name FROM TRANSACTION AS t "
                    + "JOIN GAME AS g on t.Game_id = g.Game_id "
                    + "WHERE User_id = ? ORDER BY Trans_date DESC";
        List<Transaction> transactions = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try (
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    transactions.add(mapResultSetToTransaction(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

//    @Override
//    public boolean buyGameWithRollBack(User userInfo, Game game) {
//        return false;
//    }

    @Override
    public boolean buyGameWithRollBack(User userInfo, Game game) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
