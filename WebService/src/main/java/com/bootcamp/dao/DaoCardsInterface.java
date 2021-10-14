package com.bootcamp.dao;

import com.bootcamp.model.Cards;

import java.util.List;

public interface DaoCardsInterface {
    List<Cards> getCardsByUserId(Integer id);
    void newCard(String number);
    Long getCountCardsByAccount(String number);
}
