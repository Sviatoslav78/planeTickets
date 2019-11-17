package com.service;

import com.dao.FlightDao;
import com.model.Flight;

import java.util.List;

public class FlightService {
    private FlightDao flightDao;

    public FlightService() {
        this.flightDao = new FlightDao(HibernateFactory.HIBERNATE_FACTORY.getSessionFactory());
    }

    public Flight getById(long id) {
        Flight flight = flightDao.getById(id);
        return flight;
    }

    public void deleteById(long id) {
        flightDao.deleteById(id);
    }

    public void createNew(Flight flight) {
        flightDao.addToTable(flight);
    }

    public void update(Flight flight) {
        flightDao.update(flight);
    }

    public List<Flight> getAll() {
        return flightDao.getAll();
    }
}
