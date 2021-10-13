package com.bootcamp.dao;

import com.bootcamp.connection.ConnectionFactory;
import com.bootcamp.model.Accounts;
import com.bootcamp.model.Cards;
import com.bootcamp.util.GeneratorNumberCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoCards implements DaoCardsInterface{
    private SessionFactory sessionFactory = ConnectionFactory.getInstance().getSessionFactory();
    private final GeneratorNumberCard generator = new GeneratorNumberCard();

    @Override
    public List<Cards> getCardsByUserId(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Cards where account = " +
                    "(select id from Accounts where user = " + id + ")", Cards.class).getResultList();
        }
    }

    @Override
    public void newCard(String number) {
        try (Session session = sessionFactory.openSession()) {
            Accounts accountId = (Accounts) session.createQuery("from Accounts where number = '" + number + "'")
                    .getResultList().get(0);
            try {
                Cards card = new Cards(accountId, generator.generate());
                session.beginTransaction();
                session.save(card);
                session.getTransaction().commit();
            } catch (ConstraintViolationException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
