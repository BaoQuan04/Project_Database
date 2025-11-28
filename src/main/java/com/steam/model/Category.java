/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.model;

/**
 *
 * @author PHI LONG
 */
public class Category extends GeneralInfo{
    

    public Category() {
    }

    public Category(int categoryId, String categoryName) {
        super(categoryName, categoryId);
    }

    public int getCategoryId() {
        return super.id;
    }

    public void setCategoryId(int categoryId) {
        super.id = categoryId;
    }

    public String getCategoryName() {
        return super.getName();
    }

    public void setCategoryName(String categoryName) {
        super.name = categoryName;
    }

    @Override
    public String toString() {
        if (this.name.equals("Not Found")){
            return super.name;
        }
        return "Genre: " + super.name;
    }
    
    
}
