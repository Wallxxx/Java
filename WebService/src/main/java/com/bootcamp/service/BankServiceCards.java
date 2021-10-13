package com.bootcamp.service;

import com.bootcamp.dao.DaoCards;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
