package com.task.menu.items;

import com.task.employee.Employee;
import com.task.memory.DocumentData;

import java.util.Objects;

/**
 * Поиск пользователя по "id".
 */
public class FindById {

    /**
     * Поиск и вывод на экран всей информации о пользователе по его "id".
     * @param id "id" пользователя.
     */
    public static void findById(Integer id) {
        for (Employee employee : DocumentData.getData()) {
            if (Objects.equals(employee.getId(), id)) {
                System.out.println(employee);
                break;
            }
        }
    }
}
