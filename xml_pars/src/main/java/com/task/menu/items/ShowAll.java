package com.task.menu.items;

import com.task.employee.Employee;
import com.task.memory.DocumentData;

public class ShowAll {

    public static void showAll() {
        for (Employee employee : DocumentData.getData()) {
            System.out.println(employee);
        }
    }
}
