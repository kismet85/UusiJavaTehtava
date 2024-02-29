package com.ismet;

public class TicketBooth {

    private int tickets;
    public TicketBooth(int tickets)
    {
        this.tickets = tickets;
    }
    public synchronized boolean buyTicket(int amount) {
        if (tickets < amount) { // Check if there are enough tickets available
            return false;
        }
        tickets -= amount;
        return true;
    }


    public int getTickets()
    {
        return tickets;
    }

}
