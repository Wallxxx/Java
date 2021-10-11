package com.bootcamp.service;

import com.bootcamp.dao.DaoCards;
import com.bootcamp.dao.DaoUsers;
import com.bootcamp.tables.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceUsers {

    private DaoUsers daoUsers;

    BankServiceUsers() {
        daoUsers = new DaoUsers();
    }

    public Users getById(Integer id) {
        return daoUsers.getById(id);
    }

    public List getByName(String name) {
        return daoUsers.getByName(name);
    }

    public List getBySurname(String surname) {
        return daoUsers.getBySurname(surname);
    }

    public List getByPatronymic(String patronymic) {
        return daoUsers.getByPatronymic(patronymic);
    }

    public List getByAge(Long age) {
        return daoUsers.getByAge(age);
    }

    public List getByPhone(String phone) {
        return daoUsers.getByPhone(phone);
    }

    public List getByAddress(String address) {
        return daoUsers.getByAddress(address);
    }


    public List getAll() {
        return daoUsers.getAll();
    }


    public void save(Users user) {
        daoUsers.save(user);
    }


    public void delete(Integer id) {
        daoUsers.deleteById(id);
    }
}
