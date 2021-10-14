package com.bootcamp.dao;

import com.bootcamp.model.Accounts;
import com.bootcamp.model.Cards;
import com.bootcamp.util.GeneratorNumberCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DaoCards implements DaoCardsInterface{
    @PersistenceContext
    private EntityManager entityManager;

    private final GeneratorNumberCard generator;

    @Autowired
    public DaoCards(GeneratorNumberCard generator) {
        this.generator = generator;
    }

    @Override
    public List<Cards> getCardsByUserId(Integer id) {
        return entityManager.createQuery("from Cards where account = " +
                "(select id from Accounts where user = " + id + ")", Cards.class).getResultList();
    }

    @Transactional
    @Override
    public void newCard(String number) {
        Accounts accountId = entityManager.createQuery("from Accounts where number = '" + number + "'", Accounts.class)
                .getSingleResult();
        Cards card = new Cards(accountId, generator.generate());
        entityManager.persist(card);
    }

    @Override
    public Long getCountCardsByAccount(String number) {
        return entityManager.createQuery("select count (*) from Cards where account = " +
                "(select id from Accounts where number = '" + number + "')", Long.class).getSingleResult();
    }
}
