package com.company.lab1;

import static java.lang.System.exit;

public class StackUsingLinkedList {
    private class Node{
        int data;
        Node link;
    }

    Node top;
    StackUsingLinkedList(){
        this.top=null;
    }
    public void push(int e){
        Node temporary = new Node();
        if(temporary==null){
            System.out.println("\nStack Overfull");
            return;
        }
        temporary.data = e;
        temporary.link = top;
        top = temporary;
    }
    public boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }
    public int peek(){
        if(isEmpty() == false){
            return top.data;
        }else{
            System.out.println("Stack is empty");
            return -1;
        }
    }
    public void pop(){
        if(top==null){
            System.out.println("\nStack underflow");
            return;
        }
        top = top.link;
    }
    public void display(){
        if(top==null){
            System.out.println("\nStack underflow");
            exit(1);
        }else{
            Node temporary = top;
            while (temporary != null){
                System.out.println("->" + temporary.data);
                temporary = temporary.link;
            }
        }
    }
}
