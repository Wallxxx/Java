package com.ushakov.items;

import com.ushakov.persons.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CleanPersonsTesting {

    private final List<Person> data = new ArrayList<>();

    @Before
    public void start() {
        data.add(new Person("Alena", "Annet"));
        data.add(new Person("Veranika", "Bosman"));
        data.add(new Person("Daniil", "Aaron"));
        data.add(new Person("Maxim", "Wallxxx"));
    }

    @Test
    public void CleanPersonsTest() {
        CleanPersons temp = new CleanPersons();
        temp.exec(data);
        Assert.assertEquals(0, data.size());
    }
}
