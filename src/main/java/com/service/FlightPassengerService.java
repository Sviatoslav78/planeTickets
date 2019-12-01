package com.service;

import com.dao.PassengerDao;
import com.model.Flight;
import com.model.Passenger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FlightPassengerService {
    private Session currentSession;
    private Transaction transaction;

    private PassengerSevice passengerSevice = new PassengerSevice();

    private void openSession(boolean trans) {
        currentSession = HibernateFactory.HIBERNATE_FACTORY.getSessionFactory().openSession();
        if (trans) {
            transaction = currentSession.beginTransaction();
        }
    }

    public void buySit(Passenger passenger, Flight flight) {
        openSession(true);
        passenger.getFlights().add(flight);
        passengerSevice.update(passenger);
    }

    public void sellSit(Passenger passenger, Flight flight) {
        openSession(true);
        passenger.getFlights().remove(flight);
        passengerSevice.update(passenger);
    }

}
