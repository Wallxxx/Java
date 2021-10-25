package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.util.List;
import java.util.Scanner;

public class AddPerson extends AbstractItems implements Exec {

    private final int firstName = 0;
    private final int lastName = 1;

    public AddPerson() {
        this.name = "Добавление нового пользователя";
    }

    @Override
    public void exec(List<Person> data) {
        System.out.println("Введите имя и фамилию: ");
        String[] info = inputHandler();
        data.add(new Person(info[firstName], info[lastName]));
    }

    private String[] inputHandler() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(" ");
    }
}
