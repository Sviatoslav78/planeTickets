package model;

import java.util.Date;

public class Flight {
    private String route;
    private Ticket ticket;
    private Date date;
    private String flightNumber;
    private Plane plane;

    public Flight(String route, Ticket ticket, Date date, String flightNumber, Plane plane) {
        this.route = route;
        this.ticket = ticket;
        this.date = date;
        this.flightNumber = flightNumber;
        this.plane = plane;
    }

    public String getRoute() {
        return route;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Date getDate() {
        return date;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Plane getPlane() {
        return plane;
    }
}
