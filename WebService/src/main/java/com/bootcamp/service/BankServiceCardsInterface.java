package com.bootcamp.service;

import com.bootcamp.model.Cards;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BankServiceCardsInterface {
    ResponseEntity<List<Cards>> getCardsByUserId(Integer id);
    ResponseEntity<Cards> newCard(String number);
    ResponseEntity<Long> getCountCardsByAccount(String number);
}
