package com.task.menu.items;

import com.task.employee.Employee;
import com.task.memory.DocumentData;

public class CreateEmployee {

    public static void createEmployee(String name, String surname, String position, Integer salary) {
        DocumentData.getData().add(new Employee(name, surname, position, salary));
    }
}
