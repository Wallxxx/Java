package com.server.dao;

import com.server.memory.Data;
import com.server.model.Accounts;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class DaoAccounts implements DaoAccountsInterface {

    @Override
    public void registerNewClient(String login, String password) {
        Accounts newAccount = new Accounts(login, password);
        Data.getAccounts().add(newAccount);
    }

    @Override
    public Accounts auth(String login, String password) {
        for (Accounts accounts : Data.getAccounts()) {
            if (Objects.equals(accounts.getLogin(), login) &&
                    Objects.equals(accounts.getPassword(), password)) {
                return accounts;
            }
        }
        return null;
    }

    @Override
    public List<String> getAllClients() {
        List<String> clients = new ArrayList<>();
        for (Accounts account : Data.getAccounts()) {
            clients.add(account.getLogin());
        }
        return clients;
    }
}
