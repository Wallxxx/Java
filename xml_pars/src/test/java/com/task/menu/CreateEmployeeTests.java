package com.task.menu;

import com.task.memory.DocumentData;
import com.task.menu.items.CreateEmployee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateEmployeeTests {

    @Before
    public void initData() {
        DocumentData.load();
    }

    @Test
    public void CreateEmployeeTest() {
        CreateEmployee.createEmployee("Денис", "Иванов", "Менеджер", 70000);
        Assert.assertEquals(6, DocumentData.getData().size());
    }

    @After
    public void cleanData() {
        DocumentData.getData().clear();
    }
}
