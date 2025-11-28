/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.service.impl;

import com.steam.model.User;
import com.steam.repository.UserRepository;
import com.steam.service.UserService;
import com.steam.repository.impl.UserRepositoryImpl;


public class UserServiceImpl implements UserService{

//    Inject Repository (lớp cần tương tác với DB)
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    @Override
    public User registerUser(User user) {
//      if (userRepository.findByUserName(user.getUserName()) != null){
//          throw new RuntimeException("UserName has been used !");
//      }
      
      if(isEmailRegistered(user.getEmail())){
          throw new RuntimeException("Email has been registered !");
      }
      
      user.setWalletBalance(0.0);
      return userRepository.saveUser(user);
      
    }

    @Override
    public User login(String email, String passWord) {
//        if("".equals(userName)){
//            throw new RuntimeException("UserName can not be null !");
//        }
        if("".equals(passWord)){
            throw new RuntimeException("passWord can not be null");
        }

        //User user = userRepository.findByUserName(userName);
        User user = userRepository.findByEmail(email);
        if(user == null) return null;

        if(user.getPassWord().equals(passWord)){
            return user;
        }
        return null;

    }

    @Override
    public User getUserDetails(int userId) {
       User user = userRepository.findById(userId);
       if(user == null) return null;
       return user;
    }

    @Override
    public boolean topUpWallet(int userId, double amount) {
        User user = getUserDetails(userId);
        if(user == null) return false;
        if(amount <= 0 ) throw new RuntimeException("Amount must be greater than 0 !");

        double currentBalance = user.getWalletBalance();
        double newBlance =  currentBalance + amount;

        try{
            userRepository.updateWalletBalance(userId, newBlance);
            user.setWalletBalance(newBlance);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public double getWalletBalance(int userId) {
       User user = userRepository.findById(userId);
       if(user == null){
           throw new RuntimeException("No userID found");
       }

       return user.getWalletBalance();
    }

    @Override
    public boolean isEmailRegistered(String email) {
       User user = userRepository.findByEmail(email);
       if(user == null){ // neu email chua duoc dang ki
           return false;
       }
       else{
           return true;
       }
    }

    @Override
    public boolean isUserNameRegistered(String userName) {
        User user = userRepository.findByUserName(userName);
        if(user == null){ // neu userName chua duoc dang ki
            return false;
        }
        else{
            return true;
        }
    }

}
