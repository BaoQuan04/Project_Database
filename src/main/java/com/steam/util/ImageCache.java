/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.util;

import com.steam.model.Game;
import java.awt.Image;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class ImageCache {
    private static final Map<String, ImageIcon> cache = new HashMap<>();
    
    /**
     * Load ảnh với cache
     * @param path Đường dẫn ảnh (ví dụ: "/game1/1.jpg")
     * @return ImageIcon đã cache
     */
    public static ImageIcon getImage(String path) {
        // ✅ Kiểm tra cache trước
        if (cache.containsKey(path)) {
            System.out.println("Loading from cache: " + path);
            return cache.get(path);
        }
        
        // ✅ Nếu chưa có, load và cache
        System.out.println("Loading from disk: " + path);
        try {
            ImageIcon icon = new ImageIcon(ImageCache.class.getResource(path));
            cache.put(path, icon);
            return icon;
        } catch (Exception e) {
            System.err.println("Error loading image: " + path);
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Load ảnh với scale và cache
     */
    
    public static void preloadAllImages(List<Game> games) {
        for (Game g : games) {
            String base = "/game" + g.getId() + "/";

            // Load ảnh header
            ImageCache.getImage(base + "header.jpg");

            // Load các ảnh chi tiết
            for (int i = 2; i <= 5; i++) {
                ImageCache.getImage(base + i + ".jpg");
            }
        }
    }
    
    public static ImageIcon getScaledImage(String path, int width, int height) {
        String cacheKey = path + "_" + width + "x" + height;
        
        // ✅ Check cache
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        //return null;
        // ✅ Load, scale và cache
        try {
            ImageIcon original = new ImageIcon(ImageCache.class.getResource(path));
            Image scaled = original.getImage().getScaledInstance(
                width, height, Image.SCALE_SMOOTH
            );
            
            ImageIcon scaledIcon = new ImageIcon(scaled);
            cache.put(cacheKey, scaledIcon);
            
            return scaledIcon;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Clear cache
     */
    public static void clearCache() {
        cache.clear();
        System.gc(); // Suggest garbage collection
    }
    
    /**
     * Remove specific image from cache
     */
    public static void removeFromCache(String path) {
        cache.remove(path);
    }
    
    /**
     * Get cache size
     */
    public static int getCacheSize() {
        return cache.size();
    }
}
