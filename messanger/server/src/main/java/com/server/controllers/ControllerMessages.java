package com.server.controllers;

import com.server.model.Messages;
import com.server.service.ServiceMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/message/")
public class ControllerMessages {

    private final ServiceMessages serviceMessages;

    @Autowired
    public ControllerMessages(ServiceMessages serviceMessages) {
        this.serviceMessages = serviceMessages;
    }

    @RequestMapping(value = "send/{login}&{password}&{recipient}&'{message}'", method = RequestMethod.PUT)
    public ResponseEntity<Messages> send(@PathVariable("login") String login, // TODO: есть смысл попробовать использовать хэш вместо открытого сообщения
                                         @PathVariable("password") String password,
                                         @PathVariable("recipient") String recipient,
                                         @PathVariable("message") String message) {
        return serviceMessages.send(login, password, recipient, message);
    }

    @RequestMapping(value = "update/{login}&{password}", method = RequestMethod.GET)
    public ResponseEntity<List<Messages>> getUpdatesForMe(@PathVariable("login") String login,
                                                          @PathVariable("password") String password) {
        return serviceMessages.getUpdatesForMe(login, password);
    }
}
