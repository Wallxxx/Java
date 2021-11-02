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
@RequestMapping(value = "api/messages/")
public class ControllerMessages {

    private final ServiceMessages serviceMessages;

    @Autowired
    public ControllerMessages(ServiceMessages serviceMessages) {
        this.serviceMessages = serviceMessages;
    }

    @RequestMapping(value = "update/{login}&{password}", method = RequestMethod.GET)
    public ResponseEntity<List<Messages>> getUpdatesForMe(@PathVariable("login") String login,
                                                          @PathVariable("password") String password) {
        return serviceMessages.getUpdatesForMe(login, password);
    }
}
