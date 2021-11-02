package com.server.dao;

import com.server.model.Messages;

import java.util.List;

public interface DaoMessagesInterface {
    void startDialog(String login, String password);
    void stopDialog(String login, String password);
    List<Messages> getUpdatesForMe(DaoAccounts daoAccounts, String login, String password);
}
