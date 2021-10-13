package com.bootcamp.dao;

import com.bootcamp.connection.ConnectionFactory;
import com.bootcamp.model.Accounts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class DaoAccounts implements DaoAccountsInterface {
    private SessionFactory sessionFactory = ConnectionFactory.getInstance().getSessionFactory();

    @Override
    public List<Accounts> getBalanceByUserId(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Accounts where user = " + id, Accounts.class).getResultList();
        }
    }

    @Override
    public Accounts getBalanceByAccountNumber(String number) {
        try (Session session = sessionFactory.openSession()) {
            return (Accounts) session.createQuery("from Accounts where number = '" + number + "'").getResultList().get(0);
        }
    }

    @Override
    public void addDeposit(String number, BigDecimal value) {
        try (Session session = sessionFactory.openSession()) {
            Accounts newValue = (Accounts) session.createQuery("from Accounts where number = '" + number + "'").
                    getResultList().get(0);
            newValue.setBalance(newValue.getBalance().add(value));
            try {
                session.beginTransaction();
                session.update(newValue);
                session.getTransaction().commit();
            } catch (ConstraintViolationException e) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
        }
    }
}
