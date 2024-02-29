package com.ismet;

public class Customer implements Runnable {
    private static int nextCustomerId = 1;
    private int customerId;
    private TicketBooth ticketBooth;
    private int n;

    public Customer(TicketBooth ticketBooth, int n) {
        this.ticketBooth = ticketBooth;
        this.n = n;
        this.customerId = nextCustomerId++;
    }

    public void run() {
            if (ticketBooth.buyTicket(n)) {
                System.out.println("Customer " + customerId + " reserved " + n + " ticket.");
            }
            else {
                System.out.println("Customer " + customerId + " couldn't reserve " + n + " tickets.");
            }
    }

    public int getAmountOfTickets() {
        return n;
    }
}
