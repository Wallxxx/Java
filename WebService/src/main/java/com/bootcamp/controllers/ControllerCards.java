package com.bootcamp.controllers;

import com.bootcamp.model.Cards;
import com.bootcamp.service.BankServiceCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cards/")
public class ControllerCards {

    @Autowired
    private BankServiceCards bankServiceCards;

    @RequestMapping(value = "getCardsByUserId/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Cards>> getCardsByUserId(@PathVariable("id") Integer id) {
        return bankServiceCards.getCardsByUserId(id);
    }

    @RequestMapping(value = "newCard/{number}", method = RequestMethod.POST)
    public ResponseEntity<Cards> newCard (@PathVariable("number") String number) {
        return bankServiceCards.newCard(number);
    }
}
