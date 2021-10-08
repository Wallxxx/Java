package com.bootcamp.dao;

import com.bootcamp.tables.Cards;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import java.util.List;

public class DaoCards {
    private SessionFactory session;

    public DaoCards() {
        try {
            Configuration config = new Configuration().configure();
            config.addAnnotatedClass(Cards.class); // City.class
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(config.getProperties());
            session = config.buildSessionFactory(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void sendUsersDb(List<Cards> user_cards) {
        try (Session sendSession = session.openSession()) {
            for (Cards card : user_cards) {
                try {
                    sendSession.beginTransaction();
                    sendSession.save(user_cards);
                    sendSession.getTransaction().commit();
                } catch (ConstraintViolationException e) {
                    e.printStackTrace();
                    sendSession.getTransaction().rollback();
                }
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public List getBalance() {
        try (Session getSession = session.openSession()) {
            return getSession.createQuery("select balance from Cards where account = (select id from Accounts where user = (select id from Users where name = 'Maxim'))").getResultList();
        }
    }
}
