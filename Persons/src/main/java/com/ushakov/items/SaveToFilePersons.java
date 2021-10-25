package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SaveToFilePersons extends AbstractItems implements Exec {

    public SaveToFilePersons() {
        this.name = "Запись всех пользователей в файл";
    }

    @Override
    public void exec(List<Person> data) {
        System.out.print("Введте имя создаваемого файла (без расширения): ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        createFile(data, fileName);
    }

    private void createFile(List<Person> data, String fileName) {
        File file = new File(fileName + ".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(data, file);
    }

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
