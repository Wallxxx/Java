package com.task.menu.items;

import com.task.employee.Employee;
import com.task.memory.DocumentData;

import java.util.Objects;

/**
 * Редактирование зарплаты.
 */
public class EditSalary {

    /**
     * Изменение зарплаты указанного (по полю "id") пользователя на указанную зарплату.
     * @param id "id" пользователя.
     * @param value новая зарплата.
     */
    public static void editSalary(Integer id, Integer value) {
        for (Employee employee : DocumentData.getData()) {
            if (Objects.equals(employee.getId(), id)) {
                employee.setSalary(value);
                break;
            }
        }
    }
}
