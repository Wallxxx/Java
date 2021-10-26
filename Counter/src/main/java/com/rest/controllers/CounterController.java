package com.rest.controllers;

import com.rest.model.Counter;
import com.rest.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "api/")
public class CounterController {

    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @RequestMapping(value = "create/{name}", method = RequestMethod.POST)
    public ResponseEntity<Counter> create(@PathVariable("name") String name) {
        return counterService.create(name);
    }

    @RequestMapping(value = "inc/{name}", method = RequestMethod.PUT)
    public ResponseEntity<Counter> inc(@PathVariable("name") String name) {
        return counterService.inc(name);
    }

    @RequestMapping(value = "get/{name}", method = RequestMethod.GET)
    public ResponseEntity<Integer> get(@PathVariable("name") String name) {
        return counterService.get(name);
    }

    @RequestMapping(value = "delete/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Counter> delete(@PathVariable("name") String name) {
        return counterService.delete(name);
    }

    @RequestMapping(value = "sum/", method = RequestMethod.GET)
    public ResponseEntity<Integer> sum() {
        return counterService.sum();
    }

    @RequestMapping(value = "show/", method = RequestMethod.GET)
    public ResponseEntity<Set<String>> showNames() {
        return counterService.showNames();
    }

    @RequestMapping(value = "have/{name}", method = RequestMethod.GET) // TODO: Пофиксить ответ до более внятного
    public ResponseEntity<Counter> isHave(@PathVariable("name") String name) {
        return counterService.isHave(name);
    }
}
