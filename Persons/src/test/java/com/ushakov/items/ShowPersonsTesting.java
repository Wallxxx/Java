package com.ushakov.items;

import com.ushakov.persons.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ShowPersonsTesting {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private final List<Person> data =  new ArrayList<>();

    @Before
    public void setStream() {
        data.add(new Person("Maxim", "Wallxxx"));
        data.add(new Person("DDWWW%", "'"));

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void ShowPersonTest() {
        ShowPersons temp = new ShowPersons();
        temp.exec(data);

        Assert.assertEquals("Список всех пользователей: \nMaxim Wallxxx\nDDWWW% '\n", outContent.toString());
    }

    @After
    public void restoreStream() {
        System.setOut(originalOut);
    }
}
