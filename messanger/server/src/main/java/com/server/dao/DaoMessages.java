package com.server.dao;

import com.server.memory.Data;
import com.server.model.Accounts;
import com.server.model.Messages;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DaoMessages implements DaoMessagesInterface {

    @Override
    public void startDialog(String login, String password) {

    }

    @Override
    public void stopDialog(String login, String password) {

    }

    @Override
    public boolean send(DaoAccounts daoAccounts, String login, String password, String recipient, String message) {
        if (daoAccounts.auth(login, password) == null) {
            return false;
        }
        Accounts account = daoAccounts.search(recipient);
        if (account == null) return false;
        Messages messages = new Messages(login, message);
        for (Map.Entry<Accounts, List<Messages>> entry : Data.getData().entrySet()) {
            if (entry.getKey() == account) {
                entry.getValue().add(messages);
            }
        }
        return true;
    }

    @Override
    public List<Messages> getUpdatesForMe(DaoAccounts daoAccounts, String login, String password) {
        Accounts account = daoAccounts.auth(login, password);
        if (account == null) return null;
        List<Messages> answer = new ArrayList<>();
        for (Map.Entry<Accounts, List<Messages>> entry : Data.getData().entrySet()) {
            if (entry.getKey() == account) {
                answer = entry.getValue();
            }
        }
        return answer;
    }
}
