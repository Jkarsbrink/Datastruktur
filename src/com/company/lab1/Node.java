package com.company.lab1;

public class Node<E> {
    E value;
    Node<E> next;
    Node<E> previous;
    Node(E temporaryValue, Node<E> temporaryNext, Node<E> temporaryPrev){
        this.value = temporaryValue;
        this.next = temporaryNext;
        this.previous = temporaryPrev;
    }
}
