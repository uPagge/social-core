package org.sadtech.social.core.service;

import org.sadtech.social.core.domain.content.Message;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Интерфейс взаимодйствия с наследниками текстовых запросов пользователей.
 *
 * @author upagge [08/07/2019]
 */
public interface MessageService<T extends Message> {

    void add(T event);

    /**
     * Получить список сообщений за заданный временной интервал
     * @param timeFrom Начало интервала
     * @param timeTo Конец интервала
     * @return Список сообщений
     */
    List<T> getByTime(LocalDateTime timeFrom, LocalDateTime timeTo);

    /**
     * Получить список ПОСЛЕДНИХ сообщений для каждого пользователя за заданных временной интервал
     * @param timeFrom Начало интервала
     * @param timeTo Конец интервала
     * @return Список сообщений
     */
    List<T> getLastEventByTime(LocalDateTime timeFrom, LocalDateTime timeTo);

}
