package com.task.menu.items;

import com.task.employee.Employee;
import com.task.memory.DocumentData;

/**
 * Показ всех пользователей.
 */
public class ShowAll {

    /**
     * Вывод списка всех пользователей и полной информации о них на экран.
     */
    public static void showAll() {
        for (Employee employee : DocumentData.getData()) {
            System.out.println(employee);
        }
    }
}
