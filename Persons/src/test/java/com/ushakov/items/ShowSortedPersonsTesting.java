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

public class ShowSortedPersonsTesting { // TODO: Этот тест не проходит, нужен фикс сортировки
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private final List<Person> data =  new ArrayList<>();

    @Before
    public void setStream() {
        data.add(new Person("Alena", "Annet"));
        data.add(new Person("Veronika", "Bosman"));
        data.add(new Person("Daniil", "Aaron"));
        data.add(new Person("Maxim", "Wallxxx"));

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void ShowSortedPersonsTest() {
        ShowSortedPersons temp = new ShowSortedPersons();
        temp.exec(data);

        Assert.assertEquals("Daniil Aaron\n" +
                "Alena Annet\n" +
                "Veronika Bosman\n" +
                "Maxim Wallxxx\n", outContent.toString());
    }

    @After
    public void restoreStream() {
        System.setOut(originalOut);
    }
}
