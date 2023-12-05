package org.example;

import org.hibernate.*;
import jakarta.enterprise.context.ApplicationScoped;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class DBManager implements Serializable {
    private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hit.class).buildSessionFactory();
    public void addHit(Hit hit) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.persist(hit);
        session.getTransaction().commit();
    }

    public ArrayList<Hit> getHits() {
        try (Session session = factory.openSession()) {
            ArrayList<Hit> attempts = (ArrayList<Hit>) session.createQuery("From Hit").list();
            Collections.reverse(attempts);
            return attempts;
        }
    }

    public SessionFactory getSessionFactory() {
        return factory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }
}
