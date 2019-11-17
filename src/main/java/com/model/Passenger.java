package com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "cash")
    private int cash;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "flight_passenger",
            joinColumns = { @JoinColumn(name = "passengerId") },
            inverseJoinColumns = { @JoinColumn(name = "flightId") }
    )
    private List<Flight> flights = new ArrayList<>();

    public Passenger(String fullName, int cash, List<Flight> flights) {
        this.fullName = fullName;
        this.cash = cash;
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id &&
                cash == passenger.cash &&
                Objects.equals(fullName, passenger.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, cash);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", cash=" + cash +
                '}';
    }
}
