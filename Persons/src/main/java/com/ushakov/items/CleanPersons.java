package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.util.List;

public class CleanPersons extends AbstractItems implements Exec {

    public CleanPersons() {
        this.name = "Удаление всех пользователей";
    }

    @Override
    public void exec(List<Person> data) {
        data.clear();
        System.out.print("Все пользователи удалены. ");
    }
}
