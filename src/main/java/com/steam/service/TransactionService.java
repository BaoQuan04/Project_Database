package com.steam.service;

import com.steam.model.Transaction;
import com.steam.model.Game;
import com.steam.model.User;
import java.util.List;

public interface TransactionService {
    boolean buyGame(int userId, int gameId);

    boolean buyGameWithRollBack(User userInfo, Game game);
    
    List<Transaction> getTransactionHistory(int userId);
}
