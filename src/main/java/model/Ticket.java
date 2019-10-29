package model;

public class Ticket {
    private int ticketNumber;
    private boolean extraBaggage;

    public Ticket(int ticketNumber, boolean extraBaggage) {
        this.ticketNumber = ticketNumber;
        this.extraBaggage = extraBaggage;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public boolean isExtraBaggage() {
        return extraBaggage;
    }
}
