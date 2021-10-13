package com.bootcamp.controllers;

import com.bootcamp.dto.DtoDeposit;
import com.bootcamp.model.Accounts;
import com.bootcamp.service.BankServiceAccounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/account/")
public class ControllerAccounts {

    @Autowired
    private BankServiceAccounts bankService;

    @RequestMapping(value = "getBanalceByUserId/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Accounts>> getBalanceByUserId(@PathVariable("id") Integer id) {
        return bankService.getBalanceByUserId(id);
    }

    @RequestMapping(value = "getBalanceByAccountNumber/{number}", method = RequestMethod.GET)
    public ResponseEntity<Accounts> getBalanceByAccountNumber(@PathVariable("number") String number) {

        return bankService.getBalanceByAccountNumber(number);
    }

    @RequestMapping(value = "addDeposit/", method = RequestMethod.PUT)
    public ResponseEntity<Accounts> addDeposit(@RequestBody DtoDeposit changeDeposit) {
        return bankService.addDeposit(changeDeposit.getNumber(), changeDeposit.getValue());
    }
}
