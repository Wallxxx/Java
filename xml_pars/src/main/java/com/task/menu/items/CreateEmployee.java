package com.task.menu.items;

import com.task.employee.Employee;
import com.task.memory.DocumentData;

/**
 * Создание нового пользователя.
 */
public class CreateEmployee {

    /**
     * Добавление нового пользователя в лист по указанным параметрам, кроме поля "id". Поле
     *   "id" считается автоматически.
     * @param name имя.
     * @param surname фамилия.
     * @param position должность.
     * @param salary зарплата.
     */
    public static void createEmployee(String name, String surname, String position, Integer salary) {
        DocumentData.getData().add(new Employee(name, surname, position, salary));
    }
}
