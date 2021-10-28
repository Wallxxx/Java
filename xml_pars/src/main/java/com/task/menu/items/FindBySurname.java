package com.task.menu.items;

import com.task.employee.Employee;
import com.task.memory.DocumentData;

import java.util.Objects;

/**
 * Поиск по фамилии.
 */
public class FindBySurname {


    /**
     * Поиск и вывод на экран всей информации о пользователе с указанной фамилией. Если пользователей с
     *   данной фамилией несколько, будет выведена вся информация по всем пользователям с указанной
     *   фамилией
     * @param surname фамилия.
     */
    public static void findBySurname(String surname) {
        for (Employee employee : DocumentData.getData()) {
            if (Objects.equals(employee.getSurname(), surname)) {
                System.out.println(employee);
            }
        }
    }
}
