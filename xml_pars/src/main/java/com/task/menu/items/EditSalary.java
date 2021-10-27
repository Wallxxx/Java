package com.task.menu.items;

import com.task.employee.Employee;
import com.task.memory.DocumentData;

import java.util.Objects;

public class EditSalary {

    public static void editSalary(Integer id, Integer value) {
        for (Employee employee : DocumentData.getData()) {
            if (Objects.equals(employee.getId(), id)) {
                employee.setSalary(value);
                break;
            }
        }
    }
}
