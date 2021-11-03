package com.server.service;

import com.server.model.Messages;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceMessagesInterface {

    ResponseEntity<Messages> send(String login, String password, String recipient, String message);
    ResponseEntity<List<Messages>> getUpdatesForMe(String login, String password);
}
