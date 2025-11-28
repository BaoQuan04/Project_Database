/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.model;

/**
 *
 * @author Admin
 */
public class Node {
    GeneralInfo data;
    Node prev;
    Node next;

    public Node() {
    }
    
    public Node(GeneralInfo data) {
        this.data = data;
    }

    public GeneralInfo getData() {
        return data;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public void setData(GeneralInfo data) {
        this.data = data;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
