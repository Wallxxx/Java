package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.util.List;
import java.util.Scanner;

/**
 * Добавление пользователя к списку.
 */
public class AddPerson extends AbstractItems implements Exec {

    private final int firstName = 0;
    private final int lastName = 1;

    /**
     * Заполнение имени класса для отображения в списке меню.
     */
    public AddPerson() {
        this.name = "Добавление нового пользователя";
    }

    /**
     * Выполнение основного действия класса. Для данного класса: добавление к списку.
     * @param data список, в который добавляется пользователь.
     */
    @Override
    public void exec(List<Person> data) {
        System.out.println("Введите имя и фамилию: ");
        String[] info = inputHandler();
        data.add(new Person(info[firstName], info[lastName]));
    }

    /**
     * Добавление пользователя к списку с использованием заранее известных параметров.
     * @param data список, в который добавляется пользователь.
     * @param firstName имя пользователя.
     * @param lastName фамилия пользователя.
     */
    public void pushData(List<Person> data, String firstName, String lastName) {
        data.add(new Person(firstName, lastName));
    }

    /**
     * Чтение строки из потока "in" и разбитие её на две части: фамилия и имя. Для разбиения
     *   нужно, чтобы имя и фамилия были разделены между собой одним пробелом.
     * @return массив строк.
     */
    private String[] inputHandler() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(" ");
    }
}
