package com.bootcamp.dao;

import com.bootcamp.tables.Accounts;
import com.bootcamp.tables.Cards;
import com.bootcamp.tables.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DaoAccounts {
    private SessionFactory session;

    public DaoAccounts() {
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

    /*public void sendUsersDb(List<Users> users) {
        try (Session sendSession = session.openSession()) {
            for (Users o : users) {
                try {
                    sendSession.beginTransaction();
                    sendSession.save(o);
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
    }*/

    public void buy(String number, Integer money) {
        try (Session getSession = session.openSession()) {
            System.out.println("debug: number = " + number + "; money = " + money);
            Cards card = (Cards) getSession.createQuery("from Cards where account = (select id from " +
                    "Accounts where number = " + number + ")").getResultList().get(0);
            System.out.println("Card: ");
            System.out.println(card.toString());
            card.setBalance(card.getBalance() + money);
            try {
                getSession.beginTransaction();
                getSession.update(card);
                getSession.getTransaction().commit();
            } catch (ConstraintViolationException e) {
                getSession.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }

    public List getById(Integer id) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Accounts where id = " + id).getResultList();
        }
    }

    public List getByUserId(Integer id) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Accounts where user = " + id).getResultList();
        }
    }

    public List getByNumber(String number) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Accounts where number = " + number).getResultList();
        }
    }
}