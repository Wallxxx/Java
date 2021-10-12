package com.bootcamp.controllers;

import com.bootcamp.service.BankServiceCards;
import com.bootcamp.tables.Cards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    private BankServiceCards bankService;

    @RequestMapping(value = "balance/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Cards> getUser(@PathVariable("id") Integer userId) {
        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Cards card= this.bankService.getBalanceById(userId);

        if (card == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @RequestMapping(value = "all/", method = RequestMethod.GET)
    public ResponseEntity<List<Cards>> getAll() {
        List cards = this.bankService.getAll();
        if (cards == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @RequestMapping(value = "new/{number}", method = RequestMethod.POST)
    public ResponseEntity<Cards> newCard(@PathVariable("number") String number) {
        bankService.newCard(number);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "userCards/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Cards>> getCardsByUserId(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List cards = this.bankService.getCardsByUserId(id);

        if (cards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
