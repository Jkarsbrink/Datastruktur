package com.company.lab1;

public class LinkedList<E> implements ListOfMethods<E> {
    int size = 0;
    Node<E> head;
    Node<E> tail;
    Node<E> reference;
    public LinkedList(){
        head = new Node<E>(null,null,null);
        tail = new Node<E>(null,null,head);
        head.next = tail;
    }

    @Override
    public void add(E value) {
        Node<E> tempNode = new Node<E>(value,tail,tail.previous);
        tail.previous = tempNode;
        tempNode.previous.next = tempNode;
        size++;
    }

    @Override
    public void add(int index, E value) {
        setReference(index);
        Node<E> tempNode = new Node<E>(value, reference, reference.previous);
        tempNode.previous.next = tempNode;
        reference.previous = tempNode;
        size++;

    }

    @Override
    public E get(int index) {
        setReference(index);
        return reference.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(Object obj) {
        int index = 0;
        Node<E> currentNode = head.next;
        while (currentNode != null){
            if(currentNode.equals(obj)){
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }
        if(index == size && obj == null){
            return -1;
        }else{
            return index;
        }
    }

    public boolean contains(Object obj){
        boolean isTrue;
        if(!(this.indexOf(obj) == -1)){
            isTrue = true;
        }else{
            isTrue = false;
        }
        return isTrue;
    }

    @Override
    public boolean isEmpty() {
        if(size ==0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public E remove(int index) {
        setReference(index);
        E result = reference.next.value;
        reference.previous.next = reference.next;
        reference.next.previous = reference.previous;
        size --;
        return result;
    }

    @Override
    public E set(int index, E value) {
        setReference(index);
        E result = reference.value;
        reference.value = result;
        return result;
    }
    private void setReference(int index){
        reference = head.next;
        for(int i=0; i<index; i++){
            reference = reference.next;
        }
    }
}
