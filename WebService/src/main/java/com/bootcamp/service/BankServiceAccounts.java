package com.bootcamp.service;

import com.bootcamp.dao.DaoAccounts;
import com.bootcamp.model.Accounts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class BankServiceAccounts implements BankServiceAccountsInterface {
    private final DaoAccounts daoAccounts;

    @Autowired
    public BankServiceAccounts(DaoAccounts daoAccounts) {
        this.daoAccounts = daoAccounts;
    }

    @Override
    public ResponseEntity<List<Accounts>> getBalanceByUserId(Integer id) {
        log.debug("BankServiceAccounts: use 'getBalanceByUserId ({})'", id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Accounts> account = daoAccounts.getBalanceByUserId(id);
        if (account.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Accounts> getBalanceByAccountNumber(String number) {
        log.debug("BankServiceAccounts: use 'getBalanceByAccountNumber ({})'", number);
        if (number == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Accounts account = daoAccounts.getBalanceByAccountNumber(number);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Accounts> addDeposit(String number, BigDecimal value) {
        log.debug("BankServiceAccounts: use 'addDeposit ({}, {})'", number, value);
        if (number == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Accounts account = daoAccounts.getBalanceByAccountNumber(number);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        daoAccounts.addDeposit(number, value);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
