package com.steam.repository;

import com.steam.model.Game;
import com.steam.model.Transaction;
import com.steam.model.User;

import java.util.List;

public interface TransactionRepository {

    Transaction saveTransaction(Transaction transaction);

    Transaction findById(int transId);

    List<Transaction> findByUserId(int userId);

    boolean buyGameWithRollBack(User userInfo, Game game);

}
