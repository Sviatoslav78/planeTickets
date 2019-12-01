package com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightId;

    @Column(name = "departureCity")
    private String departureCity;

    @Column(name = "arrivalCity")
    private String arrivalCity;

    @Column(name = "date")
    private Calendar calendar;

    @Column(name = "plane")
    private String plane;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "flights")
    private List<Passenger> passengers = new ArrayList<>();

    public Flight(String departureCity, String arrivalCity, Calendar calendar, String plane, List<Passenger> passengers) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.calendar = calendar;
        this.plane = plane;
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId &&
                Objects.equals(departureCity, flight.departureCity) &&
                Objects.equals(arrivalCity, flight.arrivalCity) &&
                Objects.equals(calendar, flight.calendar) &&
                Objects.equals(plane, flight.plane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, departureCity, arrivalCity, calendar, plane);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", calendar=" + calendar.getTime() +
                ", plane='" + plane + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
