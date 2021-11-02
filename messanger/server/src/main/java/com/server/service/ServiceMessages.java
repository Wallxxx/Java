package com.server.service;

import com.server.dao.DaoAccounts;
import com.server.dao.DaoMessages;
import com.server.model.Messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ServiceMessages implements ServiceMessagesInterface {

    private final DaoMessages daoMessages;
    private final DaoAccounts daoAccounts;

    @Autowired
    public ServiceMessages(DaoMessages daoMessages, DaoAccounts daoAccounts) {
        this.daoMessages = daoMessages;
        this.daoAccounts = daoAccounts;
    }

    @Override
    public ResponseEntity<List<Messages>> getUpdatesForMe(String login, String password) {
        log.debug("ServiceAccounts: use getUpdatesForMe({}, [password])", login);
        if (login.length() < 1 || password.length() < 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(daoMessages.getUpdatesForMe(daoAccounts, login, password), HttpStatus.OK);
    }
}
