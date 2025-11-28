/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.model;



/**
 *
 * @author Admin
 */



public class DLLForChangeContent{
    Node head;
    Node tail;

    

    public DLLForChangeContent() {
    }
    
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
    
    public void addFirst(GeneralInfo data){
        Node new_node = new Node(data);
        if (head == null){
            head = new_node;
            tail = new_node;
            return;
        }
        new_node.next = head;
        head.prev = new_node;
        head = new_node;
    }
    
    public void addLast(GeneralInfo data){
        if (head == null){
            addFirst(data);
            return;
        }
        Node new_node = new Node(data);
        
        new_node.prev = tail;
        tail.next = new_node;
        tail = new_node;
        return;
    }
    
    public void remove(){
        if (head == null){
            return;
        }
        if (head == tail){
            head = null;
            tail = null;
            return;
        }
        Node temp = tail.prev;
        temp.next = null;
        tail.prev = null;
        tail = temp;
    }
    
    public void cutAfter(Node current) {
        if (current == null) return;
        if (current.next == null) return; // Không có gì để xóa

        Node nodeToDelete = current.next;

        // ngắt liên kết
        current.next = null;

        if (nodeToDelete != null) {
            nodeToDelete.prev = null;
        }

        // cập nhật tail
        tail = current;
    }
    
    
    public void printAll(){
        if(head == null){
            System.out.println("Rong");
            return;
        }
        Node temp;
        temp = head;
        while(temp != null){
            System.out.println(temp.data.getName());
            temp = temp.next; 
        }
    }
    }

