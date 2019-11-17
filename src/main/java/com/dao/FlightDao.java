package com.dao;

import com.model.Flight;
import com.service.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FlightDao {
    private Session currentSession;
    private Transaction transaction;

    public FlightDao(SessionFactory sessionFactory) {
    }

    private void openSession(boolean trans) {
        currentSession = HibernateFactory.HIBERNATE_FACTORY.getSessionFactory().openSession();
        if (trans) {
            transaction = currentSession.beginTransaction();
        }
    }

    public void update(Flight flight) {
        openSession(true);
        currentSession.update(flight);
        commitAndClose();
    }

    private void commitAndClose() {
        transaction.commit();
        currentSession.close();
    }

    public void addToTable(Flight flight) {
        openSession(true);
        currentSession.save(flight);
        commitAndClose();
    }

    public void deleteById(long id) {
        openSession(true);
        Flight deletedFlight = currentSession.get(Flight.class, id);
        if (deletedFlight != null) {
            currentSession.delete(deletedFlight);
            commitAndClose();
        }

    }

    public Flight getById(long id) {
        openSession(false);
        Flight flight = currentSession.get(Flight.class, id);
        currentSession.close();
        return flight;
    }

    public List<Flight> getAll() {
        openSession(false);
        List result = currentSession.createQuery("from " + Flight.class.getName()).list();
        currentSession.close();
        return result;
    }
}
