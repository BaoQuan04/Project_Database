/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.model;

/**
 *
 * @author PHI LONG
 */

public class Developer extends GeneralInfo{
    private String devName, devWebsite, devContactEmail;

    public Developer() {
    }

    public Developer(int devId, String devName, String devWebsite, String devContactEmail) {
        super(devName, devId);
        this.devWebsite = devWebsite;
        this.devContactEmail = devContactEmail;
    }

    public int getDevId() {
        return super.id;
    }

    public void setDevId(int devId) {
        super.id = devId;
    }

    public String getDevName() {
        return super.name;
    }

    public void setDevName(String devName) {
        super.name = devName;
    }

    public String getDevWebsite() {
        return devWebsite;
    }

    public void setDevWebsite(String devWebsite) {
        this.devWebsite = devWebsite;
    }

    public String getDevContactEmail() {
        return devContactEmail;
    }

    public void setDevContactEmail(String devContactEmail) {
        this.devContactEmail = devContactEmail;
    }
    
    @Override
    public String toString() {
        return "Developer: " +super.name; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
