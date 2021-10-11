package com.bootcamp.dao;

import com.bootcamp.tables.Accounts;
import com.bootcamp.tables.Cards;
import com.bootcamp.tables.Users;
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
            config.addAnnotatedClass(Users.class).addAnnotatedClass(Accounts.class).addAnnotatedClass(Cards.class); // City.class
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

    public List getById(Long id) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Cards where id = " + id).getResultList();
        }
    }

    public List getByAccountId(Long id) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Cards where account = " + id).getResultList();
        }
    }

    public List getByNumber(String number) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Cards where number = " + number).getResultList();
        }
    }

    public List getByBalance(Long balance) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Cards where balance = " + balance).getResultList();
        }
    }
}
