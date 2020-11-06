package com.company.lab1;

public class Stack2<E> {
    private LinkedList<E> list = new LinkedList<>();
    public void push(E e){
        list.add(0,e);
    }
    public E pop(){
        E e =list.get(0);
        list.remove(0);
        return e;
    }
    public E peek(){
        return list.get(0);
    }
}
