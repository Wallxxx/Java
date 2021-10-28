package com.task.menu;

import com.task.memory.DocumentData;
import com.task.menu.items.ShowAll;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ShowAllTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void initData() {
        DocumentData.load();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void FindBySurnameTest() {
        ShowAll.showAll();
        Assert.assertEquals("Employee{id=1, name='Иван', surname='Иванов', position='Менеджер', salary=80000}\n" +
                "Employee{id=2, name='Максим', surname='Wallxxx', position='Основатель', salary=965000}\n" +
                "Employee{id=3, name='Денис', surname='Фостер', position='Менеджер', salary=75000}\n" +
                "Employee{id=4, name='Иван', surname='Иванов', position='Разработчик', salary=135000}\n" +
                "Employee{id=5, name='Иван', surname='Иванов', position='Тестировщик', salary=140000}\n", outContent.toString());
    }

    @After
    public void cleanData() {
        DocumentData.getData().clear();
        System.setOut(originalOut);
    }
}
