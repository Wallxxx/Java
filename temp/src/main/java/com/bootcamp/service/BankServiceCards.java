package com.bootcamp.service;

import com.bootcamp.dao.DaoCards;

import java.util.List;

public class BankServiceCards {
    private DaoCards daoCards;

    public BankServiceCards() {
        daoCards = new DaoCards();
    }

    public List getCardsByUserId(Integer id) {
        return daoCards.getCardsByUserId(id);
    }

    public void newCard(String number) {
        daoCards.newCard(number);
    }

}
