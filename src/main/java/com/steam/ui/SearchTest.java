/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.ui;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Toyo
 */
public class SearchTest {
    private List<String> items; // nguồn dữ liệu gợi ý
    public SearchTest(){
        items = Arrays.asList(
            "Super Mario", "Sonic", "Street Fighter", "Starcraft", "Skyrim",
            "Sekiro", "Subnautica", "Stardew Valley", "Spore", "Splinter Cell",
            "Portal", "Pong", "Pac-Man", "Persona 5", "Prince of Persia"
        );
        
        
        
    }
    public static void main(String[] args){
        SearchTest app = new SearchTest();
    }
    
}
