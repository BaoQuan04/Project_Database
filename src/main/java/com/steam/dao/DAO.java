/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.steam.util.DBConnection;



public class DAO {
    
    public  static void getAllUser(){
        Connection con = DBConnection.getConnection();
        try {
            String sql = "SELECT * FROM USER";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getString("User_name"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


