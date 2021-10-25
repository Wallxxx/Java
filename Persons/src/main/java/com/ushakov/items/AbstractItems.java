package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.util.List;

public abstract class AbstractItems implements Exec {
    protected String name;

    public String getName() {
        return name;
    }

    @Override
    public void exec(List<Person> data) {

    }
}
