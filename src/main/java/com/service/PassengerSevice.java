package com.service;

import com.dao.PassengerDao;
import com.model.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerSevice {
    private PassengerDao passengerDao;

    public PassengerSevice() {
        this.passengerDao = new PassengerDao(HibernateFactory.HIBERNATE_FACTORY.getSessionFactory());
    }


    public Passenger getById(long id) {
        Passenger passenger = passengerDao.getById(id);
        return passenger;
    }

    public void deleteById(long id) {
        passengerDao.deleteById(id);
    }

    public void createNew(Passenger passenger) {
        passengerDao.addToTable(passenger);
    }

    public void update(Passenger passenger) {
        passengerDao.update(passenger);
    }

    public List<Passenger> getAll() {
        return passengerDao.getAll();
    }

    public boolean exists(Passenger passengerForCheck) {
        List<Passenger> passengersForCheck = getAll();
        for (Passenger p :passengersForCheck) {
            if(p.getLogin().equalsIgnoreCase(passengerForCheck.getLogin())) return true;
        }
        return false;
    }
}
