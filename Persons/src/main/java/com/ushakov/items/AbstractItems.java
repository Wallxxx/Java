package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.util.List;

/**
 * Общее для "items".
 */
public abstract class AbstractItems implements Exec {
    protected String name;

    public String getName() {
        return name;
    }

    /**
     * Функция, которая будет переопределяться во всех классах-меню.
     * @param data список пользователей.
     */
    @Override
    public void exec(List<Person> data) {

    }
}
