package com.dao;

import com.model.Passenger;
import com.service.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PassengerDao {
    private Session currentSession;
    private Transaction transaction;

    public PassengerDao(SessionFactory sessionFactory) {
    }

    private void openSession(boolean trans) {
        currentSession = HibernateFactory.HIBERNATE_FACTORY.getSessionFactory().openSession();
        if (trans) {
            transaction = currentSession.beginTransaction();
        }
    }


    public void update(Passenger passenger) {
        openSession(true);
        currentSession.update(passenger);
        commitAndClose();
    }


    private void commitAndClose() {
        transaction.commit();
        currentSession.close();
    }

    public void addToTable(Passenger passenger) {
        openSession(true);
        currentSession.save(passenger);
        commitAndClose();
    }

    public void deleteById(long id) {
        openSession(true);
        Passenger deletedPassenger = currentSession.get(Passenger.class, id);
        if (deletedPassenger != null) {
            currentSession.delete(deletedPassenger);
            commitAndClose();
        }

    }

    public Passenger getById(long id) {
        openSession(false);
        Passenger passenger = currentSession.get(Passenger.class, id);
        currentSession.close();
        return passenger;
    }

    public List<Passenger> getAll() {
        openSession(false);
        List result = currentSession.createQuery("from " + Passenger.class.getName()).list();
        currentSession.close();
        return result;
    }
}
