package com.task.menu;

import com.task.memory.DocumentData;
import com.task.menu.items.FindById;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FindByIdTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void initData() {
        DocumentData.load();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void EditSalaryTest() {
        FindById.findById(1);
        Assert.assertEquals("Employee{id=1, name='Иван', surname='Иванов', position='Менеджер', salary=80000}\n", outContent.toString());
    }

    @Test
    public void EditSalaryNotFoundTest() {
        FindById.findById(10);
        Assert.assertEquals("", outContent.toString());
    }

    @Test
    public void EditSalaryBadIdTest() {
        FindById.findById(-1);
        Assert.assertEquals("", outContent.toString());
    }

    @After
    public void cleanData() {
        DocumentData.getData().clear();
        System.setOut(originalOut);
    }
}
