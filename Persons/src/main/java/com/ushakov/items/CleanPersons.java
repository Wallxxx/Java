package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.util.List;

/**
 * Отчистка списка.
 */
public class CleanPersons extends AbstractItems implements Exec {

    /**
     * Заполнение имени класса для отображения в списке меню.
     */
    public CleanPersons() {
        this.name = "Удаление всех пользователей";
    }

    /**
     * Отчистка списка, поступившего в качестве аргумента.
     * @param data список для отчистки.
     */
    @Override
    public void exec(List<Person> data) {
        data.clear();
        System.out.print("Все пользователи удалены. ");
    }
}
