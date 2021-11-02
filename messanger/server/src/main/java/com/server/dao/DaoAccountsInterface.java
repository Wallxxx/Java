package com.server.dao;

import com.server.model.Accounts;

import java.util.List;

public interface DaoAccountsInterface {
    void registerNewClient(String login, String password);
    Accounts auth(String login, String password);
    List<String> getAllClients();
}
