/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.model;

import java.util.Date;

/**
 *
 * @author PHI LONG
 */
public class Game extends GeneralInfo{
    private double price;
    private String Description;
    private Date releaseDate;

    public Game() {
        super();
    }

    public Game(int gameId, String gameName, double price, String description, Date releaseDate) {
        super(gameName, gameId);
        this.price = price;
        Description = description;
        this.releaseDate = releaseDate;
    }

    public int getGameId() {
        return super.id;
    }

    public void setGameId(int gameId) {
        super.setId(gameId);
    }

    public String getGameName() {
        return super.name;
    }

    public void setGameName(String gameName) {
        super.setName(gameName);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Game: " +super.name; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
