package com.rest.dao;

import java.util.Set;

/**
 * Интерфейс DAO.
 */
public interface DaoCountersInterface {

    /**
     * Создание нового счётчика.
     * @param name имя нового счётчика.
     */
    void create(String name);

    /**
     * Инкремент значения счётчика по имени.
     * @param name имя счётчика.
     */
    void inc(String name);

    /**
     * Получение значения счётчика по имени.
     * @param name имя счётчика.
     * @return значение.
     */
    Integer get(String name);

    /**
     * Удаление счётчика по имени.
     * @param name имя счётчика.
     */
    void delete(String name);

    /**
     * Получение суммы значений всех счётчиков.
     * @return сумма значений.
     */
    Integer sum();

    /**
     * Получение списка имён всех счётчиков.
     * @return список имён.
     */
    Set<String> showNames();

    /**
     * Проверка на наличие счётчика с указанным именем.
     * @param name имя счётчика.
     * @return истина, если есть; ложь - если отсутствует.
     */
    boolean isHave(String name);
}
