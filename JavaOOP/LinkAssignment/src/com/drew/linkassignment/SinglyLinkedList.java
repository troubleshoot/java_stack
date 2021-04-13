package com.drew.linkassignment;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList(){
        this.head = null;
    }

    public void add(int value){
        if(this.head == null){
            this.head = new Node(value);
        }
        else{
            Node pointer = this.head;
            while(pointer.next != null){
                pointer = pointer.next;
            }
            pointer.next = new Node(value);
        }
    }

    public void remove(){
        if(this.head != null){
            Node pointer = this.head;
            while(pointer.next.next != null){
                pointer = pointer.next;
            }
            pointer.next = null;
        }
    }

    public void printValues(){
        if(this.head != null){
            Node pointer = this.head;
            while(pointer.next != null){
                System.out.println(pointer.value);
                pointer = pointer.next;
            }
        }
    }
}