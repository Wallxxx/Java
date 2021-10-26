package com.ushakov.items;

import com.ushakov.persons.Person;

import java.util.List;

/**
 * Завершение работы.
 */
public class Exit extends AbstractItems {

    /**
     * Заполнение имени класса для отображения в списке меню.
     */
    public Exit() {
        this.name = "Выход из приложения";
    }

    /**
     * Выход из программы.
     * @param data список пользователей.
     */
    @Override
    public void exec(List<Person> data) {
        System.exit(0);
    }
}
