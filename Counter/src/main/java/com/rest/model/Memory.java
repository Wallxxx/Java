package com.rest.model;

import java.util.HashSet;
import java.util.Set;

public class Memory {
    private static final Set<Counter> data = new HashSet<>();

    public Set<Counter> getData() {
        return data;
    }
}
