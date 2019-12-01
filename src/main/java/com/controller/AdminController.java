package com.controller;

import com.model.Flight;
import com.model.Passenger;
import com.model.Plane;
import com.model.Route;
import com.service.FlightService;
import net.sourceforge.jdatepicker.DateModel;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AdminController {
    private FlightService flightService = new FlightService();

    public void createFight(int departureIndex, int arrivalIndex, int planeIndex, DateModel<?> date, String time) {
        String[] exactTime = time.split(":");

        String departure = Route.values()[departureIndex].getName();
        String arrival = Route.values()[arrivalIndex].getName();
        GregorianCalendar timeDate = new GregorianCalendar(date.getYear(), date.getMonth(), date.getDay(), Integer.parseInt(exactTime[0]),
                Integer.parseInt(exactTime[1]));
        String plane = Plane.values()[planeIndex].getName();

        Flight flight = new Flight(departure, arrival, timeDate, plane, new ArrayList<Passenger>());
        flightService.createNew(flight);
    }

}
