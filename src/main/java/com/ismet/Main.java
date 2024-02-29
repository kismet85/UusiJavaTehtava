package com.ismet;

import java.util.Random;

public class Main {
    static final int totalAmountOfClients = 10;

    static Random random = new Random();

    public static void main(String[] args) {
        TicketBooth ticketBooth = new TicketBooth(random.nextInt(10, 25));
        System.out.println("Initial amount of tickets " + ticketBooth.getTickets());
        Thread[] customers = new Thread[totalAmountOfClients]; // Array to hold customer threads


        for (int i = 0; i < totalAmountOfClients; i++) {
            int randomTickets = random.nextInt(1,5);
            customers[i] = new Thread(new Customer(ticketBooth, randomTickets));
            customers[i].start();
        }


        for (int i = 0; i < totalAmountOfClients; i++) {
            try {
                customers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Tickets left" + ticketBooth.getTickets());
    }

}
