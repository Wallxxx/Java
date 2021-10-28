package com.task.menu;

import com.task.memory.DocumentData;
import com.task.menu.items.FindBySurname;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FindBySurnameTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void initData() {
        DocumentData.load();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void FindBySurnameTest() {
        FindBySurname.findBySurname("Иванов");
        Assert.assertEquals("Employee{id=1, name='Иван', surname='Иванов', position='Менеджер', salary=80000}\n" +
                "Employee{id=4, name='Иван', surname='Иванов', position='Разработчик', salary=135000}\n" +
                "Employee{id=5, name='Иван', surname='Иванов', position='Тестировщик', salary=140000}\n", outContent.toString());
    }

    @Test
    public void FindBySurnameNotFoundTest() {
        FindBySurname.findBySurname("Иго-го");
        Assert.assertEquals("", outContent.toString());
    }

    @After
    public void cleanData() {
        DocumentData.getData().clear();
        System.setOut(originalOut);
    }
}
