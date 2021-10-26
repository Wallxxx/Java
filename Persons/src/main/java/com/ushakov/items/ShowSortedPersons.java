package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.util.*;

/**
 * Класс, отвечающий за вывод пользователей на экран в отсортированном порядке.
 *   Сортировка: по полю "lastName".
 *   Удаление дублей: по полю "lastName".
 */
public class ShowSortedPersons extends AbstractItems implements Exec {

    /**
     * Заполнение имени класса для отображения в списке меню.
     */
    public ShowSortedPersons() {
        this.name = "Вывести сортированный по имени список пользователей";
    }

    /**
     * Перегрузка компоратора для сортировка объектов типа "Person" по полю "lastName".
     * @see Person
     */
    private static final Comparator<Person> ALPHABETICAL_ORDER = Comparator.comparing(Person::getLastName);

    /**
     * Сортировка. Функция преобразовывает list объектов типа "Person" в set для удаления дублей.
     *   Далее выполняется обратное преобразование в list и производится сортировка.
     * @see Person
     * @param data список пользователей для отображения.
     */
    @Override
    public void exec(List<Person> data) { // TODO: Избавиться от дублей!!
        data = new ArrayList<>(new HashSet<>(data));
        data.sort(ALPHABETICAL_ORDER);
        for (Person person : data) {
            System.out.println(person);
        }
    }
}
