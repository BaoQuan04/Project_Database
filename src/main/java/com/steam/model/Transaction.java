package com.steam.model;

import java.util.Date;

public class Transaction {
    private int transId;
    private double totalAmount;
    private Date transDate;

    // Foreign Keys
    private int userId;
    private int gameId;
    
    private String gameName;
    public Transaction() {
    }

    public Transaction(int transId, double totalAmount, Date transDate, int userId, int gameId, String gameName) {
        this.transId = transId;
        this.totalAmount = totalAmount;
        this.transDate = transDate;
        this.userId = userId;
        this.gameId = gameId;
        this.gameName = gameName;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    
}