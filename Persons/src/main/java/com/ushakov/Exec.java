package com.ushakov;

import com.ushakov.persons.Person;

import java.util.List;

public interface Exec {
    void exec(List<Person> data) throws Exception;
}
