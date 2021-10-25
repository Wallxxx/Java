package com.ushakov.items;

import com.ushakov.persons.Person;

import java.util.List;

public class Exit extends AbstractItems {

    public Exit() {
        this.name = "Выход из приложения";
    }

    @Override
    public void exec(List<Person> data) {
        System.exit(0);
    }
}
