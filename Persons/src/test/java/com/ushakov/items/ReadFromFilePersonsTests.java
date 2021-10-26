package com.ushakov.items;

import com.ushakov.persons.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFilePersonsTests {

    private final InputStream originIn = System.in;

    private final List<Person> data = new ArrayList<>();

    @Before
    public void setStream() {
        AddPerson additional = new AddPerson();
        additional.pushData(data, "Maxim", "Wallxxx");

        ByteArrayInputStream fileName = new ByteArrayInputStream("persons".getBytes());
        System.setIn(fileName);

        SaveToFilePersons save = new SaveToFilePersons();
        save.exec(data);

        System.setIn(originIn);

        data.clear();

        fileName = new ByteArrayInputStream("persons".getBytes());
        System.setIn(fileName);
    }

    @Test
    public void ReadFromFilePersonsTest () {

        ReadFromFilePersons temp = new ReadFromFilePersons();
        temp.exec(data);
        Assert.assertEquals(1, data.size());
        Assert.assertEquals("Maxim", data.get(0).getFirstName());
        Assert.assertEquals("Wallxxx", data.get(0).getLastName());
    }

    @After
    public void restoreStream() {
        System.setIn(originIn);
    }
}
