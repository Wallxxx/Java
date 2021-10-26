package com.ushakov.items;

import com.ushakov.persons.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveToFilePersonsTests {

    private final InputStream originIn = System.in;

    private final List<Person> data = new ArrayList<>();

    @Before
    public void setStream() {
        AddPerson additional = new AddPerson();
        additional.pushData(data, "Maxim", "Wallxxx");
        ByteArrayInputStream newInput = new ByteArrayInputStream("persons".getBytes());
        System.setIn(newInput);
    }

    @Test
    public void SaveToFilePersonsTest () {
        SaveToFilePersons temp = new SaveToFilePersons();
        temp.exec(data);

        String info = null;
        File file = new File("persons.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                info = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("Maxim Wallxxx", info);
    }

    @After
    public void restoreStream() {
        System.setIn(originIn);
    }
}
