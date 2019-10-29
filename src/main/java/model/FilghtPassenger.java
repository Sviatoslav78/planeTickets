package model;

public class FilghtPassenger {
    private String planeClass;
    private int cost;
    private Passenger passenger;

    public FilghtPassenger(String planeClass, int cost, Passenger passenger) {
        this.planeClass = planeClass;
        this.cost = cost;
        this.passenger = passenger;
    }

    public String getPlaneClass() {
        return planeClass;
    }

    public int getCost() {
        return cost;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}
