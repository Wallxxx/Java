package com.bootcamp.service;

import com.bootcamp.dao.DaoAccounts;
import org.springframework.stereotype.Service;

@Service
public class BankServiceAccounts {
    private DaoAccounts daoAccounts;

    BankServiceAccounts() {
        daoAccounts = new DaoAccounts();
    }

    public void buy(String number, Integer money) {
        daoAccounts.buy(number, money);
    }
}
