package com.rest.service;

import com.rest.model.Counter;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface CounterServiceInterface {
    ResponseEntity<Counter> create(String name);
    ResponseEntity<Counter> inc(String name);
    ResponseEntity<Integer> get(String name);
    ResponseEntity<Counter> delete(String name);
    ResponseEntity<Integer> sum();
    ResponseEntity<Set<String>> showNames();
    ResponseEntity<Counter> isHave(String name);
}
