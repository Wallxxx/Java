package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.util.Comparator;
import java.util.List;

public class ShowSortedPersons extends AbstractItems implements Exec {

    public ShowSortedPersons() {
        this.name = "Вывести сортированный по имени список пользователей";
    }

    @Override
    public void exec(List<Person> data) {
        data.sort(ALPHABETICAL_ORDER);
        for (Person person : data) {
            System.out.println(person);
        }
    }

    private static final Comparator<Person> ALPHABETICAL_ORDER = (o1, o2) -> {
        int result = String.CASE_INSENSITIVE_ORDER.compare(o1.getLastName(), o2.getLastName());
        if (result == 0) {
            result = o1.getLastName().compareTo(o2.getLastName());
        }
        return result;
    };

}
