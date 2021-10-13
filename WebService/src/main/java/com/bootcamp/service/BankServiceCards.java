package com.bootcamp.service;

import com.bootcamp.dao.DaoAccounts;
import com.bootcamp.dao.DaoCards;
import com.bootcamp.model.Accounts;
import com.bootcamp.model.Cards;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BankServiceCards implements BankServiceCardsInterface{
    private final DaoCards daoCards;
    private final DaoAccounts daoAccounts;

    @Autowired
    public BankServiceCards(DaoCards daoCards, DaoAccounts daoAccounts) {
        this.daoCards = daoCards;
        this.daoAccounts = daoAccounts;
    }

    @Override
    public ResponseEntity<List<Cards>> getCardsByUserId(Integer id) {
        log.debug("BankServiceCards: use 'getCardsByUserId ({})'", id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Cards> cards = daoCards.getCardsByUserId(id);
        if (cards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Cards> newCard(String number) {
        log.debug("BankServiceCards: use 'newCard ({})'", number);
        if (number == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Accounts account = daoAccounts.getBalanceByAccountNumber(number);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        daoCards.newCard(number);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
