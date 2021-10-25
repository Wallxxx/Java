package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.util.List;

public class ShowPersons extends AbstractItems implements Exec {

    public ShowPersons() {
        this.name = "Вывод всех пользователей на экран";
    }

    @Override
    public void exec(List<Person> data) {
        System.out.println("Список всех пользователей: ");
        for (Person person : data) {
            System.out.println(person);
        }
    }
}
