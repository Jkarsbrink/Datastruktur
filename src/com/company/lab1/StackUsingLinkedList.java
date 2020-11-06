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
            System.out.println("\nNode empty");
            return;
        }
        temporary.data = e;
        temporary.link = top;
        top = temporary;
    }
    public boolean isEmpty() {
        return top == null;
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
            System.out.println("\nStack is empty");
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
                System.out.print("->" + temporary.data);
                temporary = temporary.link;
            }
        }
    }
}
