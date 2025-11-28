/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.service;
import com.steam.model.User;

/**
 *
 * @author PHI LONG
 */
public interface UserService {
    
    User registerUser(User user);
    User login(String userName, String passWord);
    
    User getUserDetails(int userId);
    
    boolean topUpWallet(int userId, double amount);
    double getWalletBalance(int userId);

//    kiem tra xem email co duoc dang ki hay chua
    boolean isEmailRegistered(String email);
    boolean isUserNameRegistered(String userName);
    //cac ham kiem tra hop le


}
