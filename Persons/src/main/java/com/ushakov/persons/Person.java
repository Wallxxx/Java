package com.ushakov.persons;

import java.util.Objects;

/**
 * Класс "Person". Содержит поля с именем и фамилией, а также методы для работы с данными полями.
 */
public class Person {
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Сравнение объектов типа "Person" по полю "lastName".
     * @param o - второй объект для сравнения.
     * @return результат сравнения.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(lastName, person.lastName);
    }

    /**
     * Вычисление хёш-кода только по полю "lastName".
     * @return хэш-код.
     */
    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}