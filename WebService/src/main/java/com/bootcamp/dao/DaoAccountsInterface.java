package com.bootcamp.dao;

import com.bootcamp.model.Accounts;

import java.math.BigDecimal;
import java.util.List;

public interface DaoAccountsInterface {
    List<Accounts> getBalanceByUserId(Integer id);
    Accounts getBalanceByAccountNumber(String number);
    void addDeposit(String number, BigDecimal value);
}
