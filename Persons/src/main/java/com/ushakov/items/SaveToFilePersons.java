package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Класс, отвечающий за запись списка пользователей в файл.
 */
public class SaveToFilePersons extends AbstractItems implements Exec {

    /**
     * Заполнение имени класса для отображения в списке меню.
     */
    public SaveToFilePersons() {
        this.name = "Запись всех пользователей в файл";
    }

    /**
     * Основная функция, доступная для использования. Чтение названия файла для последующего
     *   его создания и записи в него списка пользователей.
     * @param data список пользователей.
     */
    @Override
    public void exec(List<Person> data) {
        System.out.print("Введте имя создаваемого файла (без расширения): ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        createFile(data, fileName);
    }

    /**
     * Функция, отвечающая за открытие (и создание в случае отсутствия) файла.
     * @param data список для записи в файл.
     * @param fileName имя файла.
     */
    private void createFile(List<Person> data, String fileName) {
        File file = new File(fileName + ".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(data, file);
    }

    /**
     * Проход по всему списку пользователей и запись каждого из них в файл.
     * @param data список пользователей.
     * @param file имя файла, в который записываются пользователи.
     */
    private void writeToFile(List<Person> data, File file) {
        try {
            FileWriter writer = new FileWriter(file);
            for (Person person : data) {
                writer.write(person.toString() + "\n");
                writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
