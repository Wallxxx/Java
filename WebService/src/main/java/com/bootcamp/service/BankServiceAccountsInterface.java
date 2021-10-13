package com.bootcamp.service;

import com.bootcamp.model.Accounts;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface BankServiceAccountsInterface {
    ResponseEntity<Accounts> getBalanceByAccountNumber(String number);
    ResponseEntity<Accounts> addDeposit(String number, BigDecimal value);
}
