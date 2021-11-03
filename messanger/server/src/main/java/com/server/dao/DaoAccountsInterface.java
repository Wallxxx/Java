package com.server.dao;

import com.server.model.Accounts;

import java.util.List;

public interface DaoAccountsInterface {
    boolean registerNewClient(String login, String password);
    Accounts auth(String login, String password);
    Accounts search(String login);
    List<String> getAllClients();
}
