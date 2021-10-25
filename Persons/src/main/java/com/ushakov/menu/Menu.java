package com.ushakov.menu;

import com.ushakov.items.*;
import com.ushakov.persons.PersonData;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final List<AbstractItems> menu;

    public Menu() {
        menu = new ArrayList<>();
        menu.add(new AddPerson());
        menu.add(new ShowPersons());
        menu.add(new ShowSortedPersons());
        menu.add(new SaveToFilePersons());
        menu.add(new ReadFromFilePersons());
        menu.add(new CleanPersons());
        menu.add(new Exit());
    }

    public void showMenu() {
        int number = 1;
        System.out.println("Выберете действие (цифру):");
        for (AbstractItems item : menu) {
            System.out.println(number + ") " + item.getName());
            number += 1;
        }
        readAnswer();
    }

    private void readAnswer() {
        Scanner scanner = new Scanner(System.in);
        try {
            int number = scanner.nextInt();
            exec(number);
        } catch (InputMismatchException e) {
            System.out.println("Некорректный ввод. ");
        }
    }

    private void exec(int number) {
        if (number > menu.size() || number < 1) System.out.println("Выбран несуществующий пункт. ");
        else menu.get(number - 1).exec(PersonData.getPersonsData());
    }
}
