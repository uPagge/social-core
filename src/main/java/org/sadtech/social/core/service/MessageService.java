package org.sadtech.social.core.service;

import lombok.NonNull;
import org.sadtech.social.core.domain.content.Message;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Интерфейс взаимодйствия с наследниками текстовых сообщений пользователей.
 *
 * @author upagge [08/07/2019]
 */
public interface MessageService<T extends Message> {

    void add(@NonNull T event);

    /**
     * Получить список сообщений за заданный временной интервал
     *
     * @param timeFrom Начало интервала
     * @param timeTo   Конец интервала
     * @return Список сообщений
     */
    List<T> getByAddDateTime(@NonNull LocalDateTime timeFrom, @NonNull LocalDateTime timeTo);

    /**
     * Получить список ПОСЛЕДНИХ сообщений для каждого пользователя за заданных временной интервал
     *
     * @param timeFrom Начало интервала
     * @param timeTo   Конец интервала
     * @return Список сообщений
     */
    List<T> getLastEventByCreateDateTime(@NonNull LocalDateTime timeFrom, @NonNull LocalDateTime timeTo);

    List<T> getLastEventByAddDateTime(@NonNull LocalDateTime timeFrom, @NonNull LocalDateTime timeTo);

    /**
     * Возвращает новые сообщения от последнего запроса.
     */
    List<T> getNewMessage();

}
