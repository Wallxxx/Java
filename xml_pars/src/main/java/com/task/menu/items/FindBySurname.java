package com.task.menu.items;

import com.task.employee.Employee;
import com.task.memory.DocumentData;

import java.util.Objects;

public class FindBySurname {

    public static void findBySurname(String name) {
        for (Employee employee : DocumentData.getData()) {
            if (Objects.equals(employee.getSurname(), name)) {
                System.out.println(employee);
            }
        }
    }
}
