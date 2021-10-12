package com.bootcamp.controllers;

import com.bootcamp.service.BankServiceAccounts;
import com.bootcamp.tables.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/account/")
public class ControllerAccounts {

    @Autowired
    private BankServiceAccounts bankService;

    @RequestMapping(value = "buy/{number}/{money}", method = RequestMethod.PUT)
    public ResponseEntity<Cards> buy(@PathVariable("number") String number, @PathVariable("money") Integer money) {
        if (number == null || money == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bankService.buy(number, money);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
