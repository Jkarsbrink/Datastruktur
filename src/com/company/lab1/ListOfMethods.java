package com.company.lab1;

public interface ListOfMethods<E> {

    void add(E value);

    void add(int index, E value);

    E get(int index);

    int size();

    int indexOf(Object obj);

    boolean contains(Object obj);

    boolean isEmpty();

    E remove(int index);

    E set(int index, E value);
}
