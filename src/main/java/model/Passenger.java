package model;

public class Passenger {
    private String fullName;
    private long passportId;

    public Passenger(String fullName, long passportId) {
        this.fullName = fullName;
        this.passportId = passportId;
    }

    public String getFullName() {
        return fullName;
    }

    public long getPassportId() {
        return passportId;
    }
}
