package com.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public enum HibernateFactory {
    HIBERNATE_FACTORY;

    private final Configuration config = new Configuration().configure("hibernate.cfg.xml");
    private SessionFactory sessionFactory = config.buildSessionFactory();

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
