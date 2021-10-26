package com.rest.dao;

import java.util.Set;

public interface DaoCountersInterface {

    void create(String name);
    void inc(String name);
    Integer get(String name);
    void delete(String name);
    Integer sum();
    Set<String> showNames();
    boolean isHave(String name);
}
