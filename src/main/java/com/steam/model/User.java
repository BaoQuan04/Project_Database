/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.model;

/**
 *
 * @author PHI LONG
 */
public class User {
    private int userId;
    private String userName;
    private String passWord, email;
    private double walletBalance;

    public User() {
    }

    public User(int userId, String userName, String passWord, String email, double walletBalance) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.walletBalance = walletBalance;
    }


    public User(String userName, String passWord, String email, double walletBalance) {
        this.userId = 0;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.walletBalance = walletBalance;
    }
    
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }
    
    
    
}
