package com.bootcamp.service;

import com.bootcamp.dao.DaoCards;
import com.bootcamp.tables.Cards;
import com.bootcamp.tables.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BankServiceCards {

    private DaoCards daoCards;

    BankServiceCards() {
        daoCards = new DaoCards();
    }

    public Cards getBalanceById(Integer id) {
        return daoCards.getBalanceById(id);
    }

    public List getAll() {
        return daoCards.getAll();
    }

    public void newCard(String number) {
        daoCards.newCard(number);
    }

    public List getCardsByUserId(Integer id) {
        return daoCards.getCardsByUserId(id);
    }

}
