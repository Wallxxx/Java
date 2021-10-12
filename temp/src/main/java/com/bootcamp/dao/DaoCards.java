package com.bootcamp.dao;

import com.bootcamp.connection.ConnectionFactory;
import com.bootcamp.model.Accounts;
import com.bootcamp.model.Cards;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public class DaoCards {
    private SessionFactory sessionFactory = ConnectionFactory.getInstance().getSessionFactory();

    public List getCardsByUserId(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Cards where account = " +
                    "(select id from Accounts where user = " + id + ")").getResultList();
        }
    }

    public void newCard(String number) {
        try (Session session = sessionFactory.openSession()) {
            Accounts accountId = (Accounts) session.createQuery("from Accounts where number = " + number)
                    .getResultList().get(0);
            try {
                session.beginTransaction();
                session.save(new Cards(accountId, "3456-2222-0000-3333"));
                session.getTransaction().commit();
            } catch (ConstraintViolationException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
