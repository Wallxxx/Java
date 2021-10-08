package com.bootcamp.service;

import com.bootcamp.dao.DaoCards;
import com.bootcamp.dao.DaoUsers;
import com.bootcamp.tables.Users;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    private DaoUsers daoUsers;
    private DaoCards daoCards;

    public BankService() {
        daoUsers = new DaoUsers();
        daoCards = new DaoCards();
    }

    public void push() {
        List<Users> data = new ArrayList<>();
        Users info = new Users("Maxim", "Ushakov", "Evgen", 22, "880055544555", "Antarktida", "7908-0001");
        data.add(info);
        daoUsers.sendUsersDb(data);
    }

    public void select() {
        List data = daoCards.getBalance();
        for (Object i : data) System.out.println(i.toString());
    }

}
