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
     *
     * @param timeFrom Начало интервала
     * @param timeTo   Конец интервала
     * @return Список сообщений
     */
    List<T> getByAddDateTime(LocalDateTime timeFrom, LocalDateTime timeTo);

    /**
     * Получить список ПОСЛЕДНИХ сообщений для каждого пользователя за заданных временной интервал
     *
     * @param timeFrom Начало интервала
     * @param timeTo   Конец интервала
     * @return Список сообщений
     */
    List<T> getLastEventByCreateDateTime(LocalDateTime timeFrom, LocalDateTime timeTo);

    List<T> getLastEventByAddDateTime(LocalDateTime timeFrom, LocalDateTime timeTo);

    /**
     * Возвращает новые сообщения пользователей по дате добавления в хранилище.
     *
     * @param now Текущяя дата и время
     * @return Последнее сообщение пользователя от последней переданной даты now
     */
    List<T> getNewMessage(LocalDateTime now);

}
