package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.util.List;

/**
 * Класс, отображающий список пользователей.
 */
public class ShowPersons extends AbstractItems implements Exec {

    /**
     * Заполнение имени класса для отображения в списке меню.
     */
    public ShowPersons() {
        this.name = "Вывод всех пользователей на экран";
    }

    /**
     * Основная функция. Выводит на экран всех пользователей, состоящих в списке.
     * @param data список пользователей.
     */
    @Override
    public void exec(List<Person> data) {
        System.out.println("Список всех пользователей: ");
        for (Person person : data) {
            System.out.println(person);
        }
    }
}
