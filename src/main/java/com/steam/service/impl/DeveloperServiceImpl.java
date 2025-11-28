/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.service.impl;

import com.steam.model.Developer;
import com.steam.repository.DeveloperRepository;
import com.steam.util.DBConnection;

import java.sql.*;
import java.util.List;

/**
 *
 * @author PHI LONG
 */
public class DeveloperServiceImpl implements DeveloperRepository {

    @Override
    public Developer saveDeveloper(Developer developer) {
        if (developer.getDevId() > 0) {
            return updateDeveloper(developer);
        } else {
            return insertDeveloper(developer);
        }
    }

    private Developer insertDeveloper(Developer developer) {
        String sql = "INSERT INTO DEVELOPER (name, website, contact_email) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, developer.getDevName());
            stmt.setString(2, developer.getDevWebsite());
            stmt.setString(3, developer.getDevContactEmail());

            int rowAffected = stmt.executeUpdate();
            if (rowAffected > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        developer.setDevId(rs.getInt(1));
                    }
                }
                return developer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Developer updateDeveloper(Developer developer) {
        String sql = "UPDATE DEVELOPER SET name = ?, website = ?, contact_email = ? WHERE dev_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, developer.getDevName());
            stmt.setString(2, developer.getDevWebsite());
            stmt.setString(3, developer.getDevContactEmail());
            stmt.setInt(4, developer.getDevId());

            int rowAffected = stmt.executeUpdate();
            if (rowAffected > 0) {
                return developer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Developer findById(int devId) {
        String sql = "SELECT * FROM DEVELOPER WHERE dev_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, devId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Developer(
                            rs.getInt("dev_id"),
                            rs.getString("name"),
                            rs.getString("website"),
                            rs.getString("contact_email")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Developer> findByName(String devName) {
        return null;
    }

    @Override
    public boolean deleteById(int devId) {
        String sql = "DELETE FROM DEVELOPER WHERE dev_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, devId);
            int rowAffected = stmt.executeUpdate();
            return rowAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Developer getDeveloperViaGame(int gameID){return null;}
}
