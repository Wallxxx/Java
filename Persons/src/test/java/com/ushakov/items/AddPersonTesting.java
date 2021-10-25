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

public class AddPersonTesting {

    private final InputStream originalIn = System.in;

    private final List<Person> data = new ArrayList<>();

    @Before
    public void setStream() {
        ByteArrayInputStream newInput = new ByteArrayInputStream("Maxim Wallxxx".getBytes());
        System.setIn(newInput);
    }

    @Test
    public void AddPersonTest() {
        AddPerson temp = new AddPerson();
        temp.exec(data);

        Assert.assertEquals(1, data.size());
    }

    @After
    public void restoreStream() {
        System.setIn(originalIn);
    }
}
