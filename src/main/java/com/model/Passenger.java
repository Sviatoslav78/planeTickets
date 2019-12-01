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

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "flight_passenger",
            joinColumns = { @JoinColumn(name = "passengerId") },
            inverseJoinColumns = { @JoinColumn(name = "flightId") }
    )
    private List<Flight> flights = new ArrayList<>();

    public Passenger(String fullName, String login, String password, List<Flight> flights) {
        this.fullName = fullName;
        this.cash = 0;
        this.login = login;
        this.password = password;
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
