package com.bootcamp.controllers;

import com.bootcamp.dto.DtoDeposit;
import com.bootcamp.model.Accounts;
import com.bootcamp.service.BankServiceAccounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/account/")
public class ControllerAccounts {

    @Autowired
    private BankServiceAccounts bankService;

    @RequestMapping(value = "getBanalceByUserId/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Accounts>> getBalanceByUserId(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List account = this.bankService.getBalanceByUserId(id);
        if (account.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(value = "getBalanceByAccountNumber/{number}", method = RequestMethod.GET)
    public ResponseEntity<Accounts> getBalanceByAccountNumber(@PathVariable("number") String number) {
        if (number == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Accounts account = this.bankService.getBalanceByAccountNumber(number);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(value = "addDeposit/", method = RequestMethod.PUT)
    public ResponseEntity<Accounts> addDeposit(@RequestBody DtoDeposit changeDeposit) {
        if (changeDeposit == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Accounts account = this.bankService.getBalanceByAccountNumber(changeDeposit.getNumber());
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.bankService.addDeposit(changeDeposit.getNumber(), changeDeposit.getValue());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "setDeposit/", method = RequestMethod.PUT)
    public ResponseEntity<Accounts> setDeposit(@RequestBody DtoDeposit changeDeposit) {
        if (changeDeposit == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Accounts account = this.bankService.getBalanceByAccountNumber(changeDeposit.getNumber());
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.bankService.setDeposit(changeDeposit.getNumber(), changeDeposit.getValue());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
