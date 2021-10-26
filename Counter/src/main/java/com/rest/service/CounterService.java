package com.rest.service;

import com.rest.dao.DaoCounters;
import com.rest.model.Counter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class CounterService implements CounterServiceInterface {
    private final DaoCounters daoCounters;

    @Autowired
    public CounterService(DaoCounters daoCounters) {
        this.daoCounters = daoCounters;
    }

    @Override
    public ResponseEntity<Counter> create(String name) {
        log.debug("CounterService: use 'create ({})'", name);
        if (name.length() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (daoCounters.isHave(name)) {
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }
        daoCounters.create(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Counter> inc(String name) {
        log.debug("CounterService: use 'inc ({})'", name);
        if (name.length() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!daoCounters.isHave(name)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        daoCounters.inc(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> get(String name) {
        log.debug("CounterService: use 'get ({})'", name);
        if (name.length() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!daoCounters.isHave(name)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(daoCounters.get(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Counter> delete(String name) {
        log.debug("CounterService: use 'delete ({})'", name);
        if (name.length() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!daoCounters.isHave(name)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        daoCounters.delete(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> sum() {
        log.debug("CounterService: use 'sum'");
        return new ResponseEntity<>(daoCounters.sum(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Set<String>> showNames() {
        log.debug("CounterService: use 'showNames'");
        return new ResponseEntity<>(daoCounters.showNames(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Counter> isHave(String name) {
        log.debug("CounterService: use 'isHave ({})'", name);
        if (name.length() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (daoCounters.isHave(name)) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
