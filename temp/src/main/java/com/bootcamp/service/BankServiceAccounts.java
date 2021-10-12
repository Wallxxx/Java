package com.bootcamp.service;

import com.bootcamp.dao.DaoAccounts;
import com.bootcamp.model.Accounts;

import java.math.BigDecimal;
import java.util.List;

public class BankServiceAccounts {
    private DaoAccounts daoAccounts;

    public BankServiceAccounts() {
        daoAccounts = new DaoAccounts();
    }

    public List getBalanceByUserId(Integer id) {
        return daoAccounts.getBalanceByUserId(id);
    }

    public Accounts getBalanceByAccountNumber(String number) {
        return daoAccounts.getBalanceByAccountNumber(number);
    }

    public void addDeposit(String number, BigDecimal value) {
        daoAccounts.addDeposit(number, value);
    }

    public void setDeposit(String number, BigDecimal value) {
        daoAccounts.setDeposit(number, value);
    }
}
