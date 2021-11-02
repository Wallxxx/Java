package com.server.service;

import com.server.dao.DaoAccounts;
import com.server.model.Accounts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ServiceAccounts implements ServiceAccountsInterface {

    private final DaoAccounts daoAccounts;

    @Autowired
    public ServiceAccounts(DaoAccounts daoAccounts) {
        this.daoAccounts = daoAccounts;
    }

    @Override
    public ResponseEntity<Accounts> registerNewClient(String login, String password) {
        log.debug("ServiceAccounts: use registerNewClient({}, [password])", login);
        if (login.length() < 1 || password.length() < 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        daoAccounts.registerNewClient(login, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Accounts> auth(String login, String password) {
        log.debug("ServiceAccounts: use auth({}, [password])", login);
        if (login.length() < 1 || password.length() < 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (daoAccounts.auth(login, password) == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<String>> getAllClients() {
        log.debug("ServiceAccounts: use getAllClients()");
        return new ResponseEntity<>(daoAccounts.getAllClients(), HttpStatus.OK);
    }
}
