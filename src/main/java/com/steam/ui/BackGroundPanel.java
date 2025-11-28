/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class BackGroundPanel extends JPanel {

    private Image bg;

    public BackGroundPanel() {
        bg = new ImageIcon(getClass().getResource("/background.jpg")).getImage();
        //setOpaque(false); // để giữ trong suốt
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
