package com.server.service;

import com.server.model.Messages;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceMessagesInterface {

    ResponseEntity<List<Messages>> getUpdatesForMe(String login, String password);
}
