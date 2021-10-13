package com.bootcamp.controllers;

import com.bootcamp.model.Accounts;
import com.bootcamp.model.Cards;
import com.bootcamp.service.BankServiceAccounts;
import com.bootcamp.service.BankServiceCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private BankServiceAccounts bankServiceAccounts;

    @RequestMapping(value = "getCardsByUserId/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Cards>> getCardsByUserId(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List cards = this.bankServiceCards.getCardsByUserId(id);
        if (cards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @RequestMapping(value = "newCard/{number}", method = RequestMethod.POST)
    public ResponseEntity<Cards> newCard (@PathVariable("number") String number) {
        if (number == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Accounts account = this.bankServiceAccounts.getBalanceByAccountNumber(number);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.bankServiceCards.newCard(number);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
