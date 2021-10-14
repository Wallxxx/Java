package com.bootcamp.service;

import com.bootcamp.model.Accounts;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface BankServiceAccountsInterface {
    ResponseEntity<List<Accounts>> getBalanceByUserId(Integer id);
    ResponseEntity<Accounts> getBalanceByAccountNumber(String number);
    ResponseEntity<Accounts> addDeposit(String number, BigDecimal value);
}
