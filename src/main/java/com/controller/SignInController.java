package com.controller;


import com.model.Flight;
import com.model.Passenger;
import com.service.PassengerSevice;

import java.util.ArrayList;
import java.util.List;

public class SignInController {
    private PassengerSevice passengerSevice;

    public Passenger login(String login, String password) {
        passengerSevice = new PassengerSevice();
        if (login.equals("admin") && password.equals("admin")) {
            return new Passenger("admin", "admin", "admin", new ArrayList<Flight>());
        } else {
            List<Passenger> passengers = passengerSevice.getAll();
            for (Passenger p :passengers) {
                if(p.getLogin().equalsIgnoreCase(login) && p.getPassword().equals(password)) return p;
            }
        }
        return null;
    }
}
