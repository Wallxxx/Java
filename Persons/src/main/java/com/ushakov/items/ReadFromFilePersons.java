package com.ushakov.items;

import com.ushakov.Exec;
import com.ushakov.persons.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ReadFromFilePersons extends AbstractItems implements Exec {

    private final int firstName = 0;
    private final int lastName = 1;

    public ReadFromFilePersons() {
        this.name = "Чтение пользователей из файла";
    }

    @Override
    public void exec(List<Person> data) {
        System.out.print("Введте название файла (без расширения): ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        readFromFile(data, fileName);
    }

    private void readFromFile(List<Person> data, String fileName) {
        File file = new File(fileName + ".txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] info = scanner.nextLine().split(" ");
                data.add(new Person(info[firstName], info[lastName]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
