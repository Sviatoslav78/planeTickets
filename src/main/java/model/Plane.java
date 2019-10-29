package model;

public class Plane {
    private int planeNumber;
    private String planeBrand;
    private int ticketsNumber;

    public Plane(int planeNumber, int ticketsNumber) {
        this.planeNumber = planeNumber;
        this.ticketsNumber = ticketsNumber;
    }

    public int getPlaneNumber() {
        return planeNumber;
    }

    public String getPlaneBrand() {
        return planeBrand;
    }

    public int getTicketsNumber() {
        return ticketsNumber;
    }
}
