package com.rest.service;

import com.rest.model.Counter;
import org.springframework.http.ResponseEntity;

import java.util.Set;

/**
 * Интерфейс сервиса управления счётчиками.
 */
public interface CounterServiceInterface {

    /**
     * Добавление нового счётчика с уникальным именем.
     * @param name имя нового счётчика.
     * @return http статус.
     */
    ResponseEntity<Counter> create(String name);

    /**
     * Инкремент счётчика с указанным именем.
     * @param name имя счётчика
     * @return http статус.
     */
    ResponseEntity<Counter> inc(String name);

    /**
     * Получение значения указанного счётчика.
     * @param name имя счётчика.
     * @return значение, http статус.
     */
    ResponseEntity<Integer> get(String name);

    /**
     * Удаление указанного счётчика.
     * @param name имя счётчика.
     * @return http статус.
     */
    ResponseEntity<Counter> delete(String name);

    /**
     * Суммирование значений всех счётчиков.
     * @return сумма значений, http статус.
     */
    ResponseEntity<Integer> sum();

    /**
     * Получение списка имён всех счётчиков.
     * @return список имён, http статус.
     */
    ResponseEntity<Set<String>> showNames();

    /**
     * Проверка на наличие счётчика.
     * @param name имя счётчика.
     * @return http статус ("FOUND" или "NOT_FOUND").
     */
    ResponseEntity<Counter> isHave(String name);
}
