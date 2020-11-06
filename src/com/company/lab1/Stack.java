package com.company.lab1;

public class Stack<E> extends LinkedList<E>{

    public void push(E value){
        add(0,value);
    }
    public E pop(){
        E e = get(0);
        remove(0);
        return e;
    }
    public E peek(){
        return get(0);
    }
}
