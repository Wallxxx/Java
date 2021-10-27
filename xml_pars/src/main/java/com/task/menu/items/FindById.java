package com.task.menu.items;

import com.task.employee.Employee;
import com.task.memory.DocumentData;

import java.util.Objects;

public class FindById {

    public static void findById(Integer id) {
        for (Employee employee : DocumentData.getData()) {
            if (Objects.equals(employee.getId(), id)) {
                System.out.println(employee);
                break;
            }
        }
    }
}
