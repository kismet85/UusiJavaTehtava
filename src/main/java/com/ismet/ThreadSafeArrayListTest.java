package com.ismet;

public class ThreadSafeArrayListTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeArrayList<String> threadSafeArrayList = new ThreadSafeArrayList<>();


        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                threadSafeArrayList.add("Element " + i);
            }
        });

        Thread removeThread = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                threadSafeArrayList.remove("Element " + i);
            }
        });

        addThread.start();
        removeThread.start();

        addThread.join();
        removeThread.join();

        System.out.println("Size of ArrayList: " + threadSafeArrayList.size());
    }
}
