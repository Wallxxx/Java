package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.util.Comparator;
import java.util.List;

public class ShowSortedPersons extends AbstractItems implements Exec {

    public ShowSortedPersons() {
        this.name = "Вывести сортированный по имени список пользователей";
    }

    private static final Comparator<Person> ALPHABETICAL_ORDER = Comparator.comparing(Person::getLastName);

    @Override
    public void exec(List<Person> data) { // TODO: Избавиться от дублей!!
        data.sort(ALPHABETICAL_ORDER);
        for (Person person : data) {
            System.out.println(person);
        }
    }
}
