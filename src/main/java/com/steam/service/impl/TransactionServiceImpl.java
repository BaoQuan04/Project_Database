 package com.steam.service.impl;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.steam.model.Game;
 import com.steam.model.User;
import com.steam.model.Transaction;
import com.steam.model.User;
import com.steam.repository.*;
import com.steam.repository.impl.UserRepositoryImpl;
import com.steam.service.TransactionService;
import com.steam.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Date;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final TransactionRepository transactionRepository;
    private final ContainRepository containRepository;

    public TransactionServiceImpl(UserRepository userRepository, GameRepository gameRepository,
                                  TransactionRepository transactionRepository, ContainRepository containRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.transactionRepository = transactionRepository;
        this.containRepository = containRepository;
    }


    @Override
    public boolean buyGame(int userId, int gameId) {

        User user = userRepository.findById(userId);
        Game game = gameRepository.findById(gameId);

        if (user == null || game == null) return false;
        double price = game.getPrice();


        if (user.getWalletBalance() < price) return false; //khong du so du

        if (containRepository.isGameOwnedByUser(userId, gameId)) return false; //game da so huu
        
        
        try {
            double oldBalance = user.getWalletBalance();
            double newBalance = user.getWalletBalance() - price;

            userRepository.updateWalletBalance(userId, newBalance);

            boolean gameAdded = containRepository.addGameToUser(userId, gameId);

            if (!gameAdded) {
                userRepository.updateWalletBalance(userId, oldBalance);
                return false;
            }

            Transaction transaction = new Transaction();
            transaction.setUserId(userId);
            transaction.setGameId(gameId);
            transaction.setTotalAmount(price);
            transaction.setTransDate(new Date());

            transactionRepository.saveTransaction(transaction);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean buyGameWithRollBack(User userInfo, Game game){
        String updateBalanceSQL = "UPDATE USER " +
                    "SET wallet_balance = ? " +
                    "WHERE user_id = ?";
        String addGameSQL = "INSERT INTO CONTAIN (Game_id, User_id) VALUES (?, ?)";
        String addTransactionSQL = "INSERT INTO TRANSACTION ( total_amount, trans_date, user_id, game_id) " +
                "VALUES ( ?, ?, ?, ?)";
        Connection con = DBConnection.getConnection();
        try {
            con.setAutoCommit(false);
            try{
                PreparedStatement stmtUpdate = con.prepareStatement(updateBalanceSQL);
                PreparedStatement stmtAddGame = con.prepareStatement(addGameSQL);
                PreparedStatement stmtAddTransaction = con.prepareStatement(addTransactionSQL);
                
                // cap nhap so du sau khi mua
                stmtUpdate.setDouble(1, userInfo.getWalletBalance() - game.getPrice());
                stmtUpdate.setInt(2, userInfo.getUserId());

                stmtUpdate.executeUpdate();
                System.out.println("Update Balance ok");
                
                // them game vao thu vien 
                stmtAddGame.setInt(1, game.getGameId());
                stmtAddGame.setInt(2, userInfo.getUserId());
                stmtAddGame.executeUpdate();
                System.out.println("Insert game ok");
                
                // khoi tao transaction
                Transaction transaction = new Transaction();
                transaction.setUserId(userInfo.getUserId());
                transaction.setGameId(game.getGameId());
                transaction.setTotalAmount(game.getPrice());
                transaction.setTransDate(new Date());
                
                // them transaction vao
                stmtAddTransaction.setDouble(1, transaction.getTotalAmount());
                stmtAddTransaction.setDate(2, new java.sql.Date(transaction.getTransDate().getTime()));
                stmtAddTransaction.setInt(3, transaction.getUserId());
                stmtAddTransaction.setInt(4, transaction.getGameId());

                stmtAddTransaction.executeUpdate();
                System.out.println("Insert Transac ok");
                // commit vao db
                con.commit();
                return true;
                
            }
            catch(SQLException e){
                con.rollback();
                e.printStackTrace();
                System.out.println("Da xay ra loi");
                return false;
            }
            finally{
                con.setAutoCommit(true);
            }
        
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<Transaction> getTransactionHistory(int userId) {
        return transactionRepository.findByUserId(userId);
    }
}