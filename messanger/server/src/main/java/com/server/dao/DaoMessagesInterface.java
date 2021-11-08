package com.server.dao;

import com.server.model.Messages;

import java.util.List;

public interface DaoMessagesInterface {
    boolean send(DaoAccounts daoAccounts, String login, String password, String recipient, String message);
    List<Messages> getUpdatesForMe(DaoAccounts daoAccounts, String login, String password);
}
