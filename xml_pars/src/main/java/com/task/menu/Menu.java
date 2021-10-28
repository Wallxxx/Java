package com.task.menu;

import com.task.memory.DocumentData;
import com.task.menu.items.*;

import java.util.Scanner;

public class Menu {

    public void showMenu() {
        try {
            DocumentData.load();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("[ERROR] Не удалось спарсить xml файл. Завершение работы. ");
            System.exit(-1);
        }
        while (true) {
            showMessages();
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.length() > 2 || choice.length() == 0) {
                System.out.println("Некорректный ввод, попробуйте снова.");
                continue;
            }
            switch (choice) {
                case "1":
                    System.out.print("Введите id пользователя: ");
                    FindById.findById(Integer.parseInt(scanner.nextLine()));
                    break;
                case "2":
                    System.out.print("Введите фамилию пользователя: ");
                    FindBySurname.findBySurname(scanner.nextLine());
                    break;
                case "3":
                    System.out.print("Введите id пользователя и его новую зарплату (через пробел): ");
                    EditSalary.editSalary(scanner.nextInt(), scanner.nextInt());
                    break;
                case "4":
                    System.out.print("Введите данные нового пользователя (без id, через пробел): ");
                    String[] info = scanner.nextLine().split(" ");
                    if (info.length != 4) System.out.println("Указано неверное количество параметров. ");
                    else {
                        CreateEmployee.createEmployee(info[0], info[1], info[2], Integer.parseInt(info[3]));
                    }
                    break;
                case "5":
                    ShowAll.showAll();
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод, попробуйте снова.");
            }
        }
    }

    private void showMessages() {
        System.out.println("1) Поиск по id");
        System.out.println("2) Поиск по фамилии");
        System.out.println("3) Редактирование зарплаты сотрудника");
        System.out.println("4) Добавление нового сотрудника");
        System.out.println("5) Вывод всех сотрудников");
        System.out.println("6) Выход");
        System.out.print("Выберите пункт меню (цифру): ");
    }
}
