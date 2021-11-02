package com.server.service;

import com.server.model.Accounts;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceAccountsInterface {
    ResponseEntity<Accounts> registerNewClient(String login, String password);
    ResponseEntity<Accounts> auth(String login, String password);
    ResponseEntity<List<String>> getAllClients();
}
