/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.repository;

import com.steam.model.User;
        
        

/**
 *
 * @author PHI LONG
 */
public interface UserRepository {
    
//   Dang ki user
    User saveUser(User user);
    
//   Dang nhap user
    User findById(int userId);
    User findByUserName(String userName);
    User findByEmail(String email);
    User updateUser(User user);
    boolean updateWalletBalance(int userId, double newBalance);
    
    boolean deleteById(int userId);
}
