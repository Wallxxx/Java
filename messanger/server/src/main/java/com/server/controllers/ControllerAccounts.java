package com.server.controllers;

import com.server.model.Accounts;
import com.server.service.ServiceAccounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/account/")
public class ControllerAccounts {

    private final ServiceAccounts serviceAccounts;

    @Autowired
    public ControllerAccounts(ServiceAccounts serviceAccounts) {
        this.serviceAccounts = serviceAccounts;
    }

    @RequestMapping(value = "register/{login}&{password}", method = RequestMethod.PUT)
    public ResponseEntity<Accounts> registerNewClient(@PathVariable("login") String login,
                                                      @PathVariable("password") String password) {
        return serviceAccounts.registerNewClient(login, password);
    }

    @RequestMapping(value = "auth/{login}&{password}", method = RequestMethod.GET)
    public ResponseEntity<Accounts> auth(@PathVariable("login") String login,
                                         @PathVariable("password") String password) {
        return serviceAccounts.auth(login, password);
    }

    @RequestMapping(value = "all/", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllClients() {
        return serviceAccounts.getAllClients();
    }
}
