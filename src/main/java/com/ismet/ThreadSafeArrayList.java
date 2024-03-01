package com.ismet;

import java.util.ArrayList;

public class ThreadSafeArrayList<T> {
    private ArrayList<T> list;

    public ThreadSafeArrayList() {
        this.list = new ArrayList<>();
    }

    public synchronized void add(T element) {
        list.add(element);
    }

    public synchronized int size() {
        return list.size();
    }

    public synchronized void remove(T element) {
        list.remove(element);
    }
}
