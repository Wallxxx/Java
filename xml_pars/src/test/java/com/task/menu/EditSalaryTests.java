package com.task.menu;

import com.task.memory.DocumentData;
import com.task.menu.items.EditSalary;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EditSalaryTests {

    @Before
    public void initData() {
        DocumentData.load();
    }

    @Test
    public void EditSalaryTest() {
        EditSalary.editSalary(1, 10);
        Assert.assertEquals(Integer.valueOf(10), DocumentData.getData().get(0).getSalary());
    }

    @After
    public void cleanData() {
        DocumentData.getData().clear();
    }
}
